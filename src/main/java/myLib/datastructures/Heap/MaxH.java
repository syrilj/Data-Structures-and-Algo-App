package myLib.datastructures.Heap;


public class MaxH extends Heap {

    public MaxH() {
        super();
    }

    public MaxH(int size) {
        super(size);
    }

    @Override
    public void insert(Integer key) {
        super.insert(key);
    }

    public MaxH(int[] array) {
        super(array);
    }

    @Override
    protected boolean compare(int a, int b) {
        return a > b;
    }

    /**
     * Returns the maximum element in the heap
     * @return
     */
    public int getMax() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return elements.get(0);
    }

    /**
     * Removes and returns the maximum element in the heap
     * @return
     */
    public int extractMax() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        heapifyDown(0);
        return max;
    }

    /**
     * Increases the value of the element at the given index to the given value
     * @param i
     * @param key
     */
    public void increaseKey(int i, int key) {
        if (key < elements.get(i)) {
            throw new IllegalArgumentException("New key is smaller than current key");
        }
        elements.set(i, key);
        heapifyUp(i);
    }

    /**
     * displays the content of the heap vector over 2 lines. First line is the index of the
     * parent of each element.
     */
    /**
     * displays the content of the heap vector over 2 lines. First line is the index of the
     * parent of each element.
     *
     * @return
     */
    public void print() {
        super.print();
    }


}
