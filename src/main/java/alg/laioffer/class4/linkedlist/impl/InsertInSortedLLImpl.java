package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.InsertInSortedLL;
import alg.laioffer.class4.linkedlist.ListNode;

public class InsertInSortedLLImpl implements InsertInSortedLL {
    @Override
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;

        ListNode largestSmallerNodeToTarget = findLargestSmaller(head, value);
        if(largestSmallerNodeToTarget == null) {
            newNode.next = head;
            return newNode;
        }
        ListNode next = largestSmallerNodeToTarget.next;
        largestSmallerNodeToTarget.next = newNode;
        newNode.next = next;
        return head;
    }

    private ListNode findLargestSmaller(ListNode head, int value) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.value <= value) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}
