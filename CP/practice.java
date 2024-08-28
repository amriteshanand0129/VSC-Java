import java.util.*;
public class practice {
    public static boolean checkPrime(int n) {
        boolean isPrime = true;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int n = in.nextInt();
        in.close();

        if(checkPrime(n)) 
            System.out.println("The original number " + n + " is Prime");
        else
            System.out.println("The original number " + n + " is Not Prime");

        int rev = 0;
        while(n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        if(checkPrime(rev)) 
            System.out.println("The reversed number " + rev + " is Prime");
        else
            System.out.println("The reversed number " + rev + " is Not Prime");
    }
}
