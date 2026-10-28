import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] a = new int[3][3];
        int[][] b = new int[3][3];
        int[][] sum = new int[3][3];

        // Read first matrix
        System.out.println("Enter elements of first matrix:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // Read second matrix
        System.out.println("Enter elements of second matrix:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // Add the matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        // Print result
        System.out.println("Addition of matrices:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
