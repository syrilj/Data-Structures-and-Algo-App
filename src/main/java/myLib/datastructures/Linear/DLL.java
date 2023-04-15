package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;
/**
 * A class that represents a doubly-linked list.
 */
public class DLL {
    private DNode head;
    private DNode tail;
    private int count;
    /**
     * Constructs an empty doubly-linked list.
     * Default constructor needs to account for tail
     */
    public DLL() {
        head = null;
        tail = null;
        count = 0;
    }


    public DNode getTail() {
        return this.tail;
    }

    public DNode getHead() {
        return this.head;
    }

    public int getLength() {
        return this.count;
    }

    /**
     * Constructor overload with one node initializes the list with head and tail pointing
     * to the same node
     *
     * @param head the head node of the list
     */
    public DLL(DNode head) {
        this.head = head;
        tail = null;
        count = 1;
        DNode present = head;
        while (present.getNext() != null) {
            present = present.getNext();
            count++;
        }
        tail = present;
    }
    /**
     * Inserts a node at the beginning of the list.
     *
     * @param node the node to be inserted
     */
    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        count++;
    }

    /**
     * Inserts a node at the end of the list.
     *
     * @param node the node to be inserted
     */
    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        count++;
    }
    /**
     * Inserts a node at the given position in the list.
     *
     * @param node     the node to be inserted
     * @param position the position at which to insert the node (1-based)
     * @throws IndexOutOfBoundsException if the position is out of bounds
     */
    public void Insert(DNode node, int position) {
        if (position < 1 || position > count + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == count + 1) {
            InsertTail(node);
        } else {
            DNode present = head;
            for (int i = 1; i < position - 1; i++) {
                present = present.getNext();
            }
            node.setNext(present.getNext());
            node.setPrevious(present);
            present.getNext().setPrevious(node);
            present.setNext(node);
            count++;
        }
    }
    /**
     * Inserts a node into the list in sorted order.
     *
     * @param node the node to be inserted
     */
    public void SortedInsert(DNode node) {
        if (head == null) {
            InsertHead(node);
            return;
        }

        if (!isSorted()) {
            Sort();
        }

        DNode present = head;
        DNode previous = null;

        while (present != null && node.getData() > present.getData()) {
            previous = present;
            present = present.getNext();
        }

        if (previous == null) {
            InsertHead(node);
        } else {
            previous.setNext(node);
            node.setPrevious(previous);
            node.setNext(present);
            if (present != null) {
                present.setPrevious(node);
            } else {
                tail = node;
            }
        }
    }
    /**
     * Searches for a node in the list.
     *
     * @param node the node to search for
     * @return the node if found, or null if not found
     */
    public DNode Search(DNode node) {
        DNode present =getHead();
        while (present != null) {
            if (present.getData() == node.getData()) {
                return present;
            }
            present = present.getNext();
        }
        return null;
    }


    /**
     * Deletes the head node of the list.
     */
    public void DeleteHead() {
        if (head == null) {
            return;
        }
        head.getNext().setPrevious(null);
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        count--;
    }
    /**
     * Deletes the tail node of the list.
     */
    public void DeleteTail() {
        if (head == null) {
            return;
        }
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            DNode present = head;
            while (present.getNext() != tail) {
                present = present.getNext();
            }
            tail = present;
            tail.setNext(null);
        }
        count--;
    }

    /**
     * Deletes the given node from the list.
     *
     * @param node the node to be deleted
     */

    public void Delete(DNode node) {
        if (head == null) {
            return;
        }
        DNode nodeToDelete = this.Search(node);
        if (nodeToDelete == null) {
            return;
        }
        if (nodeToDelete == head) {
            head = nodeToDelete.getNext();
        } else {
            nodeToDelete.getPrevious().setNext(nodeToDelete.getNext());
        }
        if (nodeToDelete == tail) {
            tail = nodeToDelete.getPrevious();
        } else {
            nodeToDelete.getNext().setPrevious(nodeToDelete.getPrevious());
        }
        nodeToDelete.setNext(null);
        nodeToDelete.setPrevious(null);
        count--;
    }


    /**
     * Returns true if the list is sorted.
     *
     * @return true if the list is sorted, false otherwise
     */
    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        DNode present = head;
        while (present.getNext() != null) {
            if (present.getData() > present.getNext().getData()) {
                return false;
            }
            present = present.getNext();
        }
        return true;
    }
    /**
     * Sorts the list.
     */

    public void Sort() {
        if (head == null || head.getNext() == null) {
            return;
        }
        DNode present = head;
        head = null;
        count = 0;

        while (present != null) {
            DNode next = present.getNext();
            present.setNext(null);
            SortedInsert(present);
            present = next;
        }
    }
    /**
     * Clears the list.
     */
    public void Clear() {
        head = null;
        tail = null;
        count = 0;
    }
    /**
     * Prints information about the list to the console.
     */
    public void Print() {
        int length = 0;
        boolean isSorted = isSorted();
        DNode present = head;

        while (present != null) {
            length++;
            present = present.getNext();
        }

        System.out.println("List length: " + length);
        System.out.println("Sort status: " + (isSorted ? "Sorted" : "Unsorted"));

        present = head;

        if (present == null) {
            System.out.println("Empty List");
        } else {
            System.out.println("List content:");
            System.out.println("---------------------------------");
            System.out.printf("| %-5s | %-10s |\n", "Index", "Data");
            System.out.println("---------------------------------");
            int i = 1;
            while (present != null) {
                System.out.printf("| %-5d | %-10d |\n", i, present.getData());
                present = present.getNext();
                i++;
            }
            System.out.println("---------------------------------");
        }
    }




}