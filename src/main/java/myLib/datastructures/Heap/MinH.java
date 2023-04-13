package myLib.datastructures.Heap;

import java.util.Arrays;
import java.util.Vector;

public class MinH extends Heap {

    /**
     * Constructor
     */
    public MinH() {
        elements = new Vector<Integer>();
    }

    /**
     * Constructor
     * @param size
     */
    public MinH(int size) {
        elements = new Vector<Integer>(size);
    }

    /**
     * Constructor
     * @param array
     */
    public MinH(int[] array) {
        elements = new Vector<Integer>();
        for (int i = 0; i < array.length; i++) {
            elements.add(array[i]);
        }
        for (int i = elements.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    /**
     * Helper function to compare two integers
     * @param a
     * @param b
     * @return
     */
    protected boolean compare(int a, int b) {
        return a < b;
    }

    /**
     * Returns the minimum element of the heap
     * @return
     */
    public int getMin() {
        if (elements.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return elements.get(0);
    }

    /**
     * Removes and returns the minimum element of the heap
     * @return
     */
    public int extractMin() {
        if (elements.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = elements.get(0);
        if (elements.size() == 1) {
            elements.remove(0);
        } else {
            elements.set(0, elements.remove(elements.size() - 1));
            heapifyDown(0);
        }
        return min;
    }

    /**
     * Decreases the key of an element at a given index
     * @param i
     * @param key
     */
    public void decreaseKey(int i, int key) {
        if (key >= elements.get(i)) {
            throw new IllegalArgumentException("New key is not smaller than current key");
        }
        elements.set(i, key);
        int parent = (i - 1) / 2;
        if (i > 0 && compare(elements.get(i), elements.get(parent))) {
            heapifyUp(i);
        } else {
            heapifyDown(i);
        }
    }

    /**
     * Inserts a new element into the heap
     * @param key
     */
    public void insert(int key) {
        elements.add(key);
        heapifyUp(elements.size() - 1);
    }

    /**
     * Builds a heap from an array
     * @param array
     * @return
     */
    public static MinH buildHeap(int[] array) {
        return new MinH(array);
    }

    /**
     * Sorts an array using heapsort algorithm
     *
     */
    public void sort(){
        super.sort();
    }

    /**
     * Returns a string representation of the heap
     * @return
     */
    @Override
    public String toString() {
        return "MinHeap{" +
                "elements=" + Arrays.toString(elements.toArray()) +
                '}';
    }

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
