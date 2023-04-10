package myLib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode next;
    private DNode previous;
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public DNode getPrevious() {
        return previous;
    }
    public void setPrevious(DNode previous) {
        this.previous = previous;
    }
    public DNode getNext() {
        return next;
    }
    public void setNext(DNode next) {
        this.next = next;
    }
    public String toString(){
        return Integer.valueOf(this.data).toString();
    }
}