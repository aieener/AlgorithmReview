package Prac_17_HashMap;

import java.util.Arrays;

/**
 * Created by yuding on 2/4/18.
 * Note: generic Templete to be add at the outside of class
 *
 */


public class MyHashMap<K, V> {
    public static class Node<K, V> {
        private final K key;
        private V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static final int INIT_CAP = 16;
    public static final double LOAD_FACTOR = 0.7;

    private Node <K, V> [] array;
    private int size;

    public MyHashMap() {
        array = (Node<K, V> []) new Node[INIT_CAP];
        size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        int code = key.hashCode();
        return code & 0x7fffffff; // TODO: add mask, need to understand better
    }

    private int index(K key) {
        // this function used hash function!!!
        return hash(key) % array.length;
    }

    private boolean equalsKey(K a, K b) {
        return a == b || a != null && a.equals(b);
    }

    private boolean needRehasing() {
        return size > LOAD_FACTOR * array.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public V get(K key) {
        Node<K, V> node = array[index(key)];
        while (node != null) {
            if(equalsKey(node.getKey(),key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        Node<K, V> node = array[index(key)];
        while (node != null) {
            if(equalsKey(node.getKey(), key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V put(K key, V value) {
        int i = index(key); // using the hash function to cal index
        Node<K,V> node = array[i];
        // if K exist
        while (node != null) {
            if(equalsKey(node.getKey(),key)) {
                V oldeValue = node.getValue(); // record the old var
                node.setValue(value); // set the new var
                return oldeValue; // return the old var
            }
            node = node.next;
        }

        // if K not exist
        Node <K, V> newEntry = new Node <> (key, value);
        newEntry.next = array[i];
        array[i] = newEntry;
        size++;
        if(needRehasing()) {
            rehash();
        }
        return null;
    }

    public V remove( K key) {
        int i = index(key);
        Node<K, V> prev = null;
        Node<K, V> curr = array[i];
        while (curr != null) {
            if(equalsKey(curr.getKey(), key)) {
                if (prev == null) {
                    // remove cur
                    array[i] = curr.next;
                } else {
                    // remove cur
                    prev.next = curr.next;
                }
                size--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.next;
        }
        // K not found
        return null;
    }

    private void rehash() {
        Node<K, V> [] old = array;
        array = (Node<K, V>[]) new Node [old.length * 2];
        for(Node<K, V> e : old) {
            while( e != null) {
                Node<K, V> next = e.next;

                int i = index(e.getKey()); // recalc the idx using hash func
                e.next = array[i];
                array[i] = e;
                e = next;
            }
        }
    }
}

