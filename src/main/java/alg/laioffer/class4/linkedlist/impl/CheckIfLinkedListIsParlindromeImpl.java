package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.CheckIfLinkedListIsPalindrome;
import alg.laioffer.class4.linkedlist.ListNode;

public class CheckIfLinkedListIsParlindromeImpl implements CheckIfLinkedListIsPalindrome {
  @Override
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode mid = getMiddle(head);
    ListNode sec = mid.next;
    mid.next = null;
    sec = reverse(sec);

    while (head != null && sec != null) {
      if (head.value != sec.value) return false;
      head = head.next;
      sec = sec.next;
    }

    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    return recur(head, null);
  }

  private ListNode recur(ListNode cur, ListNode prev) {
    if (cur == null) return prev;
    ListNode curRef = cur; // key: don't lose the head!
    ListNode newHead = recur(cur.next, cur);
    curRef.next = prev;
    return newHead;
  }

  private ListNode getMiddle(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
