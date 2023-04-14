import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import myLib.datastructures.Heap.MaxH;
import org.junit.Before;
import org.junit.Test;

public class MaxHTest {
    private MaxH heap;

    @Before
    public void setUp() {
        heap = new MaxH();
    }

    @Test
    public void testInsertAndGetMax() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        assertEquals(10, heap.getMax());
    }

    @Test
    public void testExtractMax() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        assertEquals(10, heap.extractMax());
        assertEquals(8, heap.getMax());
    }

    @Test(expected = IllegalStateException.class)
    public void testExtractMaxEmpty() {
        heap.extractMax();
    }

    @Test
    public void testIncreaseKey() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        heap.increaseKey(2, 15);
        assertEquals(15, heap.getMax());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseKeySmallerValue() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.increaseKey(1, 1);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testPrint() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        heap.print();
    }
}
