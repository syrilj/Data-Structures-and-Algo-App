package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

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
    /**
     * Constructs a CDLL with a specified head node and initializes the tail node and tracker accordingly.
     *
     * @param head the head node of the CDLL
     */
    public CDLL(DNode head) {
        this.head = null;
        this.tail = null;
        this.tracker = 0;
        if (head != null) {
            this.SortedInsert(head);
        }
    }

    /**
     * Deletes the head node of the CDLL and updates the tail and tracker accordingly.
     */

    @Override
    public void DeleteHead() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
                if (tail != null && tail.getNext() != head) {
                    tail.setNext(head);
                    head.setPrevious(tail);
                }
            }
            tracker--;
        }
    }

    public boolean IsEmpty() {
        return head == null;
    }

    /**
     * Deletes the tail node of the CDLL and updates the head and tracker accordingly.
     */
    @Override
    public void DeleteTail() {
        if (IsEmpty()) {
            return;
        }
        if (tail.getPrevious() == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        tracker--;
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrevious(tail);
        }
    }

    /**
     * Deletes a specified node from the CDLL and updates the tracker accordingly.
     *
     * @param node the node to delete from the CDLL
     */
@Override
public void Delete(DNode node) {
    DNode nodeToDelete = this.Search(node);
    if (nodeToDelete == null) {
        return;
    }
    if (head == null) {
        return;
    } else if (head == tail) {
        if (head == node) {
            head = tail = null;
            tracker--;
        }
    } else {
        DNode current = head;
        while (current.getNext() != head && current.getNext() != nodeToDelete) {
            current = current.getNext();
        }
        if (current.getNext() == nodeToDelete) {
            current.setNext(nodeToDelete.getNext());
            nodeToDelete.getNext().setPrevious(current);
            if (nodeToDelete == head) {
                head = nodeToDelete.getNext();
            }
            if (nodeToDelete == tail) {
                tail = nodeToDelete.getPrevious();
            }
            nodeToDelete.setNext(null);
            nodeToDelete.setPrevious(null);
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
    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            node.setNext(head);
            head.setPrevious(node);
            node.setPrevious(tail);
            tail.setNext(node);
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
            node.setPrevious(tail);
            node.setNext(head);
            head.setPrevious(node);
            tail = node;
        }
        tracker++;
    }

    /**
     * insert with node and positon
     * @param node     the node to be inserted
     * @param position the position at which to insert the node (1-based)
     */

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
            DNode nextNode = current.getNext();
            if (nextNode == node) {
                // node with same object reference already exists, do nothing
                return;
            }
            node.setNext(nextNode);
            nextNode.setPrevious(node);
            node.setPrevious(current);
            current.setNext(node);
            tracker++;
        }
    }

    /**
     * sorts it when perfoming the insert
     * @param node the node to be inserted
     */
    @Override
    public void SortedInsert(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            head.setNext(head);
        } else {
            DNode current = head;
            while (current.getNext() != head && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);
            if (current == tail) {
                tail = node;
            }
            Sort(); // Sort the list again after inserting the new node
        }
        tracker++;
        Sort();
    }






    /**
     * searches for the node needed
     * @param node the node to search for
     * @return
     */
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

    /**
     * useful helper boolean to see if its true or not for sort status
     * @return
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
     * keeps track of the size so we don't get infinite loops for some methods
     * @return
     */
    private int GetSize() {
        return this.tracker;
    }

    /**
     * keeps track of size and sorts it using conditional checks, so we don't get endless loops
     */
    @Override
    public void Sort() {
        if (head == null || head.getNext() == null) {
            return;
        }

        int size = GetSize();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            DNode current = head;
            for (int i = 0; i < size - 1; i++) {
                if (current.getData() > current.getNext().getData()) {
                    DNode temp = current.getNext();
                    current.setNext(temp.getNext());
                    temp.getNext().setPrevious(current);
                    temp.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(temp);
                    current.setPrevious(temp);
                    temp.setNext(current);
                    if (current == head) {
                        head = temp;
                    }
                    if (temp.getNext() == head) {
                        tail = temp;
                    }
                    isSorted = false;
                } else {
                    current = current.getNext();
                }
            }
        }
    }



    /**
     * prints in readable format
     */
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


    /**
     * clears the whole thing
     */

    @Override
    public void Clear(){
        head = null;
        tail = null;
        tracker = 0;
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

    public int getTracker() {
        return tracker;
    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }
}


