package myLib.datastructures.Trees;


public class AVL extends BST {
    private TNode root;
    
    public AVL() {
        root = null;
    }
    
    public AVL(int val) {
        root = new TNode(val);
    }
    
    public AVL(TNode obj) {
        root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            balanceTree();
        }
    }
    
    public void setRoot(TNode node) {
        root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            balanceTree();
        }
    }
    
    public TNode getRoot() {
        return root;
    }
    
    private void balanceTree() {
        // implement AVL balancing algorithm here
    }
    
    @Override
    public void insert(int val) {
        super.insert(val);
        balanceTree();
    }
    
    public void insert(TNode node) {
        super.insert(node);
        balanceTree();
    }
    
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
