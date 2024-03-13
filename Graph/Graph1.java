
// Basic Implementation of Graph using Array of ArrayLists

package Graph;
import java.util.*;
public class Graph1 {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph= new ArrayList[V];  

        /* Array of ArrayLists where
         * each index of array represents a vertex
         * while the arraylist at each index represent the edges of that vertex
         */

        for(int i=0; i<V; i++) 
            graph[i] = new ArrayList<>();

        /*          1 ----- 3
         *         / \     /
         *        /   \   /
         *       0      2 ---- 4
         * 
         */

        // Vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // Vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // 2's neighbour
        System.out.println("Neighbours of vertex 2");
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.src + " --- " + e.dest);
        }
    }
}