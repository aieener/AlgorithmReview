package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.CheckIfLinkedListIsPalindrome;
import alg.laioffer.class4.linkedlist.ListNode;

public class CheckIfLinkedListIsParlindromeImpl implements CheckIfLinkedListIsPalindrome {

    @Override
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = findMiddle(head);
        ListNode otherHalf = mid.next;
        mid.next = null;
        ListNode reversedOtherHalf = reverse(otherHalf);
        while(reversedOtherHalf != null && head != null) {
            if(reversedOtherHalf.value != head.value) return false;
            reversedOtherHalf = reversedOtherHalf.next;
            head = head.next;
        }
        return true;
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
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
