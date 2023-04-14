import static org.junit.Assert.*;
import org.junit.Test;
import myLib.datastructures.nodes.DNode;
import myLib.datastructures.Linear.DLL;

public class DLLTest {

    @Test
    public void testInsertHead() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        dll.InsertHead(node);
        assertEquals(1, dll.Search(node).getData());
    }

    @Test
    public void testInsertTail() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        dll.InsertTail(node);
        assertEquals(1, dll.Search(node).getData());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInvalidPosition() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        dll.Insert(node, 0);
    }

    @Test
    public void testInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.InsertHead(node1);
        dll.Insert(node2, 2);
        assertEquals(2, dll.Search(node2).getData());
    }

    @Test
    public void testSortedInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.SortedInsert(node2);
        dll.SortedInsert(node3);
        dll.SortedInsert(node1);
        assertEquals(1, dll.Search(node1).getData());
    }

    @Test
    public void testSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        dll.InsertHead(node1);
        assertEquals(node1, dll.Search(node1));
    }

    @Test
    public void testDeleteHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.DeleteHead();
        assertEquals(node1, dll.Search(node1));
    }

    @Test
    public void testDeleteTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.DeleteTail();
        assertEquals(node2, dll.Search(node2));
    }

    @Test
    public void testDelete() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.Delete(node1);
        assertNull(dll.Search(node1));
    }
}
