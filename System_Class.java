import java.awt.Window;
import java.util.Arrays;
import java.util.Comparator;

public class System_Class {

    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // Sorting the array based on the end of pairs
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1; // Initially first pair selected
        int chainEnd = pairs[0][1]; // Last selected pair end // chain end
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max Length of chain: " + chainLen);
        
        System.out.println("before garbage collection = " + Window.getWindows().length);
        System.gc();
        System.out.println("after garbage collection = " + Window.getWindows().length);

    }
}