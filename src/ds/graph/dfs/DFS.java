package ds.graph.dfs;

import java.util.LinkedList;
import java.util.ListIterator;


class Graph {
    private final int noOfVertices;
    private final LinkedList<Integer> adj[];

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    void addEdge(int start, int end) {
        adj[start].add(end);
    }


    public void dfs(int start) {
        boolean[] visited = new boolean[noOfVertices];
        performDFS(start, visited);
    }

    private void performDFS(int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start + " ");
        ListIterator<Integer> neighbours = adj[start].listIterator();
        while (neighbours.hasNext()) {
            int vertex = neighbours.next();
            if (!visited[vertex]) {
                performDFS(vertex, visited);
            }
        }
    }


}

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("DFS is:");
        graph.dfs(2);

        Graph anotherGraph = new Graph(4);
        anotherGraph.addEdge(0, 1);
        anotherGraph.addEdge(0, 2);
        anotherGraph.addEdge(1, 2);
        anotherGraph.addEdge(2, 0);
        anotherGraph.addEdge(2, 3);
        anotherGraph.addEdge(3, 3);

        System.out.println("DFS is:");
        graph.dfs(0);
    }
}

