/**
 * PrimeFactors
 */
public class PrimeFactors {

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        boolean prime = true;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void primeFactors(int num) {
        int largestPrime = Integer.MIN_VALUE;
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                int quot = num / i;
                if (isPrime(i)) {
                    if (i > largestPrime)
                        largestPrime = i;
                    System.out.println(i);
                }
                if (isPrime(quot)) {
                    if (i > largestPrime)
                        largestPrime = i;
                    System.out.println(quot);
                }
            }
        }
        int p = 9;
        if(largestPrime <= p) 
            System.out.printf("\n%d is a %d-smooth Number", num, p);
        else    
            System.out.printf("\n%d is not a %d-smooth Number", num, p);
    }

    public static void main(String[] args) {
        int num = 60;
        System.out.println("Prime factors of " + num + ": ");
        primeFactors(num);
    }
}