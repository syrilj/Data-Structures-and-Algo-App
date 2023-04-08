

import myLib.datastructures.Linear.SLL;
import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SLLTest {

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
        sll.SortedInsert(new DNode(2));
        sll.SortedInsert(new DNode(1));
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
