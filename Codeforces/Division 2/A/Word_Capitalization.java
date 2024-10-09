/**
 * Codeforces Round 85 Division 2
 * Word Capitalization
 * Link: https://codeforces.com/problemset/problem/281/A
 */
import java.util.*;
 public class Word_Capitalization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        String ans = "" + Character.toUpperCase(input.charAt(0)) + input.substring(1);
        System.out.println(ans);
    }
}
