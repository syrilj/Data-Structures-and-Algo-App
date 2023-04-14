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
        head = null;
        size = 0;
        tail = null;
    }

    /**
     * Constructs a CSLL with a given head node.
     *
     * @param head the head node of the CSLL
     */
    public CSLL(DNode head){
        this.head = head;
        tail = null;
        size = 1;
        DNode current = head;
        if(current.getNext() != null) {
            while (current.getNext().getData() != head.getData()) {
                current = current.getNext();
                size++;
            }
        }
        current.setNext(this.head);
        tail = current;
    }

    /**
     * Sorts the CSLL in ascending order.
     * Overrides the Sort() method of SLL.
     */
    @Override
    public void Sort(){
        if(head == null || head == tail){
            return;
        }else{
            boolean swapped = true;
            while(swapped){
                swapped = false;
                DNode current = head;
                while(current.getNext() != head){
                    if(current.getData() > current.getNext().getData()){
                        int temp = current.getData();
                        current.setData(current.getNext().getData());
                        current.getNext().setData(temp);
                        swapped = true;
                    }
                    current = current.getNext();
                }
            }
        }
    }
    /**
     * Inserts a node at the head of the CSLL.
     * Overrides the InsertHead() method of SLL.
     *
     * @param node the node to insert at the head of the CSLL
     */
    @Override
    public void InsertHead(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            node.setNext(head);
            tail.setNext(node);
            head = node;
        }
        size++;
    }
    /**
     * Inserts a node at the tail of the CSLL.
     * Overrides the InsertTail() method of SLL.
     *
     * @param node the node to insert at the tail of the CSLL
     */
    @Override
    public void InsertTail(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }
        size++;
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
        if(position < 1 || position > size + 1){
            throw new IndexOutOfBoundsException();
        }
        if(position == 1){
            InsertHead(node);
        }else if(position == size + 1){
            InsertTail(node);
        }else{
            DNode current = head;
            for(int i = 1; i < position - 1; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    /**
     * Inserts a node into the sorted circular linked list in sorted order.
     * If the list is empty, sets the head and tail to the new node.
     *
     * @param node the node to be inserted into the list
     */
    @Override
    public void SortedInsert(DNode node) {
        if (head == null|| size ==0 ) {
            head = node;
            tail = node;
            node.setNext(node);
            size = 1;
        } else {
            DNode present = head;
            DNode previous = tail;
            while(present != head && node.getData() > present.getData()){
                previous = present;
                present = present.getNext();
            }

            if (present == tail && node.getData() < present.getData()) {
                InsertHead(node);
            }
            else{
                node.setNext(present);
                previous.setNext(node);
                if(present == head){
                    tail = node;
                }
                size++;
                Sort();
            }
        }
    }
    /**
     * Searches for a node with the same data as the given node in the list.
     *
     * @param node the node to be searched for in the list
     * @return the node with the same data as the given node, or null if not found
     */
    @Override
    public DNode Search(DNode node){
        if(head == null){
            return null;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getData() != node.getData()){
                current = current.getNext();
            }
            if(current.getData() == node.getData()){
                return current;
            }else{
                return null;
            }
        }
    }

    /**
     * Deletes the head node of the list.
     */
    @Override
    public void DeleteHead(){
        if(head == null){
            return;
        }else{
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
    }
    /**
     * Deletes the tail node of the list.
     */
    @Override
    public void DeleteTail(){
        if(head == null){
            return;
        }else{
            DNode current = head;
            while(current.getNext() != tail){
                current = current.getNext();
            }
            current.setNext(head);
            tail = current;
            size--;
        }
    }

    /**
     * Deletes the node with the same data as the given node from the list.
     *
     * @param node the node to be deleted from the list
     */
    @Override
    public void Delete(DNode node){
        DNode nodeToDelete = this.Search(node);
        if (nodeToDelete == null) {
            return;
        }
        if(head == null){
            return;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getNext().getData() != node.getData()){
                current = current.getNext();
            }
            if(current.getNext().getData() == node.getData()){
                current.setNext(current.getNext().getNext());
                size--;
            }
        }
    }
    /**
     * Checks if the CSLL is sorted in ascending order.
     *
     * @return true if the CSLL is sorted in ascending order, false otherwise
     */
    @Override
    public boolean IsSorted() {
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

        if (IsSorted()) {
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
    @Override
    public DNode getHead() {
        return head;
    }
    public void setHead(DNode head) {
        this.head = head;
    }

    @Override
    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }
    public int getSize(){
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}