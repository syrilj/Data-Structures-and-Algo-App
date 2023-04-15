import myLib.graphalgo.Graphalgo;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphalgoTest {
    
    @Test
    public void testAddVertex() {
        Graphalgo g = new Graphalgo();
        g.addVertex(1);
        assertEquals(g.order, 1);
        assertEquals(g.vertices.get(0).val, 1);
    }
    
    @Test
    public void testAddEdge() {
        Graphalgo g = new Graphalgo();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        assertEquals(g.size, 1);
        assertEquals(g.vertices.get(0).neighbors.get(0).val, 2);
    }
    
    @Test
    public void testDfs() {
        Graphalgo g = new Graphalgo();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
      // expected output: 1 2 4 3
    }
    
    @Test
    public void testBfs() {
        Graphalgo g = new Graphalgo();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        // expected output: 1 2 3 4
    }
    
    @Test
    public void testDijkstra() {
        Graphalgo g = new Graphalgo();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.dijkstra(0);
        // expected output:
        // Distance from vertex 0 to vertex 0: 0
        // Distance from vertex 0 to vertex 1: 1
        // Distance from vertex 0 to vertex 2: 1
        // Distance from vertex 0 to vertex 3: 2
    }
}
