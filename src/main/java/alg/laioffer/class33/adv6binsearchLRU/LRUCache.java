package alg.laioffer.class33.adv6binsearchLRU;

public interface LRUCache<K, V> {
    void set(K key, V value);

    V get(K key);
}
