public class NQueen {
    public static void queen(char board[][], int row) {
        if(row==board.length) {
            System.out.println("----Chess board pattern----");
            count++;
            printboard(board);
            return;
        }
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j) == true) {
                board[row][j] = 'Q';
                queen(board, row+1);
                board[row][j] = '.';
            }
            else
                continue;
        }
    }
    public static boolean isSafe(char board[][], int row, int column) {
        for(int i=0; i<row; i++) {
                if(board[i][column] != '.') 
                    return false;
                if(column-row+i >= 0)
                    if(board[i][column-row+i] != '.') 
                        return false;
                if(column+row-i < board.length)
                    if(board[i][column+row-i] != '.')
                        return false;
        }
        return true;
    }
    public static void printboard(char board[][]) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void main(String args[]) {
        int n = 5;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) 
            for(int j=0; j<n; j++) 
                board[i][j] = '.';
        queen(board, 0);
        System.out.println("Total number of possible ways " + count);
    }
}