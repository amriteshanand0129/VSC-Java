/**
 * Codeforces Round 189 Division 2
 * Magic Number
 * Link: https://codeforces.com/problemset/problem/320/A
 */

import java.util.*;
public class Magic_Number {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        in.close();
        int index = 0, l = num.length();
        boolean isMagic = true;
        while(index < l) {
            if(index + 2 < l) {
                if(num.substring(index, index+3).equals("144")) {
                    index = index+3;
                    continue;
                }
            } 
            if(index + 1 < l) {
                if(num.substring(index, index+2).equals("14")) {
                    index = index+2;
                    continue;
                }
            }
            if(num.charAt(index) == '1') {
                index++;
                continue;
            } else {
                isMagic = false;
                break;
            }
        }
        if(isMagic)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}