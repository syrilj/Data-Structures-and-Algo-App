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
     * @param obj The root node of the tree.
     */
    public AVL(TNode obj) {
        root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            balanceTree();
        }
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
