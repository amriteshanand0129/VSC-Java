import java.util.*;
class Recursion {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int a = in.nextInt();
        in.close();
        for(int i=0; i<a; i++) {
            int value = Fib(i);
            System.out.print(value + " ");
        }
    }

    // Printing Fibonacci Series using Recursion upto n terms
    static int Fib(int n) {
        if(n == 1 || n == 0) {
            return(n);
        }
        return (Fib(n-1) + Fib(n-2));
    }
}