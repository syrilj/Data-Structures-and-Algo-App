package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }

    public StackLL(DNode node) {
        super(node);
    }

    public void Push(DNode node) {
        super.InsertHead(node);
    }

    public void Pop() {
        super.DeleteHead();
    }

    public DNode Peek() {
        return super.getHead();
    }

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

    @Override
    public void InsertHead(DNode node) {
        // Not needed since it's already defined in push()
    }

    @Override
    public void InsertTail(DNode node) {
        // Not needed since it's already defined in Push()
    }

    @Override
    public void Insert(DNode node, int position) {
        // Not needed since it's not used in StackLL
    }

    @Override
    public void SortedInsert(DNode node) {
        // Not needed since it's not used in StackLL
    }

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public void DeleteHead() {
        // Not needed since it's already defined in pop()
    }

    @Override
    public void DeleteTail() {
        // Not needed since it's already defined in Pop()
    }

    @Override
    public void Delete(DNode node) {
        // Not needed since it's not used in StackLL
    }

    @Override
    public void Sort() {
        // Not needed since it's not used in StackLL
    }

    @Override
    public void Clear() {
        super.Clear();
    }






    public boolean Empty() {
        return super.isEmpty();
    }

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

