package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.ReorderLL;

public class ReorderLLImpl implements ReorderLL {
    @Override
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode otherHalf = middle.next;
        middle.next = null;
        ListNode reversedOtherHalf = reverse(otherHalf);
        return merge(head, reversedOtherHalf);
    }

    private ListNode merge(ListNode firstHalf, ListNode otherHalf) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (firstHalf != null && otherHalf != null) {
            // step 1 connect firsthalf
            cur.next = firstHalf;
            firstHalf = firstHalf.next;
            // step 2 connect otherHalf
            cur.next.next = otherHalf;
            otherHalf = otherHalf.next;
            // move forward two step
            cur = cur.next.next;
        }
        if (firstHalf != null) {
            cur.next = firstHalf;
        } else {
            cur.next = otherHalf;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode originNext = head.next;
        ListNode newHead = reverse(originNext);
        originNext.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
