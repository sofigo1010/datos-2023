/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: TreeFactory.java
 * Fecha: 21/04/2023
 */

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
