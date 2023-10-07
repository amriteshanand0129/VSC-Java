import java.util.*;
public class Chocola {
    public static void main(String args[]) {

        int n = 4, m = 6;       // Rows = n     Columns = m
        Integer costVer[] = {2, 1, 3, 1, 4}; // m - 1
        Integer costHor[] = {4, 1, 2};       // n - 1

        // Sorting the cost of cutting in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, (a, b) -> b - a);

        int h = 0, v = 0;   // Pointers for traversing the cost arrays

        // Tracking the total number of Horizontal and Vertical pieces
        int hPieces = 1, vPieces = 1;

        int totalCost = 0;

        while(h < n && v < m) {

            // Cost of vertical cut is higher
            if(costVer[v] > costHor[h]) {
                totalCost += costVer[v] * hPieces;
                vPieces++;
                v++;
            }

            // Cost of horizontal cut is higher
            else {
                totalCost += costHor[h] * vPieces;
                hPieces++;
                h++;
            }
        }

        // Leftout elements of Horizontal cost array
        while(h < n) {
            totalCost += costHor[h] * vPieces;
            hPieces++;
            h++;
        }

        // Leftout elements of Vertical cost array
        while(v < m) {
            totalCost += costVer[v] * hPieces;
            vPieces++;
            v++;
        }
        
        System.out.println("Total Cost of Chocolate = " + totalCost);
    }
}
