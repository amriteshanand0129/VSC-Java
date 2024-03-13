//
// Components in Graph - Implementing BFS and DFS
//
package Graph;
import java.util.*;

public class Graph3 {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

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
        graph[5].add(new Edge(5,5));
    }

    // Function taking care of components for BFS
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i])
                bfsUtil(graph, vis);
        }
    }

    // Function actually performing BFS
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
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

    // Function taking care of components for DFS
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i])
                dfsUtil(graph, i, vis);
        }
    }

    // Function actually performing DFS
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Breadth First Traversal: ");
        bfs(graph);

        System.out.println("\nDepth First Traversal: ");
        dfs(graph);
    }
}
