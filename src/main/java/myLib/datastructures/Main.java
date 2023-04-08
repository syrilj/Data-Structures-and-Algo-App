package myLib.datastructures;
import java.util.Scanner;
import myLib.datastructures.Linear.StackLL;
import myLib.datastructures.nodes.DNode;
import myLib.datastructures.Linear.*;
import myLib.datastructures.Linear.DLL;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            System.out.println("Select a data structure to test:");
            System.out.println("1. Singly Linked List (SLL)");
            System.out.println("2. Queue using Linked List (QueueLL)");
            System.out.println("3. Stack using Linked List (StackLL)");
            System.out.println("4. Doubly Linked List (DLL)");
            System.out.println("5. Circular Doubly Linked List (CDLL)");
            System.out.println("6. Circular Singly Linked List (CSLL)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Testing Singly Linked List (SLL)");
                    testSLL();
                    break;
                case 2:
                    System.out.println("Testing Queue using Linked List (QueueLL)");
                    testQueueLL();
                    break;
                case 3:
                    System.out.println("Testing Stack using Linked List (StackLL)");
                    testStackLL();
                    break;
                case 4:
                    System.out.println("Testing Doubly Linked List (DLL)");
                    testDLL();
                    break;
                case 5:
                    System.out.println("Testing Circular Doubly Linked List (CDLL)");
                    testCDLL();
                    break;
                case 6:
                    System.out.println("Testing Circular Singly Linked List (CSLL)");
                    testCSLL();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }
        input.close();
    }

    private static void testCSLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running through some functionality testing of CSLL");


        CSLL list18 = new CSLL();

        // Insert nodes
        list18.InsertHead(new DNode(1));
        list18.InsertTail(new DNode(2));
        list18.Insert(new DNode(3), 2);
        list18.SortedInsert(new DNode(4));

        // Print list
        list18.Print(); // Should output: List length: 4, Sorted: Yes, List content: 1 -> 2 -> 3 -> 4

        // Search for a node
        DNode node98 = list18.Search(new DNode(3));
        System.out.println("Node found: " + node98); // Should output: Node found: nodes.myLib.datastructures.DNode@...

        // Delete nodes
        list18.DeleteHead();
        list18.DeleteTail();
        list18.Delete(new DNode(2));

        // Print list
        list18.Print(); // Should output: List length: 1, Sorted: Yes, List content: 1
        // Clear list
        list18.Clear();
        list18.Print(); // Should output: List length: 0, Sorted: Yes, List content: empty
        System.out.println("-------------------------------------------------");
        System.out.println("Finished Running through some functionality testing of CSLL");
    }

    private static void testCDLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running through some functionality testing of CDLL");
        CDLL myList = new CDLL();

        DNode node19 = new DNode(5);
        DNode node29 = new DNode(10);
        DNode node39 = new DNode(15);
        DNode node49 = new DNode(20);

        myList.InsertHead(node19);
        myList.InsertTail(node29);
        myList.Insert(node39, 2);
        myList.SortedInsert(node49);

        System.out.println("List after insertions:");
        myList.Print();

        DNode searchNode = new DNode(15);
        DNode foundNode8 = myList.Search(searchNode);
        System.out.println("Search result: " + foundNode8);

        myList.DeleteHead();
        myList.DeleteTail();
        myList.Delete(node39);

        System.out.println("List after deletions:");
        myList.Print();

        System.out.println("Sorting the list...");
        myList.Sort();

        System.out.println("List after sorting:");
        myList.Print();
        System.out.println("-------------------------------------------------");
        System.out.println("Running through some functionality testing of CDLL");

    }

    private static void testDLL() {

        System.out.println("-------------------------------------------------");
        System.out.println("\nRunning through some functionality testing of DLL");

        // Create a new DLL
        DLL dll = new DLL();
        System.out.println("New DLL created.");

        // Insert nodes at head
        dll.InsertHead(new DNode(3));
        System.out.println("Inserted node with data = 3 at head.");
        dll.InsertHead(new DNode(2));
        System.out.println("Inserted node with data = 2 at head.");
        dll.InsertHead(new DNode(1));
        System.out.println("Inserted node with data = 1 at head.");

        // Insert nodes at tail
        dll.InsertTail(new DNode(4));
        System.out.println("Inserted node with data = 4 at tail.");
        dll.InsertTail(new DNode(5));
        System.out.println("Inserted node with data = 5 at tail.");
        dll.InsertTail(new DNode(6));
        System.out.println("Inserted node with data = 6 at tail.");

        // Insert a node at a specific position
        dll.Insert(new DNode(7), 4);
        System.out.println("Inserted node with data = 7 at position 4.");

        // Search for a node
        DNode node = dll.Search(new DNode(4));
        if (node != null) {
            System.out.println("Search result: Node with data = " + node.getData() + " found.");
        } else {
            System.out.println("Search result: Node with data = 4 not found.");
        }
        // Delete a node
        dll.Delete(new DNode(2));
        System.out.println("Deleted node with data = 2.");

        // Sort the list
        dll.Sort();
        System.out.println("List sorted in ascending order.");
        // Print the list
        dll.Print();
        // Clear the list
        dll.Clear();
        System.out.println("List cleared.");
        System.out.println("-------------------------------------------------");
        System.out.println("\nFinished Running through some functionality testing of DLL");
    }

    private static void testStackLL() {
        System.out.println("Running through some functionality testing of StackLL");
        System.out.println("-------------------------------------------------");

        // Creating a new stack
        StackLL myStack = new StackLL();

        // Testing if the stack is empty
        System.out.println("Is the stack empty? " + myStack.Empty());

        // Pushing some nodes onto the stack
        System.out.println("Pushing some nodes onto the stack...");
        DNode node9 = new DNode(10);
        DNode node8 = new DNode(20);
        DNode node17 = new DNode(30);
        DNode node16 = new DNode(40);
        myStack.Push(node9);
        myStack.Push(node8);
        myStack.Push(node17);
        myStack.Push(node16);

        // Printing the stack contents
        myStack.Print();

        // Popping some nodes off the stack
        System.out.println("Popping some nodes off the stack...");
        myStack.Pop();
        myStack.Pop();

        // Printing the stack contents again
        myStack.Print();

        // Peeking at the top node
        System.out.println("Peeking at the top node: " + myStack.Peek().getData());

        // Searching for a node
        System.out.println("Searching for node with data 20...");
        DNode nodeToSearch1 = new DNode(20);
        int result1 = myStack.Seek(nodeToSearch1);
        if (result1 == -1) {
            System.out.println("Node not found in the stack.");
        } else {
            System.out.println("Node found at position " + result1);
        }
        myStack.Print();



        System.out.println("Searching for node with data 50...");
        DNode nodeToSearch3 = new DNode(50);
        int result2 = myStack.Seek(nodeToSearch3);
        if (result2 == -1) {
            System.out.println("Node not found in the stack.");
        } else {
            System.out.println("Node found at position " + result2);
        }

        // Clearing the stack
        System.out.println("Clearing the stack...");
        myStack.Clear();

        // Testing if the stack is empty again
        System.out.println("Is the stack empty? " + myStack.Empty());
        System.out.println("-------------------------------------------------");
        System.out.println("Finished Running through some functionality testing of StackLL");
    }

    private static void testQueueLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running through some functionality testing of QueueLL");
        System.out.println("-------------------------------------------------");
        // create an empty queue
        QueueLL queue = new QueueLL();

        // check if the queue is empty
        System.out.println("Is the queue empty? " + queue.Empty());

        // enqueue some nodes
        System.out.println("Enqueuing some nodes...");
        queue.Enqueue(new DNode(10));
        queue.Enqueue(new DNode(20));
        queue.Enqueue(new DNode(30));
        queue.Enqueue(new DNode(40));

        // print the queue
        queue.Print();

        // dequeue some nodes
        System.out.println("Dequeuing some nodes...");
        queue.Dequeue();
        queue.Dequeue();

        // print the queue
        queue.Print();

        // peek at the first node
        System.out.println("Peeking at the first node: " + queue.Peek().getData());

        // search for a node
        DNode nodeToSearch = new DNode(20);
        System.out.println("Searching for node " + nodeToSearch.getData() + "...");
        if (queue.Search(nodeToSearch) != null) {
            System.out.println("Node found in the queue.");
        } else {
            System.out.println("Node not found in the queue.");
        }

        // search for a node that doesn't exist
        DNode nodeToSearch2 = new DNode(50);
        System.out.println("Searching for node " + nodeToSearch2.getData() + "...");
        if (queue.Search(nodeToSearch2) != null) {
            System.out.println("Node found in the queue.");
        } else {
            System.out.println("Node not found in the queue.");
        }

        // get the position of a node
        DNode nodeToFindPos = new DNode(30);
        int pos = queue.Seek(nodeToFindPos);
        if (pos != -1) {
            System.out.println("Node found at position " + pos + ".");
        } else {
            System.out.println("Node not found in the queue.");
        }

        // get the position of a node that doesn't exist
        DNode nodeToFindPos2 = new DNode(50);
        int pos2 = queue.Seek(nodeToFindPos2);
        if (pos2 != -1) {
            System.out.println("Node found at position " + pos2 + ".");
        } else {
            System.out.println("Node not found in the queue.");
        }

        // clear the queue
        System.out.println("Clearing the queue...");
        queue.Clear();
        queue.Print();

        System.out.println("-------------------------------------------------");
        System.out.println("Finished running through some functionality testing of QueueLL");
    }

    private static void testSLL() {
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




