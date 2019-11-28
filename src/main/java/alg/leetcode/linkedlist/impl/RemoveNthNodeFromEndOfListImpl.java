package alg.leetcode.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.leetcode.linkedlist.RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfListImpl implements RemoveNthNodeFromEndOfList {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1); // will remove the node in front of slow
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // remove slow.next
        slow.next = slow.next.next;
        return dummy.next;
    }
}
