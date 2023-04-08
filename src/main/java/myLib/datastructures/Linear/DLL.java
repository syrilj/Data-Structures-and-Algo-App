package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public DLL(DNode head) {
        this.head = head;
        tail = null;
        size = 1;
        DNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
            size++;
        }
        tail = current;
    }

    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            DNode temp = head.getNext();
            node.setNext(head);
            node.getNext().setPrevious(node);
            head = node;
        }
        size++;
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
        size++;
    }

    public void Insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == size + 1) {
            InsertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);
            size++;
        }
    }

    public void SortedInsert(DNode node) {
        if (head == null) {
            InsertHead(node);
            tail = head;
        } else {
            if (!isSorted()) {
                Sort();
            }
            boolean inserted = false;
            DNode current = head;
            DNode prev = null;

            while (current != null && !inserted) {
                if (node.getData() <= current.getData()) {
                    if (prev == null) {
                        InsertHead(node);
                    } else {
                        prev.setNext(node);
                        node.setPrevious(prev);
                        node.setNext(current);
                        current.setPrevious(node);
                    }
                    inserted = true;
                } else {
                    prev = current;
                    current = current.getNext();
                }
            }
            if (!inserted) {
                InsertTail(node);
            }
        }
    }

    public DNode Search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
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
        size--;
    }

    public void DeleteTail() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            DNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(null);
        }
        size--;
    }

    public void Delete(DNode node) {
        if (head == null) {
            return; // list is empty, nothing to delete
        }
        if (head.getData() == node.getData()) {
            head.getNext().setPrevious(null);
            head = head.getNext();
            size--;
            if (head == null) {
                tail = null;
            }
            return;
        }
        DNode current = head.getNext();
        DNode prev = head;

        while (current != null) {
            if (current.getData() == node.getData()) {
                prev.setNext(current.getNext());
                current.getNext().setPrevious(prev);
                size--;
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            // empty or single-node list is considered sorted
            return true;
        }

        DNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                // found unsorted pair
                return false;
            }
            current = current.getNext();
        }

        // entire list is sorted
        return true;
    }

    public void Sort() {
        if (head == null || head.getNext() == null) {
            return; // list is empty or has only one element, nothing to sort
        }
        DNode current = head;
        head = null;
        size = 0;

        while (current != null) {
            DNode next = current.getNext();
            current.setNext(null);
            SortedInsert(current);
            current = next;
        }
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Print() {
        int length = 0;
        boolean isSorted = isSorted();
        DNode current = head;

        while (current != null) {
            length++;
            current = current.getNext();
        }

        System.out.println("List length: " + length);
        System.out.println("Sort status: " + (isSorted ? "Sorted" : "Unsorted"));

        current = head;

        if (current == null) {
            System.out.println("Empty List");
        } else {
            System.out.println("List content:");
            System.out.println("---------------------------------");
            System.out.printf("| %-5s | %-10s |\n", "Index", "Data");
            System.out.println("---------------------------------");
            int i = 1;
            while (current != null) {
                System.out.printf("| %-5d | %-10d |\n", i, current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("---------------------------------");
        }
    }




}