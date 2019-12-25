package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.LRUCache;

import java.util.HashMap;

public class LRUCacheImpl <K, V> implements LRUCache {
    static class ListNode<K, V> {
        ListNode next, prev;
        V value;
        K key;
        public ListNode(K key, V value) {
            this.value = value;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    private ListNode<K, V> head;
    private ListNode<K, V> tail;
    private HashMap<K, ListNode<K, V>> map;
    private Integer limit;

    public LRUCacheImpl(int limit) {
        this.limit = limit;
        head = new ListNode<>(null, null);
        tail = new ListNode<>(null, null);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    @Override
    public void set(Object key, Object value) {
        if(map.containsKey(key)) {
            // move Node to head
            moveToHead(key);
            // set value
            map.get(key).value = (V) value;
        } else {
            ListNode<K, V> newNode = new ListNode<K, V>((K) key, (V) value);
            // add node to map and append it at LL
            map.put((K) key,newNode);
            insertAtFrontInLL(newNode);
            // if exceed limit :
            if(getLoadSize() > limit) {
                // remove from map and LL
                map.remove(tail.prev.key);
                deleteTailNodeFromLL();
            }
        }
    }

    private void insertAtFrontInLL(ListNode<K, V> node) {
        if(getLoadSize() > 0) {
            ListNode<K, V> curFirstNode = head.next;
            node.next = curFirstNode;
            curFirstNode.prev = node;
            head.next = node;
            node.prev = head;
        }
    }

    private void moveToHead(Object key) {
        ListNode<K, V> targetNode = map.get(key);
        if(head.next != targetNode) {
            // remove it first
            ListNode<K, V> prevNode = targetNode.prev;
            ListNode<K, V> nextNode = targetNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            // insert to front
            insertAtFrontInLL(targetNode);
        }
    }

    private void deleteTailNodeFromLL() {
        if(getLoadSize() > 0) {
            ListNode<K, V> last = tail.prev;
            ListNode<K, V> secLast = last.prev;
            secLast.next = tail;
            tail.prev = secLast;
        }
    }

    private int getLoadSize() {
        return map.size();
    }

    public Object get(Object key) {
        if(map.containsKey(key)) {
           // move Node to head
            moveToHead(key);
            return map.get(key).value;
        }
        return null;
    }
}
