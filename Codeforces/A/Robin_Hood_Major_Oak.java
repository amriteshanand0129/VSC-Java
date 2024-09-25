import java.util.Scanner;

public class Robin_Hood_Major_Oak {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++) {
            int n = in.nextInt(), k = in.nextInt();
            int start = n - k + 1; 
            int total_years = n - start + 1, odd_years = 0;
            if(start % 2 == 0 && n % 2 == 0) {
                odd_years = (int)((total_years - 1) / 2);
            } else if(start % 2 != 0 && n % 2 != 0) {
                odd_years = (int)((total_years + 1) / 2);
            } else {
                odd_years = total_years / 2;
            }
            if(odd_years % 2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        in.close();
    }
}
