import myLib.datastructures.Heap.Heap;
import myLib.datastructures.Heap.MaxH;
import myLib.datastructures.Heap.MinH;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {
    @Test
    public void testHeapInsertion() {
        Heap h = new MinH();
        h.insert(5);
        h.insert(10);
        h.insert(7);
        h.insert(8);
        assertEquals(4, h.getSize());
    }

    @Test
    public void testHeapDeletion() {
        Heap h = new MaxH();
        h.insert(5);
        h.insert(10);
        h.insert(7);
        h.delete(10);
        assertEquals(2, h.getSize());
    }

    @Test
    public void testHeapSorting() {
        Heap h = new MinH(new int[]{4, 8, 2, 5, 1, 6, 3, 7});
        h.sort();
    }

    @Test
    public void testHeapPrint() {
        Heap h = new MaxH(new int[]{4, 8, 2, 5, 1, 6, 3, 7});
        h.print();
    }
}