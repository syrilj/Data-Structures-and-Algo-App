import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import myLib.datastructures.Trees.BST;
import myLib.datastructures.nodes.TNode;

public class BSTTest {
    @Test
    void testInsert() {
        BST tree = new BST();
        tree.Insert(4);
        tree.Insert(2);
        tree.Insert(1);
        tree.Insert(3);
        tree.Insert(6);
        tree.Insert(5);
        tree.Insert(7);
        Assertions.assertEquals(4, tree.getRoot().getData());
        Assertions.assertEquals(2, tree.getRoot().getLeft().getData());
        Assertions.assertEquals(1, tree.getRoot().getLeft().getLeft().getData());
        Assertions.assertEquals(3, tree.getRoot().getLeft().getRight().getData());
        Assertions.assertEquals(6, tree.getRoot().getRight().getData());
        Assertions.assertEquals(5, tree.getRoot().getRight().getLeft().getData());
        Assertions.assertEquals(7, tree.getRoot().getRight().getRight().getData());
    }



    @Test
    void testSearch() {
        BST tree = new BST();
        tree.Insert(4);
        tree.Insert(2);
        tree.Insert(1);
        tree.Insert(3);
        tree.Insert(6);
        tree.Insert(5);
        tree.Insert(7);
        TNode node = tree.Search(6);
        Assertions.assertNotNull(node);
        Assertions.assertEquals(6, node.getData());
        node = tree.Search(8);
        Assertions.assertNull(node);
    }

    @Test
    void testPrintInOrder() {
        BST tree = new BST();
        tree.Insert(4);
        tree.Insert(2);
        tree.Insert(1);
        tree.Insert(3);
        tree.Insert(6);
        tree.Insert(5);
        tree.Insert(7);
        tree.printInOrder();
        // output should be: 1 2 3 4 5 6 7
    }

    @Test
    void testPrintBF() {
        BST tree = new BST();
        tree.Insert(4);
        tree.Insert(2);
        tree.Insert(1);
        tree.Insert(3);
        tree.Insert(6);
        tree.Insert(5);
        tree.Insert(7);
        tree.printBF();
        // output should be: 4 2 6 1 3 5 7
    }
}
