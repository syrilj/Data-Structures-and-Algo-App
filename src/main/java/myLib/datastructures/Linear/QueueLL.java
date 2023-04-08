package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;




public class QueueLL extends SLL{

    public QueueLL() {
        super();
    }

    public QueueLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {}

    @Override
    public void InsertTail(DNode node) {}

    @Override
    public void Insert(DNode node, int position) {}

    @Override
    public void SortedInsert(DNode node) {}

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public void DeleteHead() {}

    @Override
    public void DeleteTail() {}

    @Override
    public void Delete(DNode node) {}

    @Override
    public void Sort() {}

    @Override
    public void Clear() {
        while (super.getHead() != null) {
            super.DeleteHead();
        }
    }

    public void Enqueue(DNode node) {
        super.InsertTail(node);
    }

    public void Dequeue() {
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

    public boolean Empty() {
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

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
