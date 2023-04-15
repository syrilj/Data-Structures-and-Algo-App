package myLib.graphalgo;
import myLib.datastructures.nodes.GraphNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



public class Graphalgo {
    public int order; // number of vertices in the graph
    public int size; // number of edges in the graph
    public ArrayList<GraphNode> vertices;
    
    public Graphalgo() {
        this.order = 0;
        this.size = 0;
        this.vertices = new ArrayList<>();
    }
    
    public Graphalgo(GraphNode vertex) {
        this.order = 1;
        this.size = 0;
        this.vertices = new ArrayList<>();
        this.vertices.add(vertex);
    }
    
    public void addVertex(int val) {
        GraphNode vertex = new GraphNode(val);
        this.vertices.add(vertex);
        this.order++;
    }
    
    public void addEdge(int source, int destination) {
        GraphNode src = null, dest = null;
        for (GraphNode vertex : this.vertices) {
            if (vertex.val == source) {
                src = vertex;
            } else if (vertex.val == destination) {
                dest = vertex;
            }
        }
        if (src != null && dest != null) {
            src.neighbors.add(dest);
            this.size++;
        }
    }
    
    public void dfs() {
        boolean[] visited = new boolean[this.order];
        for (GraphNode vertex : this.vertices) {
            if (!visited[vertex.val]) {
                dfsUtil(vertex, visited);
            }
        }
    }
    
    private void dfsUtil(GraphNode vertex, boolean[] visited) {
        visited[vertex.val] = true;
        System.out.print(vertex.val + " ");
        for (GraphNode neighbor : vertex.neighbors) {
            if (!visited[neighbor.val]) {
                dfsUtil(neighbor, visited);
            }
        }
    }
    
    public void bfs() {
        boolean[] visited = new boolean[this.order];
        Queue<GraphNode> queue = new LinkedList<>();
        for (GraphNode vertex : this.vertices) {
            if (!visited[vertex.val]) {
                queue.offer(vertex);
                visited[vertex.val] = true;
                while (!queue.isEmpty()) {
                    GraphNode curr = queue.poll();
                    System.out.print(curr.val + " ");
                    for (GraphNode neighbor : curr.neighbors) {
                        if (!visited[neighbor.val]) {
                            queue.offer(neighbor);
                            visited[neighbor.val] = true;
                        }
                    }
                }
            }
        }
    }
    
    public void dijkstra(int start) {
        int[] dist = new int[this.order];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> dist[a.val] - dist[b.val]);
        dist[start] = 0;
        pq.offer(this.vertices.get(start));
        while (!pq.isEmpty()) {
            GraphNode curr = pq.poll();
            for (GraphNode neighbor : curr.neighbors) {
                int newDist = dist[curr.val] + 1; // distance is assumed to be 1 for unweighted graph
                if (newDist < dist[neighbor.val]) {
                    dist[neighbor.val] = newDist;
                    pq.offer(neighbor);
                }
            }
        }
        for (int i = 0; i < this.order; i++) {
            System.out.println("Distance from vertex " + start + " to vertex " + i + ": " + dist[i]);
        }
    }
}
