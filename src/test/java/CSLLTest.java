import static org.junit.Assert.*;

import myLib.datastructures.Linear.CSLL;
import org.junit.Before;
import org.junit.Test;

import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.Assertions;

public class CSLLTest {

    private CSLL csll;

    @Before
    public void setUp() {
        csll = new CSLL();
    }

    @Test
    public void testInsertHead() {
        // Test inserting at head when list is empty
        DNode node1 = new DNode(10);
        csll.InsertHead(node1);
        assertEquals(1, csll.getSize());
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getTail());

        // Test inserting at head when list is not empty
        DNode node2 = new DNode(20);
        csll.InsertHead(node2);
        assertEquals(2, csll.getSize());
        assertEquals(node2, csll.getHead());
        assertEquals(node1, csll.getTail());
    }

    @Test
    public void testInsertTail() {
        // Test inserting at tail when list is empty
        DNode node1 = new DNode(10);
        csll.InsertTail(node1);
        assertEquals(1, csll.getSize());
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getTail());

        // Test inserting at tail when list is not empty
        DNode node2 = new DNode(20);
        csll.InsertTail(node2);
        assertEquals(2, csll.getSize());
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getTail());
    }

    @Test
    public void testSort() {
        // Test sorting an empty list
        csll.Sort();
        assertNull(csll.getHead());
        assertNull(csll.getTail());

        // Test sorting a csll with one element
        csll.InsertHead(new DNode(5));
        csll.Sort();
        assertEquals(5, csll.getHead().getData());
        assertEquals(5, csll.getTail().getData());

        // Test sorting a csll with multiple elements
        csll.InsertHead(new DNode(10));
        csll.InsertHead(new DNode(3));
        csll.InsertHead(new DNode(8));
        csll.Sort();
        assertEquals(3, csll.getHead().getData());
        assertEquals(10, csll.getTail().getData());
        assertEquals(4, csll.getSize());
    }
    @Test
    public void testInsert() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        // Insert at position 1
        list.Insert(node1, 1);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(node1, list.getHead());
        Assertions.assertEquals(node1, list.getTail());

        // Insert at position 2
        list.Insert(node2, 2);
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(node1, list.getHead());
        Assertions.assertEquals(node2, list.getTail());

        // Insert at position 3
        list.Insert(node3, 3);
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals(node1, list.getHead());
        Assertions.assertEquals(node3, list.getTail());
    }
    @Test
    public void testInsertInvalidPosition() {
        CSLL list = new CSLL();
        DNode node = new DNode(1);

        // Insert at position < 1 should throw an IndexOutOfBoundsException
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.Insert(node, 0);
        });

        // Insert at position > size + 1 should throw an IndexOutOfBoundsException
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.Insert(node, 2);
        });
    }
    @Test
    public void testSortedInsert() {
        // Test inserting into an empty csll
        csll.SortedInsert(new DNode(5));
        assertEquals(5, csll.getHead().getData());
        assertEquals(5, csll.getTail().getData());
        assertEquals(1, csll.getSize());

        // Test inserting into a csll with one element
        csll.SortedInsert(new DNode(10));
        assertEquals(5, csll.getHead().getData());
        assertEquals(10, csll.getTail().getData());
        assertEquals(2, csll.getSize());

        // Test inserting into a csll with multiple elements
        csll.SortedInsert(new DNode(1));
        csll.SortedInsert(new DNode(6));
        csll.SortedInsert(new DNode(8));
        assertEquals(1, csll.getHead().getData());
        assertEquals(10, csll.getTail().getData());
        assertEquals(5, csll.getSize());
    }
    @Test
    public void testInsertHead2() {
        CSLL list = new CSLL();
        list.InsertHead(new DNode(5));
        assertEquals("Head should be 5", 5, list.getHead().getData());
        assertEquals("Tail should be 5", 5, list.getTail().getData());
        assertEquals("Size should be 1", 1, list.getSize());

        list.InsertHead(new DNode(3));
        assertEquals("Head should be 3", 3, list.getHead().getData());
        assertEquals("Tail should be 5", 5, list.getTail().getData());
        assertEquals("Size should be 2", 2, list.getSize());
    }

    @Test
    public void testInsertTail2() {
        CSLL list = new CSLL();
        list.InsertTail(new DNode(5));
        assertEquals("Head should be 5", 5, list.getHead().getData());
        assertEquals("Tail should be 5", 5, list.getTail().getData());
        assertEquals("Size should be 1", 1, list.getSize());

        list.InsertTail(new DNode(7));
        assertEquals("Head should be 5", 5, list.getHead().getData());
        assertEquals("Tail should be 7", 7, list.getTail().getData());
        assertEquals("Size should be 2", 2, list.getSize());
    }

    @Test
    public void testInsert2() {
        CSLL list = new CSLL();
        list.Insert(new DNode(5), 1);
        assertEquals("Head should be 5", 5, list.getHead().getData());
        assertEquals("Tail should be 5", 5, list.getTail().getData());
        assertEquals("Size should be 1", 1, list.getSize());

        list.Insert(new DNode(3), 1);
        assertEquals("Head should be 3", 3, list.getHead().getData());
        assertEquals("Tail should be 5", 5, list.getTail().getData());
        assertEquals("Size should be 2", 2, list.getSize());

        list.Insert(new DNode(7), 3);
        assertEquals("Head should be 3", 3, list.getHead().getData());
        assertEquals("Tail should be 7", 7, list.getTail().getData());
        assertEquals("Size should be 3", 3, list.getSize());

        list.Insert(new DNode(4), 2);
        assertEquals("Head should be 3", 3, list.getHead().getData());
        assertEquals("Tail should be 7", 7, list.getTail().getData());
        assertEquals("Size should be 4", 4, list.getSize());
    }
    @Test
    public void testEmptyList() {
        CSLL list = new CSLL();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testInsertHead5() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertHead(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());
        list.InsertHead(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getSize());
        list.InsertHead(node3);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getSize());
    }
    @Test
    public void testInsertTail3() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());
        list.InsertTail(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
        list.InsertTail(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testInsert4() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        list.Insert(node1, 1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());
        list.Insert(node2, 2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
        list.Insert(node3, 2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(3, list.getSize());
        list.Insert(node4, 1);
        assertEquals(node4, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(4, list.getSize());
    }


    @Test
    public void testEmptyListMore() {
        CSLL list = new CSLL();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testInsertHeadMore() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.InsertHead(node1);
        list.InsertHead(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testInsertTailMore() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.InsertTail(node1);
        list.InsertTail(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
    }
    @Test
    public void testSortedInsertMore() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.SortedInsert(node2);
        list.SortedInsert(node1);
        list.SortedInsert(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(node2, list.getHead().getNext());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testSearch() {
        CSLL list = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        assertEquals(node2, list.Search(node2));
        assertEquals(null, list.Search(new DNode(4)));
    }
    @Test
    public void testDeleteHead() {
        // Create a new CSLL with nodes 1, 2, and 3
        CSLL list = new CSLL();
        list.SortedInsert(new DNode(2));
        list.SortedInsert(new DNode(1));
        list.SortedInsert(new DNode(3));

        // Delete the head node (node 1)
        list.DeleteHead();

        // Check that the head node is now node 2
        assertEquals(2, list.getHead().getData());

        // Check that the list has size 2
        assertEquals(2, list.getSize());
    }
    @Test
    public void testDeleteTail() {
        // Create a new CSLL with nodes 1, 2, and 3
        CSLL list = new CSLL();
        list.SortedInsert(new DNode(2));
        list.SortedInsert(new DNode(1));
        list.SortedInsert(new DNode(3));

        // Delete the tail node (node 3)
        list.DeleteTail();

        // Check that the tail node is now node 2
        assertEquals(2, list.getTail().getData());

        // Check that the list has size 2
        assertEquals(2, list.getSize());
    }
    @Test
    public void testDelete() {
        // Create a new CSLL with nodes 1, 2, and 3
        CSLL list = new CSLL();
        list.SortedInsert(new DNode(2));
        list.SortedInsert(new DNode(1));
        list.SortedInsert(new DNode(3));

        // Delete the node with data 2
        list.Delete(new DNode(2));

        // Check that the list has size 2
        assertEquals(2, list.getSize());

        // Check that the list contains nodes 1 and 3 in that order
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
    }

    @Test
    public void testDeleteHeadAgain() {
        // Create a new CSLL with nodes 1, 2, and 3
        CSLL list = new CSLL();
        list.SortedInsert(new DNode(2));
        list.SortedInsert(new DNode(1));
        list.SortedInsert(new DNode(3));

        // Delete the head node (node 1)
        list.DeleteHead();

        // Check that the head node is now node 2
        assertEquals(2, list.getHead().getData());

        // Check that the list has size 2
        assertEquals(2, list.getSize());
    }
}