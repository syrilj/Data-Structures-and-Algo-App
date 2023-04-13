package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

import java.util.HashSet;

/**

 This class represents a circular doubly linked list (CDLL) that extends a doubly linked list (DLL).
 The CDLL contains two sentinel nodes, head and tail, and a counter tracker to keep track of the size of the list.
 */
public class CDLL extends DLL{
    private DNode head;
    private DNode tail;
    private int tracker;

    /**
     * Constructs an empty CDLL with null head and tail sentinel nodes and a tracker of 0.
     */
    public CDLL(){
        head = null;
        tail = null;
        tracker = 0;
    }
    /**
     * Constructs a CDLL with a specified head node and initializes the tail node and tracker accordingly.
     *
     * @param head the head node of the CDLL
     */
    public CDLL(DNode head){
        this.head = head;
        tail = null;
        int tracker = 1;
        DNode current = head;
        if(current.getNext() != null) {
            while (current.getNext().getData() != head.getData()) {
                current = current.getNext();
                tracker++;
            }
        }
        current.setNext(this.head);
        this.head.setPrevious(current);
        tail = current;
    }


    /**
     * Deletes the head node of the CDLL and updates the tail and tracker accordingly.
     */
    @Override
    public void DeleteHead(){
        if(head == null){
            return;
        }else{
            head.getNext().setPrevious(tail);
            head = head.getNext();
            tail.setNext(head);
            tracker--;
        }
    }
    /**
     * Deletes the tail node of the CDLL and updates the head and tracker accordingly.
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
            head.setPrevious(tail);
            tracker--;
        }
    }
    /**
     * Deletes a specified node from the CDLL and updates the tracker accordingly.
     *
     * @param node the node to delete from the CDLL
     */
    @Override
    public void Delete(DNode node){
        if(head == null){
            return;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getNext().getData() != node.getData()){
                current = current.getNext();
            }
            if(current.getNext().getData() == node.getData()){
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);
                tracker--;
            }
        }
    }


    /**
     * Inserts a node at the head of the CDLL and updates the tail and tracker accordingly.
     *
     * @param node the node to insert at the head of the CDLL
     */
    @Override
    public void InsertHead(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
            head.setPrevious(head);
        }else{
            node.setNext(head);
            tail.setNext(node);
            node.setPrevious(tail);
            head = node;
        }
        tracker++;
    }
    /**
     * Inserts a node at the tail of the CDLL and updates the tracker accordingly.
     */
    @Override
    public void InsertTail(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            tail.setNext(node);
            node.setPrevious(tail);  // fix here
            node.setNext(head);
            head.setPrevious(node);
            tail = node;
        }
        tracker++;
    }


    @Override
    public void Insert(DNode node, int position) {
        if (position < 1 || position > tracker + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == tracker + 1) {
            InsertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            if (current.getNext().getData() == node.getData()) {
                // node with same value already exists, do nothing
                return;
            }
            node.setNext(current.getNext());
            current.getNext().setPrevious(node);
            node.setPrevious(current);
            current.setNext(node);
            tracker++;
        }
    }


    @Override
    public void SortedInsert(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            if(!isSorted()){
                Sort();
            }
            DNode current = head;
            while(current.getNext() != head && current.getNext().getData() < node.getData()){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);
            if(current == tail){
                tail = node;
            }
        }
        tracker++;
    }

    @Override
    public DNode Search(DNode node){
        if(head == null){
            return null;
        } else {
            DNode current = head;
            do {
                if(current.getData() == node.getData()){
                    return current;
                }
                current = current.getNext();
            } while(current != head);
            return null;
        }
    }


    @Override
    public boolean isSorted(){
        if(head == null){
            return true;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getData() <= current.getNext().getData()){
                current = current.getNext();
            }
            if(current.getNext() == head){
                return true;
            }else{
                return false;
            }
        }
    }

//    @Override
//    public DNode getTail() {
//        return this.tail;
//    }
//    @Override
//    public DNode getHead() {
//        return this.head;
//    }


    @Override
    public void Sort() {
        if (head == null) {
            return;
        } else {
            DNode current = head;
            DNode next = null;
            int temp;
            while (current.getNext() != head) {
                next = current.getNext();
                while (next != head) {
                    if (current.getData() > next.getData()) {
                        temp = current.getData();
                        current.setData(next.getData());
                        next.setData(temp);
                    }
                    next = next.getNext();
                }
                current = current.getNext();
            }
        }
    }
















    @Override
    public void Print() {
        System.out.println("List length: " + tracker);

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
                if (current == tail) {
                    System.out.print(" -> " + current.getData());
                    break;
                }
                System.out.print(" -> " + current.getData());
                current = current.getNext();
            }
            System.out.println();
        }
    }






    @Override
    public void Clear(){
        head = null;
        tail = null;
        tracker = 0;
    }
}



