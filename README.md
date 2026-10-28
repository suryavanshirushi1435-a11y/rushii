# Flashcard Quizzer

A simple command-line flashcard app written in Python. It loads questions from a text file, quizzes you in random order, and saves your scores so you can track progress.

## Requirements

- Python 3.8 or newer. No external libraries are needed.

## Usage

Run with the default question file (`questions.txt`):

```bash
python app.py
```

Or point it at any question file:

```bash
python app.py my_subject.txt
```

### Question file format

One card per line, with the question and answer separated by `|`:

```
What is the capital of Karnataka? | Bengaluru
```

- Lines starting with `#` are comments and are ignored.
- Blank lines are ignored.
- Answers are not case-sensitive, and extra spaces are ignored.
- Type `q` at any question to stop early. The score for the questions you answered is still saved.

### Output

After each quiz, the app prints your score and the questions you missed. Each result is appended to `scores.csv` with the date, file name, score, total, and percentage.

## Project files

- `app.py`: the quiz program
- `questions.txt`: sample questions (replace with your own)
- `scores.csv`: created automatically after your first quiz

## Publishing to GitHub

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPO.git
git push -u origin main
```

`scores.csv` is personal progress data, so you may want to exclude it from GitHub. Create a `.gitignore` file containing this line before your first commit:

```
scores.csv
```

## Ideas for next steps

- Accept multiple correct answers per card
- Shuffle only the cards you missed last time
- Add a timer for each question
