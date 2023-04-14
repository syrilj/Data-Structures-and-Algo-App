import static org.junit.jupiter.api.Assertions.*;

import myLib.datastructures.Heap.MinH;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHTest {

    private MinH heap;

    @BeforeEach
    public void setUp() {
        heap = new MinH();
    }

    @Test
    public void testInsertAndGetMin() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        assertEquals(1, heap.getMin());
    }

    @Test
    public void testExtractMin() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }

    @Test
    public void testDecreaseKey() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        heap.decreaseKey(2, 0);
        assertEquals(0, heap.getMin());
    }

    @Test
    public void testBuildHeap() {
        int[] array = {3, 1, 5, 2, 4};
        MinH heap = MinH.buildHeap(array);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }


}
