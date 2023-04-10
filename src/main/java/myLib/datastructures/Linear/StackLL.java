package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;
/**
 The StackLL class represents a stack data structure that is implemented using a linked list.
 It extends the SLL class and provides additional methods for pushing, popping, and peeking elements
 from the top of the stack, as well as seeking a specific element in the stack and checking if the
 stack is empty.
 */
public class StackLL extends SLL {
    /**
     * Constructs an empty stack.
     */
    public StackLL() {
        super();
    }
    /**
     * Constructs a stack with a given node as its top element.
     *
     * @param node the node to be added to the top of the stack
     */
    public StackLL(DNode node) {
        super(node);
    }
    /**
     * Pushes a node onto the top of the stack.
     *
     * @param node the node to be pushed onto the stack
     */
    public void Push(DNode node) {
        super.InsertHead(node);
    }
    /**
     * Removes the top element from the stack.
     */
    public void Pop() {
        super.DeleteHead();
    }
    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     */
    public DNode Peek() {
        return super.getHead();
    }
    /**
     * Seeks a node in the stack and returns its position in the stack.
     *
     * @param node the node to seek in the stack
     * @return the position of the node in the stack, or -1 if the node is not found
     */
    public int Seek(DNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        DNode current = super.getHead();
        int i = 1;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean Empty() {
        return super.isEmpty();
    }

    /**
     Inserts a node at the head of the linked list.
     Overrides the InsertHead method from the parent class SLL.
     @param node the node to be inserted at the head of the linked list.
     */
    @Override
    public void InsertHead(DNode node) {
        // already defined in push()
    }
    /**

     Inserts a node at the tail of the linked list.
     Overrides the InsertTail method from the parent class SLL.
     @param node the node to be inserted at the tail of the linked list.
     */
    @Override
    public void InsertTail(DNode node) {
        // already defined in push()
    }
    /**

     Inserts a node at a specified position in the linked list.
     This method is not used in StackLL.
     @param node the node to be inserted into the linked list.
     @param position the position at which to insert the node.
     */
    @Override
    public void Insert(DNode node, int position) {
        //  not used in StackLL
    }
    /**

     Inserts a node into the linked list in a sorted position.
     This method is not used in StackLL.
     @param node the node to be inserted into the linked list.
     */
    @Override
    public void SortedInsert(DNode node) {
        //  not used in StackLL
    }
    /**
     Searches for a node within the linked list.
     Overrides the Search method from the parent class SLL.
     @param node the node to be searched for.
     @return the found node or null if the node is not found
     */
    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }
    /**

     Deletes the node at the head of the linked list.
     Overrides the DeleteHead method from the parent class SLL.
     This method is equivalent to the pop() method in the Stack implementation.
     */
    @Override
    public void DeleteHead() {
        //  already defined in pop()
    }
    /**

     Deletes the node at the tail of the linked list.
     Overrides the DeleteTail method from the parent class SLL.
     This method is equivalent to the pop() method in the Stack implementation.
     */

    @Override
    public void DeleteTail() {
        //  already defined in Pop()
    }
    /**

     Deletes a specific node from the linked list.
     Overrides the Delete method from the parent class SLL.
     This method is not used in the Stack implementation.
     @param node the node to be deleted
     */
    @Override
    public void Delete(DNode node) {
        //  not used in StackLL
    }
    /**

     Sorts the linked list in ascending order.
     Overrides the Sort method from the parent class SLL.
     This method is not used in the Stack implementation.
     */
    @Override
    public void Sort() {
        //  it's not used in StackLL
    }
    /**

     Clears the linked list.
     Overrides the Clear method from the parent class SLL.
     This method removes all the nodes from the linked list.
     */
    @Override
    public void Clear() {
        super.Clear();
    }
    /**

     Prints the contents of the linked list to the console.
     Overrides the Print method from the parent class SLL.
     This method prints the contents of the linked list in the order they would be popped off the Stack.
     */
    @Override
    public void Print() {
        System.out.println("Stack length: " + super.getLength());
        DNode current = super.getHead();
        if (isEmpty()) {
            System.out.println("Empty Stack");
        } else {
            int i = 1;
            System.out.println("Stack Content...");
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

