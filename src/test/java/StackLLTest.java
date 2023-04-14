import myLib.datastructures.Linear.StackLL;
import myLib.datastructures.nodes.DNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackLLTest {

    @Test
    public void testPushPopPeek() {
        StackLL stack = new StackLL();

        // test pushing a single element onto the stack
        DNode node1 = new DNode(1);
        stack.Push(node1);
        assertEquals("Stack should contain 1 element", 1, stack.getLength());
        assertEquals("Top element should be 1", node1, stack.Peek());

        // test pushing multiple elements onto the stack
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        stack.Push(node2);
        stack.Push(node3);
        assertEquals("Stack should contain 3 elements", 3, stack.getLength());
        assertEquals("Top element should be 3", node3, stack.Peek());

        // test popping elements from the stack
        stack.Pop();
        assertEquals("Stack should contain 2 elements after popping", 2, stack.getLength());
        assertEquals("Top element should be 2 after popping", node2, stack.Peek());
        stack.Pop();
        assertEquals("Stack should contain 1 element after popping", 1, stack.getLength());
        assertEquals("Top element should be 1 after popping", node1, stack.Peek());
        stack.Pop();
        assertEquals("Stack should be empty after popping", true, stack.Empty());
    }

    @Test
    public void testSeek() {
        StackLL stack = new StackLL();

        // test seeking an element in an empty stack
        DNode node1 = new DNode(1);
        assertEquals("Seek should return -1 in an empty stack", -1, stack.Seek(node1));

        // test seeking an element in a non-empty stack
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        stack.Push(node1);
        stack.Push(node2);
        stack.Push(node3);
        assertEquals("Seek should return 1 for the first element in the stack", 1, stack.Seek(node3));
        assertEquals("Seek should return 3 for the last element in the stack", 3, stack.Seek(node1));
        assertEquals("Seek should return 2 for the second element in the stack", 2, stack.Seek(node2));
        DNode node4 = new DNode(4);
        assertEquals("Seek should return -1 for an element not in the stack", -1, stack.Seek(node4));
    }
}
