//
// Topological Sorting using modified DFS
//
package Graph;
import java.util.*;
public class Graph7 {
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
        
        /*
         *  5 ---> 0 <--- 4
         *  |             |
         *  |             |
         *  v             v
         *  2 ---> 3 ---> 1
         * 
         */
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topSortDFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortDFSUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()) 
            System.out.print(s.pop() + " ");
    }

    public  static void topSortDFSUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) 
                topSortDFSUtil(graph, e.dest, vis, s);
        }
        s.push(curr);
    }

    // Function to calculate indegree of vertices of the graph
    public static void calIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0)
                    q.add(e.dest);
            }
        }
    }

    public static void main(String args[]) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Topological Sorted Order using DFS: ");
        topSortDFS(graph);
        
        System.out.println("\nTopological Sorted Order using BFS: ");
        topSortBFS(graph);
    }
}
