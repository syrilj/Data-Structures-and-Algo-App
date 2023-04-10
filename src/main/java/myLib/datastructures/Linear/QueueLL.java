package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;




public class QueueLL extends SLL{
    /**
     * Constructs an empty queue.
     */
    public QueueLL() {
        super();
    }
    /**
     * Constructs a queue with a given node as its head.
     *
     * @param node the node to be set as the head of the queue.
     */
    public QueueLL(DNode node) {
        super(node);
    }
    /**
     * Adds a new node to the tail of the queue.
     *
     * @param node the node to be added.
     */
    public void Enqueue(DNode node) {
        super.InsertTail(node);
    }
    /**
     * Removes the node at the head of the queue.
     */
    public void Dequeue() {
        super.DeleteHead();
    }
    /**
     * Returns the node at the head of the queue without removing it.
     *
     * @return the node at the head of the queue.
     */
    public DNode Peek() {
        return super.getHead();
    }
    /**
     * Searches for a given node in the queue and returns its position.
     *
     * @param node the node to be searched for.
     * @return the position of the node in the queue, or -1 if the node is not found.
     */
    public int Seek(DNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        DNode current = super.getHead();
        int i = 1;
        while (current != null) {
            if (current == node) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean Empty() {
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Overrides the InsertHead method from the parent class SLL and sets it to do nothing.
     */
    @Override
    public void InsertHead(DNode node) {}
    /**
     * Overrides the InsertTail method from the parent class SLL and sets it to do nothing.
     */
    @Override
    public void InsertTail(DNode node) {}
    /**
     * Overrides the Insert method from the parent class SLL and sets it to do nothing.
     */
    @Override
    public void Insert(DNode node, int position) {}
    /**
     * Overrides the SortedInsert method from the parent class SLL and sets it to do nothing.
     */
    @Override
    public void SortedInsert(DNode node) {}
    /**
     * Searches for a given node in the queue and returns it if it is found.
     * Overrides the Search method from the parent class SLL.
     *
     * @param node the node to be searched for.
     * @return the found node, or null if the node is not found.
     */
    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }
    /**
     * Deletes the head element of the queue.
     */
    @Override
    public void DeleteHead() {}
    /**
     * Deletes the tail element of the queue.
     */
    @Override
    public void DeleteTail() {}
    /**
     * Deletes the specified node from the queue.
     *
     * @param node the node to be deleted
     */
    @Override
    public void Delete(DNode node) {}
    /**
     * Sorts the elements of the queue.
     */
    @Override
    public void Sort() {}
    /**
     * Removes all elements from the queue.
     */
    @Override
    public void Clear() {
        while (super.getHead() != null) {
            super.DeleteHead();
        }
    }
    /**
     * Prints the contents of the queue to the console.
     * The output includes the index and data of each element.
     */
    @Override
    public void Print() {
        System.out.println("Queue length: " + super.getLength());
        DNode current = super.getHead();
        if (Empty() == true) {
            System.out.println("Empty Queue");
        } else {
            int i = 1;
            System.out.println("Queue Content...");
            System.out.println("------------------------------");
            while (current != null) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("------------------------------");
        }
    }
}
