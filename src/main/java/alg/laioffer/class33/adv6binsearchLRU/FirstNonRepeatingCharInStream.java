package alg.laioffer.class33.adv6binsearchLRU;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharInStream {
  private Node head, tail;
  private Map<Character, Node> singled;
  private Set<Character> repeated;

  public FirstNonRepeatingCharInStream() {
    tail = new Node(null);
    head = new Node(null);
    head.next = tail;
    tail.prev = head;
    singled = new HashMap<>();
    repeated = new HashSet<>();
  }

  public void read(char ch) {
    if (repeated.contains(ch)) {
      return;
    }
    Node node = singled.get(ch);
    if (node == null) {
      node = new Node(ch);
      append(node);
    } else {
      remove(node);
    }
  }

  private void append(Node node) {
    singled.put(node.ch, node);
    Node last = tail.prev;
    last.next = node;
    node.prev = last;
    node.next = tail;
    tail.prev = node;
  }

  private void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
    repeated.add(node.ch);
    singled.remove(node.ch);
  }

  public Character firstNonRepeating() {
    if (head.next == tail) return null;
    return head.next.ch;
  }

  static class Node {
    Node prev, next;
    Character ch;

    Node(Character ch) {
      this.ch = ch;
    }
  }
}
