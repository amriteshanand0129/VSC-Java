/**
 * Codeforces Round 146 Division 2
 * Boy or Girl
 * Link: https://codeforces.com/problemset/problem/236/A
 */
import java.util.*;
public class Boy_or_Girl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        int[] freq = new int[26];
        for(int i=0; i<input.length(); i++) {
            freq[input.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i: freq) {
            if(i >= 1) 
                count++;
        }
        if(count % 2 != 0)
            System.out.println("IGNORE HIM!");
        else
            System.out.println("CHAT WITH HER!");
        }
}
