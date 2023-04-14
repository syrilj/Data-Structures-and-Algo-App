import myLib.datastructures.Trees.AVL;
import myLib.datastructures.nodes.TNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class AVLTest {

    @Test
    public void testInsert() {
        AVL tree = new AVL();
        tree.Insert(10);
        tree.Insert(20);
        tree.Insert(30);
        tree.Insert(40);
        tree.Insert(50);
        assertTrue(tree.Search(30) != null);
        assertTrue(tree.Search(60) == null);
    }
    @Test
    public void testBalancing() {
        AVL avl = new AVL();
        avl.Insert(10);
        avl.Insert(5);
        avl.Insert(15);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(13);
        avl.Insert(20);
        avl.Insert(2);
        avl.Insert(4);
        avl.Insert(6);
        avl.Insert(8);
        avl.Insert(12);
        avl.Insert(14);
        avl.Insert(18);
        avl.Insert(25);
        avl.Insert(1);
        avl.Insert(30);

        TNode root = avl.getRoot();

        // Verify that the tree is balanced
        assertTrue(Math.abs(avl.getHeight((root.getLeft()))- avl.getHeight(root.getRight())) <= 1);
        assertTrue(Math.abs(avl.getHeight(root.getLeft().getLeft()) - avl.getHeight(root.getLeft().getRight())) <= 1);
        assertTrue(Math.abs(avl.getHeight(root.getRight().getLeft()) - avl.getHeight(root.getRight().getRight())) <= 1);
    }

    @Test
    public void testDelete() {
        AVL tree = new AVL();
        tree.Insert(10);
        tree.Insert(20);
        tree.Insert(30);
        tree.Insert(40);
        tree.Insert(50);
        assertTrue(tree.Search(30) != null);
        tree.Delete(30);
        assertTrue(tree.Search(30) == null);
        assertTrue(tree.Search(40) != null);
    }

    @Test
    public void testSearch() {
        AVL tree = new AVL();
        tree.Insert(10);
        tree.Insert(20);
        tree.Insert(30);
        tree.Insert(40);
        tree.Insert(50);
        assertTrue(tree.Search(30) != null);
        assertTrue(tree.Search(60) == null);
    }
}
