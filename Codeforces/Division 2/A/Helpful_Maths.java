/**
 * Codeforces Round 197 Division 2
 * Helpful Maths
 * Link: https://codeforces.com/problemset/problem/339/A
 */
import java.util.*;
public class Helpful_Maths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        int[] freq = new int[3];
        for(int i=0; i<input.length(); i+=2) 
            freq[input.charAt(i)-'1']++;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 3; i++) 
            ans.append((i+1 + "+").repeat(freq[i]));
        
        System.out.println(ans.substring(0, ans.length() - 1));
    }
}
