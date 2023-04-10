package myLib.datastructures.nodes;

/**

This class represents a node in a tree data structure.
*/

public class TNode {
    
    public int data;       // The data stored in this node.
    protected TNode left;   //  The left child of this node.
    protected TNode right;  //  The right child of this node.
    private TNode parent;   //  The parent of this node.
    private int balance;    //  The balance factor of this node.
    protected int height;   //  The height of this node.


    public TNode(int data) {
        /**
         * Creates a new node with the specified data.
         * 
         * @param data the data to be stored in the node
         */
        this.balance = 0;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        /**
         * Creates a new node with the specified data, balance factor, parent, left child, and right child.
         * 
         * @param data    the data to be stored in the node
         * @param balance the balance factor of the node
         * @param parent  the parent of the node
         * @param left    the left child of the node
         * @param right   the right child of the node
         */
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return this.data;  // Returns the data stored in the node
    }

    public void setData(int data) {
        this.data = data;   // Sets the data stored in the node
    }

    public TNode getLeft() {
        return this.left;   // Returns the left child of the node
    }

    public void setLeft(TNode left) {
        this.left = left;   // Sets the left child of the node
    }

    public TNode getRight() {
        return this.right;   // Returns the right child of the node
    }

    public void setRight(TNode right) {
        this.right = right;     // Sets the right child of the node
    }

    public TNode getParent() {
        return this.parent;     // Returns the parent of the node
    }

    public void setParent(TNode parent) {
        this.parent = parent;   // Sets the parent of the node
    }

    public int getBalance() {
        return this.balance;        // Returns the parent of the node
    }

    public void setBalance(int balance) {
        this.balance = balance;     // Sets the balance of the node
    }

    public void print() {
        System.out.println("Data: " + this.data + " Balance: " + this.balance);     // Prints the data and balance factor 
    }

    public String toString() {
        return Integer.toString(this.data); // Returns the data stored in the node as a string.
    }

    public void setHeight(int height) {
        this.height = height;       // Sets the height 
    }
}
