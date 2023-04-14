import myLib.datastructures.Linear.CSLL;
import myLib.datastructures.Linear.SLL;
import myLib.datastructures.nodes.DNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CSLLTest {





   private CSLL list = new CSLL();
   @Before
   public void setUp(){
       list = new CSLL();
       DNode node1 = new DNode(1);
       DNode node2 = new DNode(2);
       DNode node3 = new DNode(3);
       list.InsertHead(node3);
       list.InsertTail(node1);
       list.Insert(node2,1);
   }

   @Test
   public void testDelete2(){
       DNode node1 = new DNode(5);
       list.Insert(node1,2);
       assertEquals(list.getLength(),4);
       list.Delete(node1);
       assertEquals(list.getLength(),3);
       assertNull(list.Search(node1));
   }


    @Test
    public void testInsertHead() {
        // Insert a node at the head of the list
        list.InsertHead(new DNode(1));
        System.out.println(list.getHead().getData());
        // Check if the head node has changed
        assertEquals(1, list.getHead().getData());
    }

//    @Before
//    public void setUp() {
//        list = new CSLL();
//    }

    @Test
    public void testInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        // Test inserting at position 0 in empty list
        list.Insert(node1, 0);
        assertEquals(node1, list.getHead());

        // Test inserting at position 1 in list with 1 node
        list.Insert(node2, 1);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getHead().getNext());

        // Test inserting at position 0 in list with 2 nodes
        list.Insert(node3, 0);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getHead().getNext());
        assertEquals(node2, list.getHead().getNext().getNext());

        // Test inserting at position 2 in list with 3 nodes
        DNode node4 = new DNode(4);
        list.Insert(node4, 2);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getHead().getNext());
        assertEquals(node4, list.getHead().getNext().getNext());
        assertEquals(node2, list.getHead().getNext().getNext().getNext());
    }

    @Test
    public void testInsertTail() {
        // Insert a node at the tail of the list
        list.InsertTail(new DNode(2));

        // Check if the tail node has changed
        assertEquals(2, list.getTail().getData());
    }

//    @Test
//    public void testInsert() {
//        // Insert a node at a specific position in the list
//        list.Insert(new DNode(3), 1);
//
//        // Check if the node has been inserted correctly
//        assertEquals(3, list.Search(1).getData());
//    }

    @Test
    public void testSortedInsert() {
        // Insert a node in sorted order
        CSLL list = new CSLL();
        list.SortedInsert(new DNode(0));
        list.Print();
        // Check if the node has been inserted correctly
        assertEquals(0, list.getHead());
    }

    @Test
    public void testSearch() {
        // Search for a node
        DNode node = list.Search(new DNode(4));

        // Check if the correct node has been found
        assertEquals(4, node.getData());
    }

    @Test
    public void testDeleteHead() {
        // Delete a node from the head of the list
        list.DeleteHead();

        // Check if the head node has changed
        assertEquals(4, list.getHead().getData());
    }

    @Test
    public void testDeleteTail() {
        // Delete a node from the tail of the list
        list.DeleteTail();

        // Check if the tail node has changed
        assertEquals(4, list.getTail().getData());
    }

    @Test
    public void testDelete() {
        // Delete a specific node from the list
        list.Delete(new DNode(4));

        // Check if the node has been deleted correctly
        assertNull(list.Search(new DNode(4)));
    }

    @Test
    public void testIsSorted() {
        // Check if the list is sorted
        assertTrue(list.isSorted());
    }

    @Test
    public void testSort() {
        // Sort the list
        list.Sort();

        // Check if the list is sorted correctly
        assertTrue(list.isSorted());
        assertEquals(4, list.getHead().getData());
    }

    @Test
    public void testClear() {
        // Clear the list
        list.Clear();

        // Check if the list is empty
        assertEquals(0, list.getLength());
    }
}
