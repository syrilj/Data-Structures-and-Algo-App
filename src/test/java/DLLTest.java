import myLib.datastructures.nodes.DNode;
import myLib.datastructures.Linear.DLL;

public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        DNode node1 = new DNode(8);
        DNode node2 = new DNode(21);
        DNode node3 = new DNode(17);

        // Insert some nodes into the list
        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.Insert(node3, 2);

        // Print the list
        dll.Print(); // output: List length: 3 \n 1 <-> 3 <-> 2

        // Sort the list
        dll.Sort();

        // Print the sorted list
        dll.Print(); // output: List length: 3 \n Sorted: Yes \n 1 <-> 2 <-> 3

        // Search for a node
        DNode node = new DNode(7);
        DNode result = dll.Search(node);
        System.out.println(result != null ? "Found" : "Not found"); // output: Found

        // Delete a node
        dll.Delete(node);

        // Print the updated list
        dll.Print(); // output: List length: 2 \n Sorted: Yes \n 1 <-> 3
    }

}

