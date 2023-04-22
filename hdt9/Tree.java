/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Tree.java
 * Fecha: 21/04/2023
 */

public interface Tree<K extends Comparable<K>, V> {
    void insert(K key, V value);
    V search(K key);
}
