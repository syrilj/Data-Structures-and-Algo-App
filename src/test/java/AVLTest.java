import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myLib.datastructures.nodes.TNode;
import myLib.datastructures.Trees.AVL;

class AVLTest {

    @Test
    void testInsert() {
        AVL avl = new AVL();
        avl.Insert(5);
        assertEquals(5, avl.getRoot().getData());
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(1);
        avl.Insert(9);
        avl.Insert(8);
        avl.Insert(6);
        avl.Insert(2);
        avl.Insert(4);
        // Check if the tree is balanced
        assertEquals(2, avl.getRoot().getBalance());
        assertEquals(1, avl.getRoot().getLeft().getBalance());
        assertEquals(0, avl.getRoot().getLeft().getLeft().getBalance());
        assertEquals(0, avl.getRoot().getLeft().getRight().getBalance());
        assertEquals(0, avl.getRoot().getRight().getLeft().getBalance());
        assertEquals(0, avl.getRoot().getRight().getRight().getBalance());
    }

    @Test
    void testDelete() {
        AVL avl = new AVL();
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(1);
        avl.Insert(9);
        avl.Insert(8);
        avl.Insert(6);
        avl.Insert(2);
        avl.Insert(4);
        // Delete leaf node
        avl.Delete(new TNode(2));
        assertEquals(0, avl.getRoot().getBalance());
        assertEquals(1, avl.getRoot().getLeft().getBalance());
        // Delete node with one child
        avl.Delete(new TNode(1));
        assertEquals(1, avl.getRoot().getBalance());
        assertEquals(0, avl.getRoot().getLeft().getBalance());
        // Delete node with two children
        avl.Delete(new TNode(7));
        assertEquals(0, avl.getRoot().getBalance());
        assertEquals(0, avl.getRoot().getRight().getBalance());
    }

    @Test
    void testGetHeight() {
        AVL avl = new AVL();
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(1);
        avl.Insert(9);
        avl.Insert(8);
        avl.Insert(6);
        avl.Insert(2);
        avl.Insert(4);
        assertEquals(3, avl.getHeight(avl.getRoot()));
        assertEquals(2, avl.getHeight(avl.getRoot().getLeft()));
        assertEquals(1, avl.getHeight(avl.getRoot().getLeft().getLeft()));
        assertEquals(-1, avl.getHeight(avl.getRoot().getLeft().getLeft().getLeft()));
    }

    @Test
    void testSetRoot() {
        AVL avl = new AVL();
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(1);
        avl.Insert(9);
        avl.Insert(8);
        avl.Insert(6);
        avl.Insert(2);
        avl.Insert(4);
        TNode newRoot = new TNode(10);
        AVL newAVL = new AVL(newRoot);
        avl.setRoot(newRoot);
        assertEquals(newAVL.getRoot().getData(), avl.getRoot().getData());
    }

}
