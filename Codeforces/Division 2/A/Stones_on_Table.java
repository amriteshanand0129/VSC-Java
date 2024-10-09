/**
 * Codeforces Round 163 Division 2
 * Stones on Table
 * Link: https://codeforces.com/problemset/problem/266/A
 */

import java.util.*;
public class Stones_on_Table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next(); int index = 0, count = 0;
        for(int i=1; i<n; i++) {
            if(s.charAt(i) == s.charAt(index)) {
                count++;
            } else {
                index = i;
            }
        }
        System.out.println(count);
        in.close();
    }
}
