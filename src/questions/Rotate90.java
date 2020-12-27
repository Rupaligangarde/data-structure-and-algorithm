package questions;

public class Rotate90 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int n = matrix.length;

        //clockwise 90
        transpose(matrix, n);
        reverseColumns(matrix, n);
        printMatrix(matrix, 3, 3);

        System.out.println("====================");


        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        //anti-clockwise 90
        int m = matrix1.length;
        transpose(matrix1, m);
        reverseRows(matrix1, m);
        printMatrix(matrix1, 3, 3);


        //clockwise 180
        System.out.println("====================");

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int l = matrix1.length;
        reverseColumns(matrix2, l);
        reverseRows(matrix2, l);
        printMatrix(matrix2, 3, 3);
    }

    private static void reverseColumns(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private static void reverseRows(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix, int rows, int colums) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(matrix[i][j] + ",  ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
