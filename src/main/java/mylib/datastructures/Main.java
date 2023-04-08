package mylib.datastructures;

import mylib.datastructures.Linear.StackLL;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.Linear.SLL;
import mylib.datastructures.Linear.DLL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running through some functionality testing of SLL");
        System.out.println("-------------------------------------------------");
        SLL list = new SLL();

        // Insert 10 at the head of the list
        DNode node1 = new DNode(10);
        list.InsertHead(node1);

        // Insert 20 at the tail of the list
        DNode node2 = new DNode(20);
        list.InsertTail(node2);

        // Insert 15 at position 1 in the list
        DNode node3 = new DNode(11);
        list.Insert(node3, 1);

        // Insert 5 at position 0 in the list
        DNode node4 = new DNode(5);
        list.Insert(node4, 0);

        // Insert 25 at position 4 in the list
        DNode node5 = new DNode(25);
        list.Insert(node5, 4);

        // Print the list
        list.Print();

        // Search for node with data = 15
        DNode node6 = new DNode(12);
        DNode foundNode = list.Search(node6);
        if (foundNode != null) {
            System.out.println("Node with data = " + node6.getData() + " found in list.");
        } else {
            System.out.println("Node with data = " + node6.getData() + " not found in list.");
        }

        // Delete the node at the head of the list
        list.DeleteHead();

        // Delete the node at the tail of the list
        list.DeleteTail();

        // Delete the node with data = 15
        DNode node7 = new DNode(11);
        list.Delete(node7);

        // Print the list
        list.Print();
        System.out.println("-------------------------------------------------");
        System.out.println("Finished running through some functionality testing of SLL");

    }




}
