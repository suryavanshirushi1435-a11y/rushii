import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] a = new int[3][3];
        int[][] b = new int[3][3];
        int[][] result = new int[3][3];

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

        // Multiply matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
                }
            }
        }

        // Print result
        System.out.println("Multiplication of matrices:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}