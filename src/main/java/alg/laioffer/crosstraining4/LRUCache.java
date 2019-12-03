package alg.laioffer.crosstraining4;

public interface LRUCache<K, V> {
    void set(K key, V value);

    V get(K key);
}
