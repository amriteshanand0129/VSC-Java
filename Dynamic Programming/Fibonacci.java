import java.util.*;
class Fibonacci {
    public static int fibonacciMemoization(int n, int fib[]) {
        if(n == 0 || n == 1)
            return n;
        if(fib[n] != 0)
            return fib[n];
        fib[n] = fibonacciMemoization(n-1, fib) + fibonacciMemoization(n-2, fib);
        return fib[n];
    }
    public static int fibonacciTabulation(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Fibonacci term: ");
        int n = in.nextInt();
        in.close();
        int[] fib = new int[n+1];
        System.out.println(fibonacciMemoization(n, fib));
        System.out.println(fibonacciTabulation(n));
    }
}

/**
 * Time Complexity of both the functions are O(n)
 * Space Complexity will differ because of use of recursion in fibonacciMemoization function
 * 
 */