import java.util.*;
class practice4 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();
        // Sieve of Eratosthenes
        boolean isConsecutive[] = new boolean[n+1];
        for(int i=2; i*i <= n; i++) {
            for(int j=i*i; j<=n; j+=i)
                isConsecutive[j] = true;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=3; i<isConsecutive.length; i++)
            if(!isConsecutive[i])
                set.add(i);

        for(int i=6; i<=n; i+=2) {
            int addend1 = 3, addend2 = i-3;
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            while(addend1 <= addend2) {
                if(set.contains(addend1) && set.contains(addend2)) {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(addend1);
                    ar.add(addend2);
                    arr.add(ar);
                }
                addend1 += 2;
                addend2 -= 2;
            }
            System.out.println(i + " = " + arr);
        }

        System.out.print("\nEnter the value of num: ");
        int num = in.nextInt();
        for(int i=1; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(set.contains(i) && set.contains((int)(num / i))) 
                    System.out.printf("\n%d = %d x %d", num, i, num / i);
            }
        }
        in.close();
    }
}