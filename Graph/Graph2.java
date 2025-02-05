//
// Implementation of BFS, DFS and Path Searching
//
package Graph;
import java.util.*;
public class Graph2 {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {

        for(int i=0; i<graph.length; i++) 
            graph[i] = new ArrayList<>();
        
        /*
         *          1 ---- 3 ---- 5 ---- 6
         *         /       |    /
         *       0         |   /
         *         \       |  /
         *          2 ---- 4 
         */

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,1));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }

    // Breadth First Traversal
    public static void bfs(ArrayList<Edge>[] graph) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Depth First Traversal
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) 
                dfs(graph, e.dest, vis);
        }
    }

    // Existence of path 
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if(src == dest)
            return true;
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis))
                return true;
        }
        return false;
    }
    public static void main(String args[]) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Breadth First Traversal: ");
        bfs(graph);

        System.out.println("\nDepth First Traversal: ");
        dfs(graph, 0, new boolean[V]);

        System.out.print("\nPath for 0 to 7 found: ");
        System.out.println(hasPath(graph, 0, 6, new boolean[V]));
    }
}
