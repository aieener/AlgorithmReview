package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.FiretNonRepeatingCharInStream;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingImpl implements FiretNonRepeatingCharInStream {
    static class Node {
        Character value;
        Node next;
        Node prev;

        public Node(Character value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    private Map<Character, Node> lkup;
    private Node head, tail;

    public FirstNonRepeatingImpl() {
        this.lkup = new HashMap<>();
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    private void appendToLastToLL(Node target) {
        Node currentLast = tail.prev;
        currentLast.next = target;
        target.prev = currentLast;
        target.next = tail;
        tail.prev = target;
    }

    private void removeNodeFromLL(Node target) {
        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;
    }

    @Override
    public void read(char ch) {
        if(!lkup.containsKey(ch)) {
            // unvisited
            Node newNode = new Node(ch);
            appendToLastToLL(newNode);
            lkup.put(ch, newNode);
        } else if (lkup.get(ch) != null) {
            // first time repeat
            removeNodeFromLL(lkup.get(ch));
            lkup.put(ch, null);
        }
        // repeat already do nothing
    }

    @Override
    public Character firstNonRepeating() {
        return head.next.value;
    }
}
