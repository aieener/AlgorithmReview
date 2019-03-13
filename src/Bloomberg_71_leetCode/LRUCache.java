package Bloomberg_71_leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146, Combination of OOD, LinkedList and HashMap
 * 基础题,必须要会  Need revisit!!!
 * Both get and put operation will take O(1) with the usage of hashMap
 */
public class LRUCache {

    // Most used Node is at tail
    private class Node {
        int key, value;
        Node next, prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> hash = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if(!hash.containsKey(key)){
            return -1;
        }
        // remove current
        Node current = hash.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail O(1)
        move_to_tail(current);
        return hash.get(key).value;
    }

    public void put (int key, int value) {
        // just set it, if the key exist
        if(get(key) != -1) { //==============>>>>>> This line is Key!
            hash.get(key).value = value;
            // since we called get(key), it will put the Node to tail
            return;
        }

        Node newNode = new Node(key, value);
        if(hash.size() == capacity) {
            // remove the first node head points to
            hash.remove(head.next.key); // delete from hashTable

            head.next = head.next.next; // delete from LinkedList
            head.next.prev= head;
        }

        // insert the node to the tail
        hash.put(key, newNode);
        move_to_tail(newNode);

    }

    private void move_to_tail(Node current) {
        //O(1)
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
        return;
    }
}

// ------------ prac --------------
class LRUCache1 {
    class Node {
        int key, val;
        Node next, prev;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private Node head,tail;
    private Map<Integer, Node> hashmap =  new HashMap<>();
    private int capacity;
    public LRUCache1(int capacity) {
        // dummy head and tail
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node tar = hashmap.getOrDefault(key, null);
        if(tar == null) {
            return -1;
        }
        // remove tar
        tar.prev.next = tar.next;
        tar.next.prev = tar.prev;
        // append tar to tail
        append_to_tail(tar);
        return tar.val;
    }

    private void append_to_tail(Node tar) {
        tar.next = tail;
        tar.prev = tail.prev;
        tar.next.prev = tar;
        tar.prev.next = tar;
        return;
    }

    public void put(int key, int value) {
        Node tar = hashmap.getOrDefault(key, null);
        if(tar == null) {
            tar = new Node(key, value);
            if(capacity == hashmap.size()) {
                hashmap.remove(head.next.key);
                // remove node next to head
                head.next.next.prev = head;
                head.next = head.next.next;
            }
            hashmap.put(key, tar);
            append_to_tail(tar);
        } else {
            // just set it
            tar.val = value;
            get(key);
        }

        return;
    }

}
