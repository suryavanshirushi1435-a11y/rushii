import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 elements:");

        // Accept array elements
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        // Print array elements
        System.out.println("Array elements are:");

        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
}