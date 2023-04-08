package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;
/**

 This class implements a singly linked list that can be used to store integer values.

 The list can be traversed from the head to the tail using the next pointers of each node.

 The list keeps track of its length through a tracker variable.

 The class provides methods to check if the list is empty, get the head and tail nodes,

 get the length of the list, and set the length of the list by deleting or inserting nodes

 at the tail.
 */
public class SLL {
    protected DNode head; // the first node of the list
    protected DNode tail; // the last node of the list
    protected int tracker; // the number of nodes in the list

    /**

     Creates a new empty singly linked list.
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.tracker = 0;
    }
    /**

     Checks if the list is empty.
     @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**

     Gets the head node of the list.
     @return the head node of the list
     */
    public DNode getHead() {
        return this.head;
    }
    /**

     Gets the tail node of the list.
     @return the tail node of the list
     */
    public DNode getTail() {
        return this.tail;
    }
    /**
     Gets the number of nodes in the list.
     @return the number of nodes in the list
     */
    public int getLength() {
        int count = 0;
        DNode current = this.head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    /**

     Sets the number of nodes in the list by deleting or inserting nodes at the tail.

     If the new length is less than the current length, nodes are deleted from the tail.

     If the new length is greater than the current length, new nodes are inserted at the tail.

     @param length the new length of the list
     */
    public void setLength(int length) {
        int currentLength = this.getLength();

        if (length < currentLength) {
            for (int i = 0; i < currentLength - length; i++) {
                this.DeleteTail();
            }
        } else if (length > currentLength) {
            for (int i = 0; i < length - currentLength; i++) {
                this.InsertTail(new DNode(length));
            }
        }
    }


    /**
     * constructor
     * @param node
     */
    public SLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.tracker = 1;
    }

    /**
     * InsertHead for the list
     * @param node
     */
    public void InsertHead(DNode node) {
        // If the list is empty
        if (this.tracker == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.tracker++;
    }

    /**
     * InsertTail for the list
     * @param node
     */
    public void InsertTail(DNode node) {
        if (this.tracker == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.tracker++;
    }

    /**
     * Insert functionality for the list
     * @param node
     * @param position
     * @throws IndexOutOfBoundsException
     */
    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > this.tracker) {
            throw new IndexOutOfBoundsException();
        }
        if (this.tracker == 0) {
            this.head = node;
            this.tail = node;
            this.tracker++;
            return;
        } else if (position == 0) {
            node.setNext(this.head);
            this.head = node;
            this.tracker++;
            return;
        } else if (position == this.tracker) {
            this.tail.setNext(node);
            this.tail = node;
            this.tracker++;
            return;
        }
        DNode currentNode = this.head;
        int i = 0;
        while (i < position - 1) {
            currentNode = currentNode.getNext();
            i++;
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        this.tracker++;
    }

    /**
     * Sort before doing the insertion
     * @param node
     */
    public void SortedInsert(DNode node) {
        this.Sort();
        if (this.head == null || node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head = node;
            if (this.tail == null) {
                this.tail = node;
            }
        } else {
            DNode temp = this.head;
            while (temp.getNext() != this.tail.getNext() && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            if (node.getNext() == null) {
                this.tail = node;
            }
        }
        this.tracker++;
    }

    /**
     * helper function to check if its is sorted
     * @return
     */
    protected boolean isSorted(){
        if (this.head == null || this.head.getNext() == null){
            return true;
        }
        DNode current = this.head;
        while(current.getNext() != null){
            if (current.getData() > current.getNext().getData()){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /**
     * searches the list
     * @param node
     * @return
     */
    public DNode Search(DNode node) {
        DNode current = this.head;
        for (int i = 0; i < this.tracker; i++) {
            if (node.getData() == current.getData()) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Delete head of the list
     */
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
            this.tracker--;
        }
    }

    /**
     * deletes the tail of the list
     */
    public void DeleteTail() {
        if (this.head == null) {
            return;
        }
        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
            this.tracker = 0;
            return;
        }
        DNode temp = this.head;
        while (temp.getNext() != this.tail) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        this.tail = temp;
        this.tracker--;
    }


    /**
     * delete functionality
     * @param node
     */
    public void Delete(DNode node) {
        if (this.head.getData() == node.getData()) {
            this.head = this.head.getNext();
            this.tracker--;
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }
        if (this.tail.getData() == node.getData()) {
            DNode temp = this.head;
            for (int i = 0; i < this.tracker - 2; i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            this.tail = temp;
            this.tracker--;
            return;
        }
        DNode prevNode = this.head;
        for (int i = 0; i < this.tracker - 1; i++) {
            DNode current = prevNode.getNext();
            if (current.getData() == node.getData()) {
                prevNode.setNext(current.getNext());
                this.tracker--;
                return;
            }
            prevNode = prevNode.getNext();
        }
    }

    /**
     * sort helpful for other methods as well
     */
    public void Sort() {
        if (this.head == null || this.head.getNext() == null || this.isSorted()) {
            return;
        }
        DNode current = this.head.getNext();
        DNode prev = this.head;
        while (current != this.tail.getNext()) {
            System.out.println(current.getData());
            if (current.getData() < prev.getData()) {
                prev.setNext(current.getNext());
                if (current.getData() < this.head.getData()) {
                    current.setNext(this.head);
                    this.head = current;
                } else {
                    DNode temp = this.head;
                    while (temp.getNext() != this.tail.getNext() && temp.getNext().getData() <= current.getData()) {
                        temp = temp.getNext();
                    }
                    current.setNext(temp.getNext());
                    temp.setNext(current);
                }
                if (prev.getNext() == null) {
                    this.tail = prev;
                }
                current = prev.getNext();
            } else {
                prev = current;
                current = current.getNext();
            }
        }
    }

    /**
     * clears the whole list
     */
    public void Clear() {
        this.head = null;
        this.tail = null;
        this.tracker = 0;
    }

    /**
     * prints the data in a clear understandable format
     */
    public void Print() {
        System.out.println("List length: " + this.getLength());
        System.out.println("Sort status: " + (isSorted() ? "Sorted" : "Unsorted"));

        DNode current = this.head;
        if (current == null) {
            System.out.println("Empty List");
        } else {
            System.out.println("List content:");
            System.out.println("---------------------------------");
            System.out.printf("| %-5s | %-10s |\n", "Index", "Data");
            System.out.println("---------------------------------");
            int i = 1;
            while (current != null) {
                System.out.printf("| %-5d | %-10d |\n", i, current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("---------------------------------");
        }
    }
}