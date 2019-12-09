package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.MergeSortLinkedList;

public class MergeSortLinkedListImpl implements MergeSortLinkedList {
    @Override
    public ListNode mergeSort(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode otherHalf = mid.next;
        mid.next = null;
        ListNode firstSortedHalf = mergeSort(head);
        ListNode otherSortedHalf = mergeSort(otherHalf);
        return merge(firstSortedHalf, otherSortedHalf);
    }

    private ListNode merge(ListNode base, ListNode other) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (base != null && other != null) {
            if (base.value < other.value) {
                cur.next = base;
                base = base.next;
            } else {
                cur.next = other;
                other = other.next;
            }
            cur = cur.next;
        }
        if (base != null) {
            cur.next = base;
        } else {
            cur.next = other;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
