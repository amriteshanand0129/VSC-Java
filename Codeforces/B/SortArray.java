import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        in.close();
        boolean descending_segments = false;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            if (i < (n - 1) && arr[i] > arr[i + 1]) {
                if (descending_segments) {
                    System.out.println("no");
                    return;
                } else {
                    descending_segments = true;
                    start = i;
                    while (i < (n - 1) && arr[i] > arr[i + 1])
                        i++;
                    end = i;
                    if ((end + 1 < n && arr[start] > arr[end + 1]) || (start > 0 && arr[end] < arr[start - 1])) {
                        System.out.println("no");
                        return;
                    }
                }
            }
        }
        System.out.printf("yes\n%d %d", start + 1, end + 1);
    }
}
