import myLib.datastructures.Linear.CDLL;
import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CDLLTest {
    private CDLL cdll;

    @BeforeEach
    public void setUp() {
        cdll = new CDLL();
    }

    @Test
    public void testInsertHead() {
        DNode node = new DNode(1);
        cdll.InsertHead(node);
        assertEquals(node, cdll.getHead());
        assertEquals(node, cdll.getTail());
        assertEquals(1, cdll.getTracker());
    }

    @Test
    public void testInsertTail() {
        DNode node = new DNode(1);
        cdll.InsertTail(node);
        assertEquals(node, cdll.getHead());
        assertEquals(node, cdll.getTail());
        assertEquals(1, cdll.getTracker());
    }

    @Test
    public void testInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.Insert(node1, 1);
        cdll.Insert(node3, 2);
        cdll.Insert(node2, 2);
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getTail());
        assertEquals(3, cdll.getTracker());
    }

    @Test
    public void testDeleteHead() {
        DNode node = new DNode(1);
        cdll.InsertHead(node);
        cdll.DeleteHead();
        cdll.Print();
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
        assertEquals(0, cdll.getTracker());
    }

    @Test
    public void testDeleteTail() {
        DNode node = new DNode(1);
        cdll.InsertTail(node);
        cdll.DeleteTail();
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
        assertEquals(0, cdll.getTracker());
    }

    @Test
    public void testDelete() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.Insert(node1, 1);
        cdll.Insert(node3, 2);
        cdll.Insert(node2, 2);
        cdll.Delete(node2);
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getTail());
        assertEquals(2, cdll.getTracker());
    }

    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.SortedInsert(node2);
        cdll.SortedInsert(node3);
        cdll.SortedInsert(node1);
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getTail());
        assertEquals(3, cdll.getTracker());
    }
}
