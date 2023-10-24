import java.util.*;
public class Classroom_1 {

    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        // Alternative of this overriding could be using comparator in the priority queue as parameter itself
        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            }
            else {
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public static void main(String args[]) {

        // Connect N Ropes 
        // {
        //     int ropes[] = {2, 3, 3, 4, 6};
        //     PriorityQueue<Integer> pq = new PriorityQueue<>();
        //     for(int i=0; i<ropes.length; i++)
        //         pq.add(ropes[i]);
        //     int cost = 0;
        //     while(pq.size() > 1) {
        //         int min = pq.remove();
        //         int min2 = pq.remove();
        //         cost += min + min2;
        //         pq.add(min + min2);
        //     }
        //     System.out.println(cost);
        // }
    
        // Weakest Soldier
        
        // int army[][] = {{1, 0, 0, 0},
        //                  {1, 1, 1, 1},
        //                  {1, 0, 0, 0},
        //                  {1, 0, 0, 0}};
        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();
        // for(int i=0; i<army.length; i++) {
        //     int count = 0;
        //     for(int j = 0; j<army[0].length; j++) {
        //         count += army[i][j] == 1 ? 1 : 0;
        //     }
        //     pq.add(new Row(count, i));
        // }
        // for(int i=0; i<k; i++)
        //     System.out.println(pq.remove().idx);
    }
}
