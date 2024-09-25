public class Kadanes {
    public static void main(String args[]) {
        int[] arr = {1, 2, -5, 7, 4, -8};
        int curr_sum = arr[0], max_sum = arr[0];
        for(int i=1; i<arr.length; i++) {
            curr_sum += arr[i];
            curr_sum = Math.max(0, curr_sum);
            max_sum = Math.max(max_sum, curr_sum);
        } 
        System.out.println("Maximum subsequence sum: " + max_sum);
    }
}