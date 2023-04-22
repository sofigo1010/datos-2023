public class RedBlackTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left, right, parent;
        boolean color;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = parent = null;
            color = RED;
        }
    }

    private Node root;

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) rightChild.left.parent = node;
        rightChild.parent = node.parent;
        if (node.parent == null) root = rightChild;
        else if (node == node.parent.left) node.parent.left = rightChild;
        else node.parent.right = rightChild;
        rightChild.left = node;
        node.parent = rightChild;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) leftChild.right.parent = node;
        leftChild.parent = node.parent;
        if (node.parent == null) root = leftChild;
        else if (node == node.parent.left) node.parent.left = leftChild;
        else node.parent.right = leftChild;
        leftChild.right = node;
        node.parent = leftChild;
        return leftChild;
    }

    private void fixInsert(Node node) {
        while (node != root && isRed(node.parent)) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (isRed(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (isRed(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            root.color = BLACK;
        } else {
            Node currentNode = root;
            Node parent = null;
            while (currentNode != null) {
                parent = currentNode;
                if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
                else currentNode = currentNode.right;
            }
            newNode.parent = parent;
            if (key.compareTo(parent.key) < 0) parent.left = newNode;
            else parent.right = newNode;
            fixInsert(newNode);
        }
    }
    public V search(K key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
            else if (key.compareTo(currentNode.key) > 0) currentNode = currentNode.right;
            else return currentNode.value;
        }
        return null;
    }
}