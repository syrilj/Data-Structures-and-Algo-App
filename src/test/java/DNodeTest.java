

import myLib.datastructures.nodes.DNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class DNodeTest {
    @Test
    public void testDNode() {
        DNode node = new DNode(42);

        // Test getData method
        assertEquals(42, node.getData());

        // Test setData method
        node.setData(10);
        assertEquals(10, node.getData());

        // Test getPrevious and setPrevious methods
        DNode prevNode = new DNode(20);
        node.setPrevious(prevNode);
        assertEquals(prevNode, node.getPrevious());

        // Test getNext and setNext methods
        DNode nextNode = new DNode(30);
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());

        // Test toString method
        assertEquals("10", node.toString());
    }
}

