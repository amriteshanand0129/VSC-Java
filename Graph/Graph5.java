//
// Bipartite Graph
//
package Graph;
import java.util.*;
public class Graph5 {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph1(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /* Bipartite Graph
         *          0
         *         / \
         *        /   \
         *       /     \
         *      1       2
         *       \     /
         *        \   /
         *         \ /
         *          3
         */  
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));        

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }

    static void createGraph2(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /* Non Bipartite Graph
         *          0
         *        /   \
         *       /     \
         *      1       2
         *      |       |
         *      |       |
         *      3 ----- 4
         */
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));        
        // graph[0].add(new Edge(0,5));        

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        // graph[2].add(new Edge(2,5));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
    }

    public static boolean bipartite(ArrayList<Edge> graph[]) {
        int colour[] = new int[graph.length];
        for(int i=0; i<graph.length; i++)
            colour[i] = -1;
        for(int i=0; i<graph.length; i++) {
            if(colour[i] == -1)
                if(!bipartiteUtil(graph, i, colour)) 
                    return false;
        }
        return true;
    }

    public static boolean bipartiteUtil(ArrayList<Edge> graph[], int start, int colour[]) {
        if(colour[start] == -1)
            colour[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int i=0; i<graph[curr]. size(); i++) {
                Edge e = graph[curr].get(i);
                if(colour[e.dest] == -1) {
                    colour[e.dest] = Math.abs(colour[curr] - 1);
                    q.add(i);
                }
                else if(colour[e.dest] == colour[curr])
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {

        int V1 = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph1[]= new ArrayList[V1];
        createGraph1(graph1);

        int V2 = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph2[]= new ArrayList[V2];
        createGraph2(graph2);

        System.out.println("First Graph is Bipartite: " + bipartite(graph1));
        System.out.println("Second Graph is Bipartite: " + bipartite(graph2));
    }
}
