import java.util.*;

/**
 * Robin_Hood_in_Town
 */
public class Robin_Hood_in_Town {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            // int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
                // sum += arr[j];
            }
            if (n <= 2)
                System.out.println(-1);
            else {
                Arrays.sort(arr);
                // int max = arr[n - 1];
                // double average = sum / n;
                // int unhappy_person = (int)Math.ceil(n / 2);
                // double unhappy_wealth = arr[unhappy_person] * 2 * n;
                // if(req_average <= average)
                //     System.out.println(0);
                // else {
                //     System.out.println("Current average: " + average + " Wealth of person next to mid: " + arr[unhappy_person] + " Required average: " + req_average);
                //     int req_gold = (int)Math.ceil(n * (req_average - average));
                //     System.out.println("More gold required: " + req_gold);
                //     System.out.println(req_gold);
                // }
            }
        }
        in.close();
    }
}