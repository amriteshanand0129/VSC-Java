/**
 * Codeforces Beta Round 952 Division 2
 * Watermelon
 * Link: https://codeforces.com/problemset/problem/4/A
 */
import java.util.*;
public class Watermelon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 2 || n % 2 != 0)
            System.out.println("NO");
        else    
            System.out.println("YES");
        in.close();
    }
}
