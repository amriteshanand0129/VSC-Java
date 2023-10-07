import java.util.*;
public class Greedy {
    public static void select_Activity_Sorted() {

        // Finding the max number of activities that can be performed 
        // Array of endtime is sorted
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();  // Storing indices of Selected Activities

        // Initially selecting the first activity i.e the activity which ends earliest
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        
        // Traversing the activities to select 
        for(int i=1; i<end.length; i++) {

            // Selecting Activity
            if(start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);
        for(int i=0; i<ans.size(); i++)
            System.out.print("A" + ans.get(i) + " ");
        System.out.println();
    }

    public static void select_Activity_Unsorted() {

        // Finding the max number of activities that can be performed 
        // Array of starttime is sorted -> unusable
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sorting the array with respect to endtime using lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=0; i<end.length; i++) {
            if(activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);
        for(int i=0; i<ans.size(); i++)
            System.out.print("A" + ans.get(i) + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        select_Activity_Sorted();
        select_Activity_Unsorted();
    }
}