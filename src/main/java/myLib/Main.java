package myLib;
import java.util.Scanner;
import myLib.datastructures.Linear.StackLL;
import myLib.datastructures.nodes.DNode;
import myLib.datastructures.nodes.TNode;
import myLib.datastructures.Linear.*;
import myLib.datastructures.Linear.DLL;
import myLib.datastructures.Trees.*;
import myLib.datastructures.Heap.*;
import myLib.datastructures.Graph.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("Select an option:");
            System.out.println("1. Run all tests");
            System.out.println("2. Test Singly Linked List (SLL)");
            System.out.println("3. Test Queue using Linked List (QueueLL)");
            System.out.println("4. Test Stack using Linked List (StackLL)");
            System.out.println("5. Test Doubly Linked List (DLL)");
            System.out.println("6. Test Circular Doubly Linked List (CDLL)");
            System.out.println("7. Test Circular Singly Linked List (CSLL)");
            System.out.println("8. Test Binary Search Tree (BST)");
            System.out.println("9. Test AVL Tree (AVL)");
            System.out.println("10. Test Max ra (MaxH)");
            System.out.println("11. Test Min Heap (MinH)");
            System.out.println("12. Test Graph Structures");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Running all tests...");
                    runAllTests();
                    break;
                case 2:
                    System.out.println("Testing Singly Linked List (SLL)");
                    testSLL();
                    break;
                case 3:
                    System.out.println("Testing Queue using Linked List (QueueLL)");
                    testQueueLL();
                    break;
                case 4:
                    System.out.println("Testing Stack using Linked List (StackLL)");
                    testStackLL();
                    break;
                case 5:
                    System.out.println("Testing Doubly Linked List (DLL)");
                    testDLL();
                    break;
                case 6:
                    System.out.println("Testing Circular Doubly Linked List (CDLL)");
                    testCDLL();
                    break;
                case 7:
                    System.out.println("Testing Circular Singly Linked List (CSLL)");
                    testCSLL();
                    break;
                case 8:
                    System.out.println("Testing Binary Search Tree(BST)");
                    testBST();
                    break;
                case 9:
                    System.out.println("Testing AVL Tree(AVL)");
                    testAVL();
                    break;
                case 10:
                    System.out.println("Testing Max Heap (MaxH)");
                    testMaxH();
                    break;
                case 11:
                    System.out.println("Testing Min Heap (MinH)");
                    testMinH();
                    break;

                case 12:
                    System.out.println("Testing Graph Structures");
                    testGraph();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        input.close();
    }

    public static void runAllTests() {
        testSLL();
        testQueueLL();
        testStackLL();
        testDLL();
        testCDLL();
        testCSLL();
        testBST();
        testAVL();
        testMaxH();
        testMinH();
    }

    private static void testCSLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running functionality testing of CSLL");
        CSLL list = new CSLL();

        // Insert nodes at the head and tail of the list
        list.InsertHead(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));

        // Print the list
        list.Print(); // List length: 3 Sorted: Yes List content: 1 -> 2 -> 3

        // Insert a node at a specific position
        list.Insert(new DNode(4), 2);

        // Print the list
        list.Print(); // List length: 4 Sorted: Yes List content: 1 -> 4 -> 2 -> 3

        // Insert a node in sorted order
        list.SortedInsert(new DNode(0));

        // Print the list
        list.Print(); // List length: 5 Sorted: Yes List content: 0 -> 1 -> 2 -> 3 -> 4

        // Search for a node
        DNode node = list.Search(new DNode(2));
        System.out.println("Found node: " + node.getData()); // Found node: 2

        // Delete nodes from the head and tail of the list
        list.DeleteHead();
        list.DeleteTail();

        // Print the list
        list.Print(); // List length: 3 Sorted: Yes List content: 1 -> 2 -> 3

        // Delete a specific node
        list.Delete(new DNode(2));

        // Print the list
        list.Print(); // List length: 2 Sorted: Yes List content: 1 -> 3

        // Check if the list is sorted
        System.out.println("Is the list sorted? " + list.isSorted()); // Is the list sorted? true

        // Sort the list
        list.Sort();

        // Print the list
        list.Print(); // List length: 2 Sorted: Yes List content: 1 -> 3

        // Clear the list
        list.Clear();

        // Print the list
        list.Print(); // List length: 0 Sorted: Yes List content: empty
        System.out.println("-------------------------------------------------");
        System.out.println("Finished Running functionality testing of CSLL");
    }



    private static void testCDLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running functionality testing of CDLL");
        CDLL list = new CDLL();

        // insert nodes into list
        list.InsertTail(new DNode(10));
        list.InsertTail(new DNode(20));
        list.InsertTail(new DNode(30));
        list.InsertTail(new DNode(40));
        list.InsertHead(new DNode(5));
        list.Insert(new DNode(15), 3);

        System.out.println("Inserting 5, 10, 15, 20, 30, and 40 into the list...");

        // print out the list
        list.Print();

        // delete nodes from list
        list.DeleteHead();
        list.DeleteTail();
        list.Delete(new DNode(15));

        System.out.println("Deleting the head, tail, and node with value 15 from the list...");

        // print out the updated list
        list.Print();

        // search for a node in the list
        DNode searchNode = new DNode(20);
        DNode foundNode = list.Search(searchNode);

        if (foundNode != null) {
            System.out.println("Found node with value " + searchNode.getData() + " in the list.");
        } else {
            System.out.println("Did not find node with value " + searchNode.getData() + " in the list.");
        }

        // sort the list
        list.Sort();

        System.out.println("Sorting the list...");

        // print out the sorted list
        list.Print();
        System.out.println("-------------------------------------------------");
        System.out.println("Running functionality testing of CDLL");

    }

    private static void testDLL() {

        System.out.println("-------------------------------------------------");
        System.out.println("Running functionality testing of DLL");

// Create a new DLL
        DLL dll = new DLL();
        System.out.println("New DLL created.");

// Insert nodes at head
        dll.InsertHead(new DNode(3));
        System.out.println("Inserted node with data = 3 at the head.");
        dll.InsertHead(new DNode(2));
        System.out.println("Inserted node with data = 2 at the head.");
        dll.InsertHead(new DNode(1));
        System.out.println("Inserted node with data = 1 at the head.");

// Insert nodes at tail
        dll.InsertTail(new DNode(4));
        System.out.println("Inserted node with data = 4 at the tail.");
        dll.InsertTail(new DNode(5));
        System.out.println("Inserted node with data = 5 at the tail.");
        dll.InsertTail(new DNode(6));
        System.out.println("Inserted node with data = 6 at the tail.");

// Insert a node at a specific position
        int position = 4;
        dll.Insert(new DNode(7), position);
        System.out.println("Inserted node with data = 7 at position " + position + ".");
        dll.Print();

// Search for a node
        DNode node = dll.Search(new DNode(7));
        if (node != null) {
            System.out.println("Search result: Node with data = " + node.getData() + " found.");
        } else {
            System.out.println("Search result: Node with data = 7 not found.");
        }

// Delete a node
        DNode nodeToDelete = new DNode(2);
        dll.Delete(nodeToDelete);
        System.out.println("Deleted node with data = " + nodeToDelete.getData() + ".");

// Sort the list
        dll.Sort();
        System.out.println("List sorted in ascending order.");

// Print the list
        System.out.print("DLL content: ");
        dll.Print();

// Clear the list
        dll.Clear();
        System.out.println("List cleared.");
        System.out.println("-------------------------------------------------");
        System.out.println("Finished running functionality testing of DLL.");

    }

    private static void testStackLL() {
        System.out.println("Running  functionality testing of StackLL");
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
        System.out.println("Finished Running functionality testing of StackLL");
    }

    private static void testQueueLL() {
        System.out.println("-------------------------------------------------");
        System.out.println("Running functionality testing of QueueLL");
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
        DNode nodeToSearch = new DNode(30);
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
        System.out.println("Finished running functionality testing of QueueLL");
    }

    private static void testSLL() {
        System.out.println("Running functionality testing of SLL");
        System.out.println("-------------------------------------------------");
        // Create a new singly linked list
        SLL list = new SLL();

        // Insert nodes at the head and tail of the list
        DNode node1 = new DNode(10);
        DNode node2 = new DNode(20);
        list.InsertHead(node1);
        list.InsertTail(node2);

        // Insert nodes at specific positions in the list
        DNode node3 = new DNode(15);
        DNode node4 = new DNode(5);
        DNode node5 = new DNode(25);
        list.Insert(node3, 1); // Insert at position 1
        list.Insert(node4, 0); // Insert at position 0
        list.Insert(node5, 4); // Insert at position 4

        // Print the list
        System.out.println("Initial list:");
        list.Print();

        // Search for a node in the list
        DNode node6 = new DNode(15);
        DNode foundNode = list.Search(node6);
        if (foundNode != null) {
            System.out.println("Node with data = " + node6.getData() + " found in list.");
        } else {
            System.out.println("Node with data = " + node6.getData() + " not found in list.");
        }

        // Delete the head and tail nodes
        System.out.println("Deleting head and tail nodes:");
        list.DeleteHead();
        list.DeleteTail();
        list.Print();

        // Delete a specific node in the list
        DNode node7 = new DNode(20);
        System.out.println("Deleting node with data = " + node7.getData() + ":");
        list.Delete(node7);
        list.Print();

        // Sort the list and print it
        System.out.println("Sorting the list:");
        list.Sort();
        list.Print();

        // Insert a new node in its sorted position
        DNode node8 = new DNode(12);
        System.out.println("Inserting node with data = " + node8.getData() + " in sorted position:");
        list.SortedInsert(node8);
        list.Print();

        // Clear the list
        System.out.println("Clearing the list:");
        list.Clear();
        list.Print();

        System.out.println("-------------------------------------------------");
        System.out.println("Finished running functionality testing of SLL");
    }

    private static void testBST() {
        System.out.println("Running functionality testing of BST");
        System.out.println("-------------------------------------------------");
        
        // create a new BST object
        BST tree = new BST();

        // insert some nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        //Printing in order
        System.out.println("Printing in order:");
        tree.printInOrder();
        //Printintg in breadth first form
        System.out.println("\nPrinting in Breadth First Order:");
        tree.printBF();

        // testing the search function
        TNode node = tree.search(40);
        if (node != null) {
            System.out.println("Searching for 40... \n" + node.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }

        // test the delete function
        tree.delete(20);
        System.out.println("Ordered Traversal after deletion: ");
        tree.printInOrder();

        System.out.println("\n-------------------------------------------------");
        System.out.println("Finished running functionality testing of BST");
    }
    private static void testAVL() {
        System.out.println("Running functionality testing of AVL");
        System.out.println("-------------------------------------------------");
        
        // create a new BST object
        AVL tree = new AVL();

        // insert some nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Printing in order:");
        tree.printInOrder();
        System.out.println("\nPrinting in Breadth First Order:");
        tree.printBF();
        System.out.println("Deleting from the tree...");
        tree.delete(30);
        System.out.println("Printing after deleting from the tree:");
        tree.printInOrder();
        // test the search function
        TNode node = tree.search(40);
        if (node != null) {
            System.out.println("\nSearch for 40: \n" + node.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }

        

        System.out.println("\n-------------------------------------------------");
        System.out.println("Finished running functionality testing of AVL");
    }
    private static void testMaxH(){
        MaxH maxHeap = new MaxH();
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(14);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(8);
        maxHeap.insert(19);

        // print the contents of the MaxH heap
        System.out.println("MaxH heap:");
        maxHeap.print();
        System.out.println("Peek max: " + maxHeap.peekMax()); // should print 10
        System.out.println("Extract max: " + maxHeap.extractMax()); // should print 10
        System.out.println("After extracting max:");
        maxHeap.print();

    }
    private static void testMinH(){

        // create a MinH heap and add elements
        MinH minHeap = new MinH();
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(14);
        minHeap.insert(7);
        minHeap.insert(5);

        // print the contents of the MinH heap
        System.out.println("Peek min: " + minHeap.peekMin()); // should print 1
        System.out.println("Extract min: " + minHeap.extractMin()); // should print
        minHeap.print();
    }


    private static void testGraph(){
        System.out.println("Running functionality testing of Graph");
        System.out.println("-------------------------------------------------");

        // create a graph with 5 vertices and 6 edges
        Graph graph = new Graph();
        for (int i = 0; i < 5; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // test dfs method
        System.out.println("DFS traversal of the graph:");
        graph.dfs();
        System.out.println();

        // test bfs method
        System.out.println("BFS traversal of the graph:");
        graph.bfs();
        System.out.println();

        // test dijkstra method
        System.out.println("Dijkstra's algorithm from vertex 0:");
        graph.dijkstra(0);

        System.out.println("\n-------------------------------------------------");
        System.out.println("Finished running functionality testing of Graph\n");
    }

}




