import java.util.Scanner;

public class Way_to_long_words {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
        for(int i=0; i<n; i++) {
            String str = in.next();
            int l = str.length();
            if(l > 10) {
                String newstr = "" + str.charAt(0) + (l-2) + str.charAt(l-1);
                System.out.println(newstr);
            } else {
                System.out.println(str);
            }
        }
        in.close();
    }
}
