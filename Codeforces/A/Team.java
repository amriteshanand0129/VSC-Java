import java.util.Scanner;

public class Team {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); int count = 0;
        for(int i=0; i<n; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            if(a + b + c >= 2)
                count++;
        }
        in.close();
        System.out.println(count);
    }
}
