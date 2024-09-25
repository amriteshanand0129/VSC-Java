import java.util.Scanner;

public class Next_Round {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();
        int value = arr[k-1], count = 0;
        for(int i: arr) {
            if(i >= value && i > 0)
                count++;
        } 
        in.close();
        System.out.println(count);
    }
}
