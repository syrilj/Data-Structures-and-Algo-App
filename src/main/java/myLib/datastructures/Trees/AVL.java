package myLib.datastructures.Trees;



public class AVL extends BST {
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val);
    }

    public AVL(TNode obj) {
        this.root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            AVL balancedTree = createBalancedTree(obj);
            this.root = balancedTree.getRoot();
        }
    }

    public void setRoot(TNode root) {
        this.root = root;
        if (root.getLeft() != null || root.getRight() != null) {
            AVL balancedTree = createBalancedTree(root);
            this.root = balancedTree.getRoot();
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    private AVL createBalancedTree(TNode node) {
        AVL avl = new AVL();
        createBalancedTreeHelper(avl, node);
        return avl;
    }

    private void createBalancedTreeHelper(AVL avl, TNode node) {
        if (node == null) {
            return;
        }
        createBalancedTreeHelper(avl, node.getLeft());
        createBalancedTreeHelper(avl, node.getRight());
        avl.insert(node.getData());
    }

    private int height(TNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    
    private TNode rotateRight(TNode y) {
    TNode x = y.left;
    TNode T2 = x.right;

    x.right = y;
    y.left = T2;

    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
}
    private int getBalance(TNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private TNode rightRotate(TNode y) {
        TNode x = y.left;
        TNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }


    private TNode rotateLeft(TNode node) {
    TNode newParent = node.right;
    node.right = newParent.left;
    newParent.left = node;
    node.setHeight(Math.max(height(node.left), height(node.right)) + 1);
    newParent.setHeight(Math.max(height(newParent.left), height(newParent.right)) + 1);
    return newParent;
}

    private TNode leftRotate(TNode x) {
        TNode y = x.right;
        TNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private TNode insertHelper(TNode node, int key) {
        if (node == null) {
            return new TNode(key);
        }

        if (key < node.data) {
            node.left = insertHelper(node.left, key);
        } else if (key > node.data) {
            node.right = insertHelper(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.data) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.data) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int val) {
    root = insert(root, val);
}

private TNode insert(TNode node, int val) {
    if (node == null) {
        return new TNode(val);
    }

    if (val < node.getData()) {
        node.setLeft(insert(node.getLeft(), val));
    } else if (val > node.getData()) {
        node.setRight(insert(node.getRight(), val));
    } else {
        // value already exists
        return node;
    }

    node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

    int balance = getBalance(node);

    if (balance > 1 && val < node.getLeft().getData()) {
        return rotateRight(node);
    }

    if (balance < -1 && val > node.getRight().getData()) {
        return rotateLeft(node);
    }

    if (balance > 1 && val > node.getLeft().getData()) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    if (balance < -1 && val < node.getRight().getData()) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }

    return node;
}
}
