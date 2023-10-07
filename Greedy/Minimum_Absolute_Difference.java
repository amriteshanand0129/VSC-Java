import java.util.*;
public class Minimum_Absolute_Difference {
    
    // Sum of Minimum Absolute Differences of Pairs
    // Time Complexity is O(N logN)
    public static void main(String args[]) {

        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        // Sorting both the arrays
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i=0; i<A.length; i++) 
            minDiff += Math.abs(A[i] - B[i]);

        System.out.println("Minimum Absolute Difference " + minDiff);
    }
}
