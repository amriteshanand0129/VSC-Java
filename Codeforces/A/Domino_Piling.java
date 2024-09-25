import java.util.Scanner;

public class Domino_Piling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        in.close();
        System.out.println((m * n) / 2);
    }
}
