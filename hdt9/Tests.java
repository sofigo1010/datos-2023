/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Tests.java
 * Fecha: 21/04/2023
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testInsertAndSearchAVL() {
        AVLTree<Integer, String> tree = new AVLTree<>();
        tree.insert(1, "uno");
        assertEquals("uno", tree.search(1));
        assertNull(tree.search(2));
    }
    @Test
    public void testInsertAndSearchRBT() {
        RedBlackTree<Integer, String> tree = new RedBlackTree();
        tree.insert(1, "uno");
        assertEquals("uno", tree.search(1));
        assertNull(tree.search(2));
    }

}
