// 12th September
import java.util.*;
class Triangular_Matrix {
    public static void printLowerMatrix(int[][] matrix, int row, int col) {
        System.out.println("Lower Triangular Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j <= i)
                    System.out.printf("%3d", matrix[i][j]);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void printUpperMatrix(int[][] matrix, int row, int col) {
        System.out.println("Upper Triangular Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j >= i)
                    System.out.printf("%3d", matrix[i][j]);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix, int row, int col) {
        System.out.println("Original Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void diagonalTraversal(int[][] matrix, int m, int n) {
        System.out.println("\nDiagonal Traversal");
        int direction = 0, row = 0, col = 0;
        while(row < m && col < n) {
            System.out.print(matrix[row][col] + " ");
            if(direction == 0) {
                if(col == n-1) {
                    direction = 1;
                    row++;
                } else if(row == 0) {
                    direction = 1;
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if(row == m-1) {
                    direction = 0;
                    col++;
                } else if(col == 0) {
                    direction = 0;
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
    }

    public static void commonElements(int[][] matrix, int m, int n) {
        HashSet<Integer> firstRow = new HashSet<>();
        for(int i=0; i<n; i++)
            firstRow.add(matrix[0][i]);
        for(int[] row : matrix) {
            HashSet<Integer> set = new HashSet<>();
            for(int i: row)
                set.add(i);
            for(int i: firstRow) {
                if(!set.contains(i)) {
                    int val = i;
                    firstRow.remove(val);
                }
            }
        }
        System.out.println("\n\nCommon Elements in all rows");
        System.out.println(firstRow);
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5 },
                           { 6, 7, 8, 9, 10 },
                           { 11, 12, 13, 14, 15 },
                           { 16, 17, 18, 19, 20 },
                           { 21, 22, 23, 24, 25 } };
        int row = matrix.length, col = matrix[0].length;
        printMatrix(matrix, row, col);
        printUpperMatrix(matrix, row, col);
        printLowerMatrix(matrix, row, col);
        diagonalTraversal(matrix, row, col);

        // Print all the elements which are common in all rows
        int[][] matrix2 = { {1, 2, 0, 3},
                            {2, 5, 4, 0},
                            {1, 1, 2, 0}};
        commonElements(matrix2, matrix2.length, matrix2.length);
    }
}