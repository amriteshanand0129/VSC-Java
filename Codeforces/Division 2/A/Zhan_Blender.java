/**
 * Codeforces Round 973 Division 2
 * Zhan's Blender
 * Link: https://codeforces.com/problemset/problem/2013/A
 */
import java.util.*;
public class Zhan_Blender {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++) {
            double n = in.nextInt(), x = in.nextInt(), y = in.nextInt();
            int ans = (int)Math.ceil(n / Math.min(x, y));
            System.out.println(ans);
        }
        in.close();
    }
}