//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import myLib.datastructures.Trees.BST;
//import myLib.datastructures.nodes.TNode;
//
//public class BSTTest {
//
//    private BST tree;
//
//    @Before
//    public void setUp() throws Exception {
//        tree = new BST();
//    }
//
//    @Test
//    public void testInsertAndGetRoot() {
//        tree.insert(5);
//        assertEquals(5, tree.getRoot().getData());
//    }
//
//    @Test
//    public void testInsert() {
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        assertEquals(5, tree.getRoot().getData());
//        assertEquals(3, tree.getRoot().getLeft().getData());
//        assertEquals(7, tree.getRoot().getRight().getData());
//        assertEquals(2, tree.getRoot().getLeft().getLeft().getData());
//        assertEquals(4, tree.getRoot().getLeft().getRight().getData());
//        assertEquals(6, tree.getRoot().getRight().getLeft().getData());
//        assertEquals(8, tree.getRoot().getRight().getRight().getData());
//    }
//
//    @Test
//    public void testDelete() {
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        tree.delete(3);
//        assertNull(tree.search(3));
//        assertEquals(4, tree.getRoot().getLeft().getData());
//    }
//
//    @Test
//    public void testSearch() {
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        assertNotNull(tree.search(5));
//        assertNotNull(tree.search(3));
//        assertNotNull(tree.search(7));
//        assertNotNull(tree.search(2));
//        assertNotNull(tree.search(4));
//        assertNotNull(tree.search(6));
//        assertNotNull(tree.search(8));
//        assertNull(tree.search(1));
//    }
//
//    @Test
//    public void testPrintInOrder() {
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        tree.printInOrder();
//        // Expected output: 2 3 4 5 6 7 8
//    }
//
//    @Test
//    public void testPrintBF() {
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        tree.printBF();
//        // Expected output: 5 3 7 2 4 6 8
//    }
//
//}
