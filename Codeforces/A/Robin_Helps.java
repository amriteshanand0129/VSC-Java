import java.util.Scanner;

public class Robin_Helps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++) {
            int n = in.nextInt(), k = in.nextInt(), Robins_gold = 0, count = 0;
            for(int j=0; j<n; j++) {
                int gold = in.nextInt();
                if(gold == 0 && Robins_gold > 0) {
                    Robins_gold--;
                    count++;
                } else if(gold >= k) {
                    Robins_gold += gold;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
