import static org.junit.Assert.*;

import myLib.datastructures.Trees.AVL;
import myLib.datastructures.nodes.TNode;
import org.junit.Before;
import org.junit.Test;

public class AVLTest {

    private AVL tree;

    @Before
    public void setUp() {
        tree = new AVL();
    }

    @Test
    public void testConstructor() {
        assertNull(tree.getRoot());

        int val = 5;
        AVL tree2 = new AVL(val);
        assertEquals(val, tree2.getRoot().getData());

        TNode root = new TNode(10);
        root.setLeft(new TNode(5));
        root.setRight(new TNode(15));
        AVL tree3 = new AVL(root);
        assertEquals(root.getData(), tree3.getRoot().getData());
        assertEquals(root.getLeft().getData(), tree3.getRoot().getLeft().getData());
        assertEquals(root.getRight().getData(), tree3.getRoot().getRight().getData());
    }

    @Test
    public void testInsert() {
        tree.Insert(5);
        tree.Insert(10);
        tree.Insert(15);

        assertEquals(10, tree.getRoot().getData());
        assertEquals(5, tree.getRoot().getLeft().getData());
        assertEquals(15, tree.getRoot().getRight().getData());

        tree.Insert(new TNode(20));
        assertEquals(15, tree.getRoot().getRight().getData());
        assertEquals(20, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDelete() {
        tree.Insert(5);
        tree.Insert(10);
        tree.Insert(15);
        tree.Insert(20);
        tree.Delete(10);

        assertEquals(15, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft().getRight());
    }

    @Test
    public void testSearch() {
        tree.Insert(5);
        tree.Insert(10);
        tree.Insert(15);

        assertEquals(10, tree.Search(10).getData());
        assertNull(tree.Search(20));
    }

    @Test
    public void testPrintInOrder() {
        tree.Insert(5);
        tree.Insert(10);
        tree.Insert(15);

        String expected = "5 10 15 ";
        tree.printInOrder();
    }

    @Test
    public void testPrintBF() {
        tree.Insert(5);
        tree.Insert(10);
        tree.Insert(15);
        tree.Insert(20);

        String expected = "10 5 15 20";
        tree.printBF();
    }
    @Test
    public void testBalancing() {
        // create a new AVL tree object
        AVL tree = new AVL(20);

        // insert some nodes into the tree
        tree.Insert(50);
        tree.Insert(30);
        tree.Insert(40);
        tree.Insert(70);
        tree.Insert(60);
        tree.Insert(80);

        // check if tree is balanced
        assertTrue(isBalanced(tree.getRoot()));

        // create an unbalanced tree
        TNode unbalancedTree = new TNode(50);
        unbalancedTree.setLeft(new TNode(30));
        unbalancedTree.getLeft().setLeft(new TNode(20));
        unbalancedTree.getLeft().setRight(new TNode(40));
        unbalancedTree.setRight(new TNode(70));
        unbalancedTree.getRight().setLeft(new TNode(60));
        unbalancedTree.getRight().setRight(new TNode(80));

        // create a new AVL tree from the unbalanced tree
        AVL balancedTree = new AVL(unbalancedTree);

        // check if balancedTree is balanced
        assertTrue(isBalanced(balancedTree.getRoot()));

        // delete a node from the tree
        tree.Delete(30);

        // check if tree is still balanced
        assertTrue(isBalanced(tree.getRoot()));

        // search for a node in the tree
        TNode node = tree.Search(40);
        assertNotNull(node);
        assertEquals(40, node.data);
    }

    private boolean isBalanced(TNode node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int diff = Math.abs(leftHeight - rightHeight);

        if (diff > 1) {
            return false;
        }

        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
