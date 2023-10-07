import java.util.*;

public class Knapsack {
    // Fractional Knapsack Problem
    public static void main(String args[]) {
        int val[] = {60, 100, 120};     // Value of each item
        int weight[] = {10, 20, 30};    // Weight of each item
        int w = 50;                     // Capacity of the knapsack

        // Creating and Initialising a 2D Array
        double ratio[][] = new double[val.length][2];

        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)weight[i];
        }

        // Sorting the array in ascending order based on the ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // Filling the knapsack
        int capacity = w;
        int finalval = 0;
        for(int i=ratio.length-1; i>=0; i--) {
            int index = (int)ratio[i][0];

            // Including full weight 
            if(capacity >= weight[index]) {
                capacity -= weight[index];
                finalval += val[index];
            }

            // Including fractional weight due to lack of capacity
            else {
                finalval += val[index] / weight[index] * capacity;
                break;
            }
        }

        System.out.println("Maximum value of goods: " + finalval);
    }
}
