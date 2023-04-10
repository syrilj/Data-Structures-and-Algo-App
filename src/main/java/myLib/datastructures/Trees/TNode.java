package myLib.datastructures.Trees;



public class TNode {
    public int data;
    protected TNode left;
    protected TNode right;
    private TNode parent;
    private int balance;
    protected int height;


    public TNode(int data) {
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
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return this.right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void print() {
        System.out.println("Data: " + this.data + " Balance: " + this.balance);
    }

    public String toString() {
        return Integer.toString(this.data);
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
