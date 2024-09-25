import java.util.Scanner;

public class Bit_plus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x = 0; 
        for(int i=0; i<n; i++) {
            String cmd = in.next();
            if(cmd.charAt(1) == '+')
                x++;
            else    
                x--;
        }
        in.close();
        System.out.println(x);
    }
}
