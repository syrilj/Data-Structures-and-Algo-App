package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

/**
 The CSLL class represents a Circular Singly Linked List.
 It extends the SLL class and implements its abstract methods.
 The list is circular since the tail node points back to the head node.
 The list is sorted in ascending order.
 */

public class CSLL extends SLL{

    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Constructs an empty CSLL.
     */
    public CSLL(){
       super();
    }

    /**
     * Constructs a CSLL with a given head node.
     *
     * @param head the head node of the CSLL
     */
    public CSLL(DNode head){
        this.head = head;
        this.tail = head;
        this.tracker = 1;
    }


    /**
     * Sorts the CSLL in ascending order.
     * Overrides the Sort() method of SLL.
     */
    /**
     * Sorts the CSLL in ascending order.
     * Overrides the Sort() method of SLL.
     */
    @Override
    public void Sort() {
        if (this.head == null || this.head.getNext() == this.head) {
            return; // nothing to sort
        }

        // perform the sorting algorithm
        super.Sort();

        // reset the tail's next to the head to create a circular list
        this.tail.setNext(this.head);
    }




    /**
     * Inserts a node at the head of the CSLL.
     * Overrides the InsertHead() method of SLL.
     *
     * @param node the node to insert at the head of the CSLL
     */
    @Override
    public void InsertHead(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertHead(node);
        super.getTail().setNext(super.getHead());
    }
    /**
     * Inserts a node at the tail of the CSLL.
     * Overrides the InsertTail() method of SLL.
     *
     * @param node the node to insert at the tail of the CSLL
     */
    @Override
    public void InsertTail(DNode node){
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertTail(node);
        super.getTail().setNext(super.getHead());
    }
    /**
     * Inserts a node at a given position in the CSLL.
     * Overrides the Insert() method of SLL.
     *
     * @param node the node to insert at the given position
     * @param position the position to insert the node at
     * @throws IndexOutOfBoundsException if the given position is less than 1 or greater than the size of the CSLL plus 1
     */
    @Override
    public void Insert(DNode node, int position){
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.Insert(node, position);
        super.getTail().setNext(super.getHead());
    }

    /**
     * Inserts a node into the sorted circular linked list in sorted order.
     * If the list is empty, sets the head and tail to the new node.
     *
     * @param node the node to be inserted into the list
     */
    @Override
    public void SortedInsert(DNode node) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.SortedInsert(node);
        super.getTail().setNext(super.getHead());
    }










    /**
     * Searches for a node with the same data as the given node in the list.
     *
     * @param node the node to be searched for in the list
     * @return the node with the same data as the given node, or null if not found
     */
    @Override
    public DNode Search(DNode node){
        return super.Search(node);
    }

    /**
     * Delete head of the circular list
     */
    @Override
    public void DeleteHead() {
        if (this.head == null) {
            return;
        }
        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
            this.tracker = 0;
            return;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            this.tracker--;
        }
    }

    /**
     * Deletes the tail of the circular list
     */
    @Override
    public void DeleteTail() {
        if (this.head == null) {
            return;
        }
        if (this.head.getNext() == this.head) {
            this.head = null;
            this.tracker = 0;
            this.tail = null; // Update the tail pointer to null
            return;
        }
        DNode intr = this.head;
        while (intr.getNext() != this.tail) {
            intr = intr.getNext();
        }
        intr.setNext(this.head);
        this.tail = intr;
        this.tracker--;
    }

    /**
     * Delete a node from the circular list
     * @param node
     */
    @Override
    public void Delete(DNode node) {
        if (this.head == null) {
            return;
        }
        if (this.head.getData() == node.getData()) {
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
            this.tracker--;
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }
        DNode nodePrevious = this.head;
        while (nodePrevious.getNext() != this.head && nodePrevious.getNext().getData() != node.getData()) {
            nodePrevious = nodePrevious.getNext();
        }
        if (nodePrevious.getNext() != this.head) {
            nodePrevious.setNext(nodePrevious.getNext().getNext());
            this.tracker--;
            if (nodePrevious.getNext() == this.head) {
                this.tail = nodePrevious;
            }
        }
        if (nodePrevious.getNext() == this.head && nodePrevious == this.tail) { // If the node to be deleted is the tail node
            this.tail = nodePrevious.getPrevious();
            this.tail.setNext(this.head);
            this.tracker--;
        }
    }


    /**
     * Checks if the CSLL is sorted in ascending order.
     *
     * @return true if the CSLL is sorted in ascending order, false otherwise
     */
    @Override
    public boolean isSorted() {
        if (head == null) {
            return true;
        }
        DNode current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }


    /**
     * Prints the length, sorted status, and content of the list.
     */
    @Override
    public void Print() {
        System.out.println("List length: " + size);

        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }

        System.out.print("List content: ");

        if (head == null) {
            System.out.println("empty");
        } else {
            DNode current = head;
            System.out.print(current.getData());
            current = current.getNext();
            while (current != null && current != head) {
                System.out.print(" -> " + current.getData());
                current = current.getNext();
            }
            System.out.println();
        }
    }

    /**
     * Clears the list by setting the head, tail, and size to null or 0.
     */
    @Override
    public void Clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }
}