package myLib.datastructures.Heap;

import java.util.Vector;

public abstract class Heap {
    protected Vector<Integer> elements;

    /**
     * Constructors
     */
    public Heap() {
        elements = new Vector<>();
    }

    /**
     * constructor
     * @param size
     */
    public Heap(int size) {
        elements = new Vector<Integer>(size);
    }

    /**
     * constructor
     * @param array
     */
    public Heap(int[] array) {
        elements = new Vector<Integer>();
        for (int i : array) {
            elements.add(i);
        }
    }

    /**
     * helper function
     * @param a
     * @param b
     * @return
     */
    protected abstract boolean compare(int a, int b);

    /**
     * additional helpers
     * @param i
     * @return
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * more helpers
     * @param i
     * @return
     */
    protected int left(int i) {
        return 2 * i + 1;
    }

    /**
     * helpers
     * @param i
     * @return
     */
    protected int right(int i) {
        return 2 * i + 2;
    }

    /**
     * swap funciton
     * @param x
     * @param y
     */
    protected void swap(int x, int y) {
        int temp = elements.get(x);
        elements.set(x, elements.get(y));
        elements.set(y, temp);
    }

    protected void heapifyDown(int i) {
        int left = left(i);
        int right = right(i);
        int smallestOrLargest = i;

        if (left < elements.size() && compare(elements.get(left), elements.get(smallestOrLargest))) {
            smallestOrLargest = left;
        }
        if (right < elements.size() && compare(elements.get(right), elements.get(smallestOrLargest))) {
            smallestOrLargest = right;
        }
        if (smallestOrLargest != i) {
            swap(i, smallestOrLargest);
            heapifyDown(smallestOrLargest);
        }
    }

    /**
     * Moves the element at the given index up the heap as necessary to maintain the heap property
     * @param i the index of the element to move up
     */
    protected void heapifyUp(int i) {
        int parentIndex = parent(i);
        while (i > 0 && compare(elements.get(i), elements.get(parentIndex))) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = parent(i);
        }
    }





    /**
     * Returns the size of the vector containing elements
     * @return
     */
    public int getSize() {
        return elements.size();
    }

    /**
     * returns a Boolean True if the vector is empty, False otherwise
     * @return
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * clears the elements of the vector
     */
    public void clear() {
        elements.clear();
    }

    /**
     * searches for the value “ i ” in the heap
     * @param i
     * @return
     */
    public boolean contains(Integer i) {
        return elements.contains(i);
    }

    /**
     * inserts the value key to the vector and maintains heap properties
     * @param key
     */
    public void insert(Integer key) {
        elements.add(key);
        heapifyUp(elements.size() - 1);
    }

    /**
     * removes the value key from the vector and maintains heap properties
     * @param key
     */
    public void delete(Integer key) {
        int index = elements.indexOf(key);
        if (index != -1) {
            swap(index, elements.size() - 1);
            elements.remove(elements.size() - 1);
            heapifyDown(index);
            heapifyUp(index);
        }
    }
/**
 * applies heapsort to the vector content
 */
    public void sort() {
        for (int i = elements.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
        for (int i = elements.size() - 1; i >= 0; i--) {
            swap(0, i);
            heapifyDown(0);
        }
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
        StringBuilder parentIndexes = new StringBuilder("-1 ");
        StringBuilder elementsLine = new StringBuilder(elements.get(0) + " ");

        for (int i = 1; i < elements.size(); i++) {
            int parentIndex;
            if (i % 2 == 0) {
                parentIndex = parent(i);
            } else {
                parentIndex = parent(i - 1);
            }
            parentIndexes.append(parentIndex).append(" ");

            elementsLine.append(elements.get(i)).append(" ");

            // Update the top row if it's the last element of the bottom row
            if (i == elements.size() - 1) {
                parentIndexes.append(parentIndex).append(" ");
            }
        }
        System.out.println(parentIndexes.toString().trim());
        System.out.println(elementsLine.toString().trim());
    }








}
