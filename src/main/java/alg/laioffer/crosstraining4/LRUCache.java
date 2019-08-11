package alg.laioffer.crosstraining4;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
  private Map<K, Node<K, V>> lkup;
  private Node<K, V> head, tail;
  private int limit;

  public LRUCache(int limit) {
    lkup = new HashMap<>();
    head = new Node<>(null, null);
    tail = new Node<>(null, null);
    tail.prev = head;
    head.next = tail;
    this.limit = limit;
  }

  public void set(K key, V value) {
    if(lkup.containsKey(key)) {
      lkup.get(key).value = value;
      moveNodeToRecent(lkup.get(key));
    } else {
      Node<K, V> newNode = new Node<>(key, value);
      Node<K, V> oldLastNode = tail.prev;
      oldLastNode.next = newNode;
      newNode.prev = oldLastNode;
      newNode.next = tail;
      tail.prev = newNode;

      lkup.put(key, newNode);
      if(lkup.size() > limit) {
        deleteLRUNode();
      }
    }
  }

  private void moveNodeToRecent(Node<K, V> tar) {
    removeNode(tar);
    tail.prev.next = tar;
    tar.prev = tail.prev;
    tail.prev = tar;
    tar.next = tail;
  }

  private void removeNode(Node<K, V> tar) {
    tar.prev.next = tar.next;
    tar.next.prev = tar.prev;
  }

  private void deleteLRUNode() {
    if(head.next == tail) return;
    Node<K, V> LRUNode = head.next;
    // remove from lkup
    lkup.remove(LRUNode.key);
    // remove from list
    head.next.next.prev = head;
    head.next = head.next.next;
  }

  public V get(K key) {
    if (!lkup.containsKey(key)) return null;
    moveNodeToRecent(lkup.get(key));
    return lkup.get(key).value;
  }

  public String printList(Node<K, V> head) {
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      sb.append(head.key);
      sb.append("->");
      head = head.next;
    }
    return sb.toString();
  }

  static class Node<K, V> {
    K key;
    V value;
    Node next;
    Node prev;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}
