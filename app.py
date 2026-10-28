#!/usr/bin/env python3
"""Flashcard quizzer: loads questions from a text file and quizzes you.

Question file format (one card per line):
    question | answer

Lines starting with # and blank lines are ignored.
"""

import csv
import random
import sys
from datetime import datetime
from pathlib import Path

DEFAULT_FILE = "questions.txt"
SCORES_FILE = "scores.csv"


def load_cards(path):
    """Read (question, answer) pairs from the file, skipping bad lines."""
    cards = []
    with open(path, encoding="utf-8") as f:
        for line_no, line in enumerate(f, start=1):
            line = line.strip()
            if not line or line.startswith("#"):
                continue
            if "|" not in line:
                print(f"Skipping line {line_no}: missing '|' between question and answer.")
                continue
            question, answer = (part.strip() for part in line.split("|", 1))
            if question and answer:
                cards.append((question, answer))
            else:
                print(f"Skipping line {line_no}: question or answer is empty.")
    return cards


def is_correct(user_answer, correct_answer):
    """Compare answers ignoring case and extra spaces."""
    return " ".join(user_answer.lower().split()) == " ".join(correct_answer.lower().split())


def quiz(cards):
    """Run the quiz. Returns (questions_asked, score, missed_cards)."""
    random.shuffle(cards)
    asked = 0
    score = 0
    missed = []

    for question, answer in cards:
        asked += 1
        print(f"\nQ{asked}/{len(cards)}: {question}")
        user_answer = input("Your answer (or 'q' to stop): ").strip()

        if user_answer.lower() == "q":
            asked -= 1  # this question was not answered
            break

        if is_correct(user_answer, answer):
            print("Correct!")
            score += 1
        else:
            print(f"Wrong. The answer is: {answer}")
            missed.append((question, answer))

        print(f"Score so far: {score}/{asked}")

    return asked, score, missed


def save_score(source_file, score, total):
    """Append the result to scores.csv so you can track progress over time."""
    is_new = not Path(SCORES_FILE).exists()
    percent = round(100 * score / total, 1) if total else 0
    with open(SCORES_FILE, "a", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        if is_new:
            writer.writerow(["date", "file", "score", "total", "percent"])
        writer.writerow([datetime.now().strftime("%Y-%m-%d %H:%M"), source_file, score, total, percent])


def main():
    path = sys.argv[1] if len(sys.argv) > 1 else DEFAULT_FILE

    if not Path(path).exists():
        print(f"File not found: {path}")
        print("Usage: python app.py [questions_file]")
        sys.exit(1)

    cards = load_cards(path)
    if not cards:
        print("No valid questions found. Each line should look like: question | answer")
        sys.exit(1)

    print(f"Loaded {len(cards)} questions from {path}.")
    input("Press Enter to start...")

    asked, score, missed = quiz(cards)

    print("\n" + "=" * 40)
    if asked:
        percent = round(100 * score / asked, 1)
        print(f"Result: {score}/{asked} correct ({percent}%)")
        save_score(path, score, asked)
        print(f"Saved to {SCORES_FILE}.")
    else:
        print("No questions answered.")

    if missed:
        print("\nQuestions to review:")
        for question, answer in missed:
            print(f"  - {question}  ->  {answer}")


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\nQuiz cancelled.")
        sys.exit(0)
