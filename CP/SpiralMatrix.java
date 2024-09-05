// 5th September
import java.util.*;
class SpiralMatrix {
    public static void printSpiral(int[][] matrix, int row, int col) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0, right = col-1, top = 0, bottom = row-1;
        while(left <= right && top <= bottom) {
            for(int i=left; i<=right; i++) {
                arr.add(matrix[top][i]);
            } top++;
            for(int i=top; i<=bottom; i++) {
                arr.add(matrix[i][right]);
            } right--;
            if(top <= bottom) {
                for(int i=right; i>=left; i--) {
                    arr.add(matrix[bottom][i]);
                } bottom--;
            }
            if(left <= right) {
                for(int i=bottom; i>=top; i--) {
                    arr.add(matrix[i][left]);
                } left++;
            }
        }
        System.out.println(arr);
    }

    public static void checkSum_TwoPointer(int[] arr, int sum) {
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0, right = n-1;
        while (left < right) {
            int curr_sum = arr[left] + arr[right];
            if(curr_sum == sum) {
                System.out.println("Sum found: " + arr[left] + " " + arr[right]);
                return;
            } else if(curr_sum < sum)
                left++;
            else 
                right--;
        }
        System.out.println("Sum not found");
    }

    public static void checkSum_HashMap(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) {
            set.add(i);
        }
        for(int i: arr) {
            if(set.contains(sum-i)) {
                System.out.println("Sum found: " + i + " " + (sum - i));
                return;
            }
        }
        System.out.println("Sum not found");
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int row = matrix.length;
        int col = matrix[0].length;
        printSpiral(matrix, row, col);


        // two elements add up to sum
        int[] arr = {4, 2, 9, 10, 6, 8, 20};
        int sum = 12;
        checkSum_TwoPointer(arr, sum);
        checkSum_HashMap(arr, sum);
    }
}