import java.util.*;
public class Watermelon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 2 || n % 2 != 0)
            System.out.println("NO");
        else    
            System.out.println("YES");
        in.close();
    }
}
