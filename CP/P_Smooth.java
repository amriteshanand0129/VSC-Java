
import java.util.*;
public class P_Smooth {
    static boolean isPrime(int n) {
        if(n == 2)  return true;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0)  
                return false;
        }
        return true;
    }
    static int lpf(int n) {
        int largest = Integer.MIN_VALUE;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0 && isPrime(i)) 
                largest = Math.max(largest, i);
        }
        return largest;
    }
    public static void main(String[] args) {
        int n = 10, p = 5;
        int count = 0, num = 2;
        ArrayList<Integer> ans = new ArrayList<>();
        while(count < n) {
            int largest_prime_factor = lpf(num);
            if(largest_prime_factor <= p) {
                count++;
                ans.add(num);
            }
            num++;
        }
        System.out.println(ans);
    }
}
