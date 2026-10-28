import java.util.Scanner;

public class ArrayNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        int largest;
        int smallest;
        int sum = 0;
        int even = 0;
        int odd = 0;

        // Accept 10 integers
        System.out.println("Enter 10 integers:");

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // Assume first element is largest and smallest
        largest = arr[0];
        smallest = arr[0];

        // Find all values
        for (int i = 0; i < 10; i++) {

            sum = sum + arr[i];

            if (arr[i] > largest) {
                largest = arr[i];
            }

            if (arr[i] < smallest) {
                smallest = arr[i];
            }

            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        double average = sum / 10.0;

        System.out.println("Largest element = " + largest);
        System.out.println("Smallest element = " + smallest);
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Number of even elements = " + even);
        System.out.println("Number of odd elements = " + odd);

        sc.close();
    }
}