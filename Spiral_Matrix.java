import java.util.*;
public class Spiral_Matrix {
    public static ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;
        ArrayList<Integer> arr = new ArrayList<>();
    
        while (row_start <= row_end && col_start <= col_end) {
            // Traverse the top row
            for (int col = col_start; col <= col_end; col++) {
                arr.add(matrix[row_start][col]);
            }
            row_start++;
    
            // Traverse the right column
            for (int row = row_start; row <= row_end; row++) {
                arr.add(matrix[row][col_end]);
            }
            col_end--;
    
            // Traverse the bottom row
            if (row_start <= row_end) {
                for (int col = col_end; col >= col_start; col--) {
                    arr.add(matrix[row_end][col]);
                }
                row_end--;
            }
    
            // Traverse the left column
            if (col_start <= col_end) {
                for (int row = row_end; row >= row_start; row--) {
                    arr.add(matrix[row][col_start]);
                }
                col_start++;
            }
        }
    
        return arr;
    }
    
    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                System.out.printf("%-3d", matrix[i][j]);
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Rows: ");
        int row = in.nextInt();
        System.out.print("Columns: ");
        int col = in.nextInt();
        int matrix[][] = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();

        // Printing the original matrix
        System.out.println("\nOriginal Matrix -");
        printMatrix(matrix);

        // Printing the spiral matrix
        System.out.println("\nSpiral Matrix - ");
        System.out.println(spirallyTraverse(matrix));

        /**
         * The code below could work for square matrix but not for rectangular matrices
         * The function spirallyTraverse works fine for every-shaped matrix
         
            System.out.println("n: ");
            int n = in.nextInt();
            int matrix[][]=new int[n][n];
            int r=matrix.length;
            int c=matrix[0].length;
            int x=10;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    matrix[i][j]=x;
                    x++;
                }
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(matrix[i][j]+" ");
                }System.out.println();
            }
            int rowmax=r-1, colmax=c-1, rowmin=0, colmin=0, row=0, col=0;
            // The condition in while loop ensures complete printing of matrix of even odd order.
            // The condition of count++ of mine would not work for some odd order matrices.
            // Moreover if condition in 2nd and 3rd loop if for mxn order matrices where either row/column is greater.
            while(rowmin<=rowmax && colmin<=colmax){
                row = rowmin;
                for(int i=colmin;i<=colmax;i++){
                    System.out.print(matrix[row][i]+" ");
                }rowmin++;
                col = colmax;
                for(int i=rowmin;i<=rowmax;i++){
                    if(rowmin == rowmax)
                        break;
                    System.out.print(matrix[i][col]+" ");
                }colmax--;
                row = rowmax;
                for(int i=colmax;i>=colmin;i--){
                    if(colmin == colmax)
                        break;
                    System.out.print(matrix[row][i]+" ");
                }rowmax--;
                col=colmin;
                for(int i=rowmax;i>=rowmin;i--){
                    System.out.print(matrix[i][col]+" ");
                }colmin++;
                in.close();
            }
        */
    }  
}
