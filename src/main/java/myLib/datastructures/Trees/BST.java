package myLib.datastructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private TNode root;

    // Default constructor
    public BST() {
        root = null;
    }

    // Overloaded constructor with a value
    public BST(int val) {
        root = new TNode(val, 0, null, null, null);
    }

    // Overloaded constructor with a TNode
    public BST(TNode obj) {
        root = obj;
    }

    // Getter for root
    public TNode getRoot() {
        return root;
    }

    // Setter for root
    public void setRoot(TNode root) {
        this.root = root;
    }

    // Insert a node with the given value
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
        } else {
            TNode current = root;
            TNode parent;
            while (true) {
                parent = current;
                if (val < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                }
            }
        }
    }

    // Insert a node into the tree
    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            TNode parent;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        node.setParent(parent);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        node.setParent(parent);
                        return;
                    }
                }
            }
        }
    }

    // Delete a node with the given value
public void delete(int val) {
    TNode current = root;
    while (current != null) {
        if (current.getData() == val) {
            if (current.getLeft() == null && current.getRight() == null) {
                if (current == root) {
                    root = null;
                } else if (current.getParent().getLeft() == current) {
                    current.getParent().setLeft(null);
                } else {
                    current.getParent().setRight(null);
                }
                return;
            } else if (current.getLeft() == null) {
                if (current == root) {
                    root = current.getRight();
                } else if (current.getParent().getLeft() == current) {
                    current.getParent().setLeft(current.getRight());
                } else {
                    current.getParent().setRight(current.getRight());
                }
                current.getRight().setParent(current.getParent());
                return;
            } else if (current.getRight() == null) {
                if (current == root) {
                    root = current.getLeft();
                } else if (current.getParent().getLeft() == current) {
                    current.getParent().setLeft(current.getLeft());
                } else {
                    current.getParent().setRight(current.getLeft());
                }
                current.getLeft().setParent(current.getParent());
                return;
            } else {
                TNode successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (current.getParent().getLeft() == current) {
                    current.getParent().setLeft(successor);
                } else {
                    current.getParent().setRight(successor);
                }
                successor.setParent(current.getParent());
                successor.setLeft(current.getLeft());
                current.getLeft().setParent(successor);
                return;
            }
        } else if (val < current.getData()) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }
    }
    System.out.println("Value not found in tree");
}

// Helper function to find the node with the minimum value in the subtree rooted at node
private TNode minValueNode(TNode node) {
    TNode current = node;
    while (current.getLeft() != null) {
        current = current.getLeft();
    }
    return current;
}

// Helper function to find the inorder successor of the given node
private TNode getSuccessor(TNode node) {
    if (node.getRight() != null) {
        return minValueNode(node.getRight());
    }
    TNode parent = node.getParent();
    while (parent != null && node == parent.getRight()) {
        node = parent;
        parent = parent.getParent();
    }
    return parent;
}

// Search for a node with the given value
public TNode search(int val) {
    TNode current = root;
    while (current != null) {
        if (current.getData() == val) {
            return current;
        } else if (val < current.getData()) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }
    }
    return null;
}

// Print the contents of the tree in ascending order
public void printInOrder() {
    printInOrderHelper(root);
}

private void printInOrderHelper(TNode node) {
    if (node != null) {
        printInOrderHelper(node.getLeft());
        System.out.print(node.getData() + " ");
        printInOrderHelper(node.getRight());
    }
}

// Print the contents of the tree in breadth-first order
    public void printBF() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TNode current = queue.poll();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            System.out.println();
        }
    }
}
