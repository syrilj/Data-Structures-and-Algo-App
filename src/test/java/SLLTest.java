

import myLib.datastructures.Linear.SLL;
import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SLLTest {

//    public static void main(String[] args) {
//        System.out.println("Running through some functionality testing of SLL");
//        System.out.println("-------------------------------------------------");
//        SLL list = new SLL();
//
//        // Insert 10 at the head of the list
//        DNode node1 = new DNode(10);
//        list.InsertHead(node1);
//
//        // Insert 20 at the tail of the list
//        DNode node2 = new DNode(20);
//        list.InsertTail(node2);
//
//        // Insert 15 at position 1 in the list
//        DNode node3 = new DNode(11);
//        list.Insert(node3, 1);
//
//        // Insert 5 at position 0 in the list
//        DNode node4 = new DNode(5);
//        list.Insert(node4, 0);
//
//        // Insert 25 at position 4 in the list
//        DNode node5 = new DNode(25);
//        list.Insert(node5, 4);
//
//        // Print the list
//        list.Print();
//
//        // Search for node with data = 15
//        DNode node6 = new DNode(12);
//        DNode foundNode = list.Search(node6);
//        if (foundNode != null) {
//            System.out.println("Node with data = " + node6.getData() + " found in list.");
//        } else {
//            System.out.println("Node with data = " + node6.getData() + " not found in list.");
//        }
//
//        // Delete the node at the head of the list
//        list.DeleteHead();
//
//        // Delete the node at the tail of the list
//        list.DeleteTail();
//
//        // Delete the node with data = 15
//        DNode node7 = new DNode(11);
//        list.Delete(node7);
//
//        // Print the list
//        list.Print();
//        System.out.println("-------------------------------------------------");
//        System.out.println("Finished running through some functionality testing of SLL");
//
//    }

    SLL sll;

    @BeforeEach
    void setUp() {
        sll = new SLL();
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(sll.isEmpty());
        sll.InsertHead(new DNode(1));
        Assertions.assertFalse(sll.isEmpty());
    }

    @Test
    void testGetHead() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        Assertions.assertEquals(2, sll.getHead().getData());
    }

    @Test
    void testGetTail() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        sll.InsertTail(new DNode(3));
        Assertions.assertEquals(3, sll.getTail().getData());
    }

    @Test
    void testGetLength() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        sll.InsertTail(new DNode(3));
        Assertions.assertEquals(3, sll.getLength());
    }

    @Test
    void testSetLength() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        sll.InsertTail(new DNode(3));
        sll.setLength(5);
        Assertions.assertEquals(5, sll.getLength());
    }

    @Test
    void testInsertHead() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        Assertions.assertEquals(2, sll.getHead().getData());
    }

    @Test
    void testInsertTail() {
        sll.InsertHead(new DNode(1));
        sll.InsertTail(new DNode(2));
        Assertions.assertEquals(2, sll.getTail().getData());
    }

    @Test
    void testInsert() {
        sll.InsertHead(new DNode(1));
        sll.Insert(new DNode(2), 1);
        Assertions.assertEquals(2, sll.getHead().getNext().getData());
    }

    @Test
    void testSortedInsert() {
        sll.SortedInsert(new DNode(1));
        sll.SortedInsert(new DNode(2));
        sll.SortedInsert(new DNode(3));
        Assertions.assertEquals(1, sll.getHead().getData());
        Assertions.assertEquals(3, sll.getTail().getData());
    }

    @Test
    void testDeleteHead() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        sll.DeleteHead();
        Assertions.assertEquals(1, sll.getHead().getData());
    }

    @Test
    void testDeleteTail() {
        sll.InsertHead(new DNode(1));
        sll.InsertHead(new DNode(2));
        sll.InsertTail(new DNode(3));
        sll.DeleteTail();
        Assertions.assertEquals(1, sll.getTail().getData());
    }
    @Test
    void testInsertMiddle() {
        sll.InsertHead(new DNode(1));
        sll.InsertTail(new DNode(3));
        sll.Insert(new DNode(2), 1);
        Assertions.assertEquals(2, sll.getHead().getNext().getData());
    }
    @Test
    void testDeleteMiddle() {
        sll.InsertHead(new DNode(1));
        sll.Insert(new DNode(2), 1);
        sll.InsertTail(new DNode(3));
        sll.Delete(new DNode(1));
        Assertions.assertEquals(3, sll.getHead().getNext().getData());
    }

    @Test
    void testSortedInsertEmpty() {
        sll.SortedInsert(new DNode(2));
        Assertions.assertEquals(2, sll.getHead().getData());
    }



}
