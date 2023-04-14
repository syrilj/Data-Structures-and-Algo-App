import myLib.datastructures.Linear.StackLL;
import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StackLLTest {

    @Test
    void pushPopPeekTest() {
        StackLL stack = new StackLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);


        // push nodes onto the stack
        stack.Push(node1);
        stack.Push(node2);
        stack.Push(node3);

        // peek at the top node without removing it
        assertEquals(node3, stack.Peek());

        // pop the top node
        stack.Pop();
        assertEquals(node2, stack.Peek());

        // pop another node
        stack.Pop();
        assertEquals(node1, stack.Peek());

        // pop the last node
        stack.Pop();
        assertTrue(stack.Empty());
        assertNull(stack.Peek());

    }

    @Test
    void seekTest() {
        StackLL stack = new StackLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        // push nodes onto the stack
        stack.Push(node1);
        stack.Push(node2);
        stack.Push(node3);
        stack.Print();

        // seek nodes in the stack
        assertEquals(1, stack.Seek(node3));
        assertEquals(2, stack.Seek(node2));
        assertEquals(3, stack.Seek(node1));
        assertEquals(-1, stack.Seek(new DNode(4)));

    }
}
