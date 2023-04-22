public class TreeFactory {

    public static <K extends Comparable<K>, V> Tree<K, V> createTree(String treeType) {
        if (treeType == null) {
            throw new IllegalArgumentException("Tree type must not be null");
        }

        switch (treeType) {
            case "avl":
                return new AVLTree<>();
            case "rbt":
                return new RedBlackTree<>();
            default:
                throw new IllegalArgumentException("Invalid tree type");
        }
    }
}
