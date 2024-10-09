/**
 * Bear_Big_Brother
 */
import java.util.*;
public class Bear_Big_Brother {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        in.close();
        int count = 0;
        while(a <= b) {
            a *= 3;
            b *= 2;
            count++;
        } System.out.println(count);
    }
}