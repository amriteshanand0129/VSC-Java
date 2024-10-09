/**
 * Codeforces Round 85 Division 2
 * Petya and Strings
 * Link: https://codeforces.com/problemset/problem/112/A
 */
import java.util.*;
public class Petya_and_Strings {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        in.close();
        a = a.toLowerCase();
        b = b.toLowerCase();
        int ans = a.compareTo(b);
        if(ans < 0)
            ans = -1;
        else if(ans == 0)
            ans = 0;
        else
            ans = 1;
        System.out.println(ans);
    }
}
