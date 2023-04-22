import java.util.HashMap;

public class HashMapTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private HashMap<K, V> hashMap;

    public HashMapTree() {
        hashMap = new HashMap<>();
    }

    @Override
    public void insert(K key, V value) {
        hashMap.put(key, value);
    }

    @Override
    public V search(K key) {
        return hashMap.get(key);
    }
}
