import java.util.*;
public class PairSum {

    // Finding Pair Sum from Sorted ArrayList
    public static void pairSum_1(ArrayList<Integer> arr, int target) {
        int leftindex = 0;
        int rightindex = arr.size()-1;

        // Loop to traverse the array in O(n) time complexity
        while(leftindex < rightindex) {
            int sum = arr.get(rightindex) + arr.get(leftindex);

            // Target sum found
            if(sum == target) {
                System.out.println(arr.get(rightindex) + " " + arr.get(leftindex));

                // Proceeding to find other pairs
                rightindex--;
                leftindex++;
            }

            // If the sum is greater than the required target then right index will move backward.
            else if(sum > target)
                rightindex--;

            // Else the left index will move forward
            else 
                leftindex++;
        }
    }

    // Finding Pair Sum from Sorted and Rotated ArrayList
    public static void pairSum_2(ArrayList<Integer> array, int target) {
        int pivot = -1;
        int n = array.size();

        // Loop to find the breaking point/pivot
        for(int i=0; i<n; i++) {
            if(array.get(i) > array.get(i+1)) {
                pivot = i;
                break;
            }
        }
        int rightindex = pivot;
        int leftindex = pivot + 1;

        // Loop to traverse the array in O(n) time complexity
        while(leftindex != rightindex) {
            int sum = array.get(leftindex) + array.get(rightindex);

            // Target sum found
            if(sum == target) {
                System.out.println(array.get(leftindex) + " " + array.get(rightindex));

                // Proceeding to find other pairs
                rightindex = (n + rightindex - 1) % n;
                leftindex = (leftindex + 1) % n;
            }

            // If the sum is greater than the required target then right index will move backward -> and jump to endindex if reached the starting index
            else if(sum > target) 
                rightindex = (n + rightindex - 1) % n;

            // Else the left index will move forward -> and jump to starting index if reached the endindex
            else 
                leftindex = (leftindex + 1) % n;
        }
    }
    public static void main(String args[]) {
        
        // Sorted ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println("Results of Pair Sum from the Sorted ArrayList");
        pairSum_1(arr, 6);

        // Sorted and Rotated ArrayList
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(11);
        array.add(12);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        System.out.println("Results of Pair Sum from the Sorted Rotated ArrayList");
        pairSum_2(array, 16);
    }
}
