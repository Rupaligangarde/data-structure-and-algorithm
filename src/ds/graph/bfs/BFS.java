package ds.graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

    void bfs(int start) {
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            start = queue.poll();

            System.out.println(start + " ");
            Iterator<Integer> neighbours = adj[start].listIterator();
            while (neighbours.hasNext()) {
                Integer vertex = neighbours.next();
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("BFS is:");
        graph.bfs(2);

        Graph anotherGraph = new Graph(4);
        anotherGraph.addEdge(0, 1);
        anotherGraph.addEdge(0, 2);
        anotherGraph.addEdge(1, 2);
        anotherGraph.addEdge(2, 0);
        anotherGraph.addEdge(2, 3);
        anotherGraph.addEdge(3, 3);

        System.out.println("BFS is:");
        graph.bfs(0);
    }
}