/**
 * Codeforces Round 952 Division 4
 * Manhattan Circle
 * Link: https://codeforces.com/problemset/problem/1985/D
 */
import java.util.*;
public class Manhattan_Circle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int _t=0; _t<t; _t++) {
            int rows = in.nextInt(), cols = in.nextInt();
            int[] hashs_in_col = new int[cols];
            int hashs_in_curr_row = -1, max_hashs_in_row = -1, row_with_max_hashs = -1; boolean found = false;
            for(int i=0; i<rows; i++) {
                hashs_in_curr_row = 0;
                String input = in.next();
                if(!found) {
                    for(int j=0; j<cols; j++) {
                        char ch = input.charAt(j);
                        if(ch == '#') {
                            hashs_in_curr_row++;
                            hashs_in_col[j]++;
                        }
                    }
                    if(hashs_in_curr_row > max_hashs_in_row) {
                        max_hashs_in_row = hashs_in_curr_row;
                        row_with_max_hashs = i;
                    } else if(hashs_in_curr_row < max_hashs_in_row) {
                        found = true;
                    }
                }
            }
            in.close();
            int col_with_max_hashs = -1, max_hashs_in_col = -1;
            for(int i=0; i<hashs_in_col.length; i++) {
                if(hashs_in_col[i] > max_hashs_in_col) {
                    max_hashs_in_col = hashs_in_col[i];
                    col_with_max_hashs = i;
                }
            }
            System.out.println((row_with_max_hashs + 1) + " " + (col_with_max_hashs + 1));
        }
    }
}
