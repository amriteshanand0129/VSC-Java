//
// Bellman Ford Algorithm
//
package Graph;
import java.util.*;
public class Graph10 {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) 
            graph[i] = new ArrayList<>();
         
        /* Diagram in notebook */
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph) {

        // Same graph as above just not at specific indices - arraylist instead of array
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1, -1));
    }

    // Total time complexity = O(V * E)
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i!= src)
                dist[i] = Integer.MAX_VALUE;
        }
        int V = graph.length;
        for(int i=0; i<V-1; i++) {
            // edges - time complexity = O(E) not O(N^2) because both loops below are just traversing total edges
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // Check for infinity is necessary as any addition to the infinity will lead to negative value (in computers) which will lead to false relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                        dist[v] = dist[u] + wt;
                }
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for(int i=0; i<dist.length; i++) {
            if(i!= src)
                dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<V-1; i++) {
            // edges - time complexity = O(E) same as with 2 loops earlier
            for(int j=0; j<graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // Check for infinity is necessary as any addition to the infinity will lead to negative value (in computers) which will lead to false relaxation
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Shortest distances (ArrayList): ");
        bellmanFord(graph, 0);

        // Another way - Though Time Complexity will be the same
        // Code will be smaller
        // Here we are storing just the edges in an arraylist and not in an array at specific indices
        // Enabling us to access the edges using just one loop
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        System.out.println("\nShortest distances (Array): ");
        bellmanFord2(edges, 0, V);
    }
}
