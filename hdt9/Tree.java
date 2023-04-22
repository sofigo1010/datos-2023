public interface Tree<K extends Comparable<K>, V> {
    void insert(K key, V value);
    V search(K key);
}
