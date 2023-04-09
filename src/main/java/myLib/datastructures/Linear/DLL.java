package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int count;

    public DLL() {
        head = null;
        tail = null;
        count = 0;
    }

    public DLL(DNode head) {
        this.head = head;
        tail = null;
        count = 1;
        DNode present = head;
        while (present.getNext() != null) {
            present = present.getNext();
            count++;
        }
        tail = present;
    }

    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        count++;
    }


    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        count++;
    }

    public void Insert(DNode node, int position) {
        if (position < 1 || position > count + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == count + 1) {
            InsertTail(node);
        } else {
            DNode present = head;
            for (int i = 1; i < position - 1; i++) {
                present = present.getNext();
            }
            node.setNext(present.getNext());
            node.setPrevious(present);
            present.getNext().setPrevious(node);
            present.setNext(node);
            count++;
        }
    }

    public void SortedInsert(DNode node) {
        if (head == null) {
            InsertHead(node);
            return;
        }

        if (!isSorted()) {
            Sort();
        }

        DNode present = head;
        DNode prev = null;

        while (present != null && node.getData() > present.getData()) {
            prev = present;
            present = present.getNext();
        }

        if (prev == null) {
            InsertHead(node);
        } else {
            prev.setNext(node);
            node.setPrevious(prev);
            node.setNext(present);
            if (present != null) {
                present.setPrevious(node);
            } else {
                tail = node;
            }
        }
    }

    public DNode Search(DNode node) {
        DNode present = head;
        while (present != null) {
            if (present.getData() == node.getData()) {
                return present;
            }
            present = present.getNext();
        }
        return null;
    }

    public void DeleteHead() {
        if (head == null) {
            return;
        }
        head.getNext().setPrevious(null);
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        count--;
    }

    public void DeleteTail() {
        if (head == null) {
            return;
        }
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            DNode present = head;
            while (present.getNext() != tail) {
                present = present.getNext();
            }
            tail = present;
            tail.setNext(null);
        }
        count--;
    }


    public void Delete(DNode node) {
        if (head == null) {
            return; 
        }
        if (head.getData() == node.getData()) {
            head.getNext().setPrevious(null);
            head = head.getNext();
            count--;
            if (head == null) {
                tail = null;
            }
            return;
        }
        DNode present = head.getNext();
        DNode prev = head;

        while (present != null) {
            if (present.getData() == node.getData()) {
                prev.setNext(present.getNext());
                present.getNext().setPrevious(prev);
                count--;
                if (present == tail) {
                    tail = prev;
                }
                return;
            }
            prev = present;
            present = present.getNext();
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        DNode present = head;
        while (present.getNext() != null) {
            if (present.getData() > present.getNext().getData()) {
                return false;
            }
            present = present.getNext();
        }
        return true;
    }

    public void Sort() {
        if (head == null || head.getNext() == null) {
            return; // list is empty or has only one element, nothing to sort
        }
        DNode present = head;
        head = null;
        count = 0;

        while (present != null) {
            DNode next = present.getNext();
            present.setNext(null);
            SortedInsert(present);
            present = next;
        }
    }

    public void Clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void Print() {
        int length = 0;
        boolean isSorted = isSorted();
        DNode present = head;

        while (present != null) {
            length++;
            present = present.getNext();
        }

        System.out.println("List length: " + length);
        System.out.println("Sort status: " + (isSorted ? "Sorted" : "Unsorted"));

        present = head;

        if (present == null) {
            System.out.println("Empty List");
        } else {
            System.out.println("List content:");
            System.out.println("---------------------------------");
            System.out.printf("| %-5s | %-10s |\n", "Index", "Data");
            System.out.println("---------------------------------");
            int i = 1;
            while (present != null) {
                System.out.printf("| %-5d | %-10d |\n", i, present.getData());
                present = present.getNext();
                i++;
            }
            System.out.println("---------------------------------");
        }
    }




}