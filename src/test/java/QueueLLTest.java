import myLib.datastructures.Linear.QueueLL;
import myLib.datastructures.nodes.DNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueLLTest {

    @Test
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        assertEquals(queue.Peek(), node1);
    }

    @Test
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        queue.Dequeue();
        assertEquals(queue.Peek(), node2);
    }

    @Test
    public void testPeek() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        assertEquals(queue.Peek(), node1);
    }

    @Test
    public void testSeek() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        assertEquals(queue.Seek(node1), 1);
        assertEquals(queue.Seek(node2), 2);
        DNode node3 = new DNode(3);
        assertEquals(queue.Seek(node3), -1);
    }

    @Test
    public void testEmpty() {
        QueueLL queue = new QueueLL();
        assertTrue(queue.Empty());
        DNode node1 = new DNode(1);
        queue.Enqueue(node1);
        assertFalse(queue.Empty());
    }

    @Test
    public void testClear() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        queue.Clear();
        assertTrue(queue.Empty());
    }

    @Test
    public void testPrint() {
        QueueLL queue = new QueueLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        queue.Enqueue(node1);
        queue.Enqueue(node2);
        queue.Print();
    }
}
