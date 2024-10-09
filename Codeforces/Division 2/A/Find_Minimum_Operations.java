import java.util.Scanner;

/**
 * Find_Minimum_Operations
 */
public class Find_Minimum_Operations {
    public static int maxPow(int k, int n) {
        int count = 0, _k = k;
        while(k <= n) {
            k = k * _k;
            count++;
        } return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++) {
            int n = in.nextInt(), k = in.nextInt();
            if(k == 1)
                System.out.println(n);
            else {
                int count = 0;
                while(n >= k) {
                    n -= (int)Math.pow(k, maxPow(k, n));
                    count++;
                } count += n;
                System.out.println(count);
            }
        }
        in.close();
    }
}