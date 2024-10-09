/**
 * Codeforces Round 161 Division 2
 * Beautiful Matrix
 * Link: https://codeforces.com/problemset/problem/263/A
 */
import java.util.*;
public class Beautiful_Matrix {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            int row = 0, col = 0;
            for(int i=1; i<=5; i++) {
                for(int j=1; j<=5; j++) {
                    if(in.nextInt() == 1) {
                        row = i; col = j;
                    }
                }
            }
            System.out.println(Math.abs(row-3) + Math.abs(col-3));
        }
    }
}