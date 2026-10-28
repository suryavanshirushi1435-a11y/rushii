import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 elements:");

        // Input array elements
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        int min = arr[0];

        // Find maximum and minimum
        for (int i = 1; i < 5; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);

        sc.close();
    }
}