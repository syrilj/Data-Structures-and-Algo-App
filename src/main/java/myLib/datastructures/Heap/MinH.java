package myLib.datastructures.Heap;


import java.util.ArrayList;
import java.util.List;

public class MinH extends Heap {

    public MinH() {
        super();
    }

    public MinH(int size) {
        super(size);
    }

    public MinH(int[] array) {
        super(array);
    }

    @Override
    public void insert(Integer key) {
        elements.add(key);
        heapifyUp(elements.size() - 1);
    }

    @Override
    public void delete(Integer key) {
        int index = elements.indexOf(key);

        if (index == -1)
            return;

        int last = elements.size() - 1;
        elements.set(index, elements.get(last));
        elements.remove(last);
        heapifyDown(index);
    }

    @Override
    protected boolean compare(int a, int b) {
        return a < b;
    }

    public int peekMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return elements.get(0);
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        heapifyDown(0);
        return min;
    }
}
