package myLib.datastructures.Heap;

public class MaxH extends Heap {

    public MaxH() {
        super();
    }

    public MaxH(int size) {
        super(size);
    }

    public MaxH(int[] array) {
        super(array);
    }
@Override
    protected boolean compare(int a, int b) {
        return a > b;
    }

    public int peekMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return elements.get(0);
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        heapifyDown(1);
        return max;
    }


    public void increaseKey(int i, int key) {
        if (i < 0 || i >= elements.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        if (key < elements.get(i)) {
            throw new IllegalArgumentException("New key is smaller than current key");
        }
        elements.set(i, key);
        heapifyUp(i);
    }

    public void insert(int key) {
        super.insert(key);
    }

    public void delete(int key) {
        super.delete(key);
    }

    public void sortDescending() {
        sort();
    }

    public void sortAscending() {
        int n = elements.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            heapifyDown(0, i);
        }
    }

    protected void heapifyDown(int i, int end) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < end && compare(elements.get(left), elements.get(largest))) {
            largest = left;
        }
        if (right < end && compare(elements.get(right), elements.get(largest))) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest, end);
        }
    }


}
