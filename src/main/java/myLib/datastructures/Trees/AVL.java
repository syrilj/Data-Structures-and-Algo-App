package myLib.datastructures.Trees;

import myLib.datastructures.nodes.TNode;

public class AVL extends BST {
    /**
     * AVL class extends Binary Search Tree (BST) and implements the AVL balancing algorithm to maintain balance in the tree.
     */
    private TNode root;
     /**
     * Constructs an empty AVL tree with null root.
     */
    public AVL() {
        root = null;
    }
     /**
     * Constructs a new AVL tree with given value as root node.
     * @param val The integer value to be added as the root node.
     */
    public AVL(int val) {
        root = new TNode(val);
    }
    /**
     * Constructs an AVL tree with the given node as root node and balances the tree.
     * If the given node has children, the constructor creates a balanced tree from
     * the passed tree using a full tree balancing algorithm.
     * @param obj The root node of the tree.
     */
    public AVL(TNode obj) {
        root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            int size = getSize(obj);
            TNode[] sortedNodes = new TNode[size];
            inorderToArray(obj, sortedNodes, 0);
            root = buildBalancedAVL(sortedNodes, 0, size - 1);
        }
    }

    /**
     * Helper function to get the size of the subtree rooted at the given node.
     * @param node The root node of the subtree.
     * @return The size of the subtree rooted at the given node.
     */
    private int getSize(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }

    /**
     * Helper function to convert a subtree rooted at the given node to a sorted array.
     * @param node The root node of the subtree.
     * @param sortedNodes The sorted array to store the nodes in.
     * @param index The starting index to insert nodes in the array.
     * @return The ending index in the array after inserting nodes from the subtree.
     */
    private int inorderToArray(TNode node, TNode[] sortedNodes, int index) {
        if (node != null) {
            index = inorderToArray(node.getLeft(), sortedNodes, index);
            sortedNodes[index++] = node;
            index = inorderToArray(node.getRight(), sortedNodes, index);
        }
        return index;
    }

    /**
     * Builds a balanced AVL tree from a sorted array of nodes.
     * @param nodes The sorted array of nodes.
     * @param start The starting index of the range of nodes to consider.
     * @param end The ending index of the range of nodes to consider.
     * @return The root node of the balanced AVL tree.
     */
    private TNode buildBalancedAVL(TNode[] nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TNode root = nodes[mid];
        root.setLeft(buildBalancedAVL(nodes, start, mid - 1));
        root.setRight(buildBalancedAVL(nodes, mid + 1, end));
        return root;
    }

    /**
     * Sets the root node of the tree to the given node and balances the tree.
     * @param node The new root node for the tree.
     */
    
    public void setRoot(TNode node) {
        root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            balanceTree();
        }
    }
    /**
     * Returns the root node of the tree.
     * @return The root node of the tree.
     */
    
    public TNode getRoot() {
        return root;
    }
    /**
     * Balances the AVL tree using AVL balancing algorithm.
     */
    private void balanceTree() {
        // implement AVL balancing algorithm here
    }
     /**
     * Inserts the given value into the AVL tree and balances the tree.
     * @param val The integer value to be added to the tree.
     */
    
    @Override
    public void insert(int val) {
        super.insert(val);
        balanceTree();
    }

    /**
     * Inserts the given node into the AVL tree and balances the tree.
     * @param node The node to be added to the tree.
     */

    public void insert(TNode node) {
        super.insert(node);
        balanceTree();
    }
    /**
     * Deletes the node with given value from the AVL tree and balances the tree.
     * @param val The integer value to be deleted from the tree.
     */

    public void delete(int val) {
        TNode node = search(val);
        if (node == null) {
            System.out.println("Value " + val + " not found in the tree.");
            return;
        }
        else{
            super.delete(node);
            balanceTree();
        }
        
    }
}
