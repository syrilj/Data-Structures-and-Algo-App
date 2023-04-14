package myLib.datastructures.Trees;
import myLib.datastructures.nodes.TNode;

public class AVL extends BST{
    /**
     * Default constructor initializing root to null
     */
    public AVL(){
        super();
    }

    /**
     * Overload constructor AVL(int val) which takes in an integer value, and
     * creates a TNode and use it as root
     * @param val
     */
    public AVL(int val){
        super(val);
    }



    /**
     * Overload constructor AVL(TNode obj) which takes a TNode as an
     * argument and use it as the root of the tree. If the TNode obj has children,
     * the constructor needs to create a balanced tree from passed tree by one
     * of the two following options:
     * • iteratively inserting nodes from the original tree and balancing the
     * new created AVL tree
     * • implementing a full tree balancing algorithm (Bonus)
     * @param obj
     */
    public AVL(TNode obj) {
        super(obj);
        super.getRoot().setBalance(getBalancingFactor(super.getRoot()));
        while(true){
            fullBalance(super.getRoot());
            if(getBalancingFactor(super.getRoot()) > -1 && getBalancingFactor(super.getRoot())< 1){
                break;
            }
        }
    }


    /**

     Updates the root of the AVL tree if the given node is the current root.
     @param node the node to check if it is the current root
     @param newRoot the new root node to be set if the given node is the current root
     */
    private void updateRoot(TNode node, TNode newRoot) {
        if (node == super.getRoot()) {
            super.setRoot(newRoot);
        }
    }
    /**

     Performs a left rotation on the given node in the AVL tree.

     @param node the node to be rotated

     @return the new root of the subtree after rotation
     */
    private TNode rotateLeft(TNode node) {
        TNode rightChild = node.getRight();
        TNode pivot = rightChild.getLeft();

        node.setRight(pivot);
        rightChild.setLeft(node);
        rightChild.setParent(node.getParent());
        node.setParent(rightChild);

        updateRoot(node, rightChild);

        // update fullBalance factors
        node.setBalance(node.getBalance() - 1 - Math.max(0, rightChild.getBalance()));
        rightChild.setBalance(rightChild.getBalance() - 1 + Math.min(0, node.getBalance()));

        return rightChild;
    }
    /**

     Performs a right rotation on the given node in the AVL tree.

     @param node the node to be rotated

     @return the new root of the subtree after rotation
     */
    private TNode rotateRight(TNode node) {
        TNode leftChild = node.getLeft();
        TNode pivot = leftChild.getRight();

        node.setLeft(pivot);
        leftChild.setRight(node);
        leftChild.setParent(node.getParent());
        node.setParent(leftChild);

        updateRoot(node, leftChild);

        // update fullBalance factors
        node.setBalance(node.getBalance() + 1 - Math.min(0, leftChild.getBalance()));
        leftChild.setBalance(leftChild.getBalance() + 1 + Math.max(0, node.getBalance()));

        return leftChild;
    }

    /**
     * Setter and getter for root: the setter function must check if the node has
     * children. If children are found it must do the same as the overload constructor
     * @param node
     */
    @Override
    public void setRoot(TNode node){
        // Create a new tree from node
        AVL temp = new AVL(node);
        super.setRoot(temp.getRoot());
    }

    /**
     * Inserts the given value into the AVL tree
     * @param val The integer value to be added to the tree.
     */
    @Override
    public void Insert(int val) {
        TNode nodeInsert = new TNode(val, 0, null, null, null);
        Insert(nodeInsert);
    }


    /**
     * Insert(int val): creates a new node with data val to be inserted into the tree
     * ▪ Must maintain the tree fullBalance. It can call the super. Insert (insert
     * function from BST), but will need to also fullBalance the tree after
     * @param node
     */
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        super.getRoot().setBalance(getBalancingFactor(super.getRoot()));
        // Balance after inserting
        fullBalance(super.getRoot());
    }

    /**
     * Delete(int val): finds the node with val as data and deletes it, if not found prints
     * a statement that the value is not in the tree (Bonus)
     * @param node
     */
    @Override
    public void Delete(TNode node){
        super.Delete(node);
        super.getRoot().setBalance(getBalancingFactor(super.getRoot()));
        // Balance after deleting
        fullBalance(super.getRoot());
    }

    /**

     Returns the height of the given node in the AVL tree.
     If the node is null, returns -1.
     @param node the node whose height is to be calculated
     @return the height of the node
     */
    public int getHeight(TNode node) {
        return (node == null) ? -1 : Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    /**

     Returns the fullBalance factor of the given node in the AVL tree.
     The fullBalance factor is the difference between the heights of the left and right subtrees.
     @param node the node whose fullBalance factor is to be calculated
     @return the fullBalance factor of the node
     */
    public int getBalancingFactor(TNode node) {
        int leftHeight = (node.getLeft() == null) ? -1 : getHeight(node.getLeft());
        int rightHeight = (node.getRight() == null) ? -1 : getHeight(node.getRight());
        return leftHeight - rightHeight;
    }



    /**

     Balances the given node in the AVL tree by rotating nodes as needed.

     If the node is null, does nothing.

     @param node the node to be balanced
     */
    public void fullBalance(TNode node) {
        if (node == null) {
            return; // nothing to fullBalance
        }

        int balanceFactor = node.getBalance();

        if (balanceFactor > 1) { // left-heavy
            if (getBalancingFactor(node.getLeft()) < 0) { // left-right case
                node.setLeft(rotateLeft(node.getLeft())); // rotate left subtree left
            }
            rotateRight(node); // rotate node right
        } else if (balanceFactor < -1) { // right-heavy
            if (getBalancingFactor(node.getRight()) > 0) { // right-left case
                node.setRight(rotateRight(node.getRight())); // rotate right subtree right
            }
            rotateLeft(node); // rotate node left
        }

        node.setBalance(getBalancingFactor(node)); // update node's fullBalance factor
    }
    


}