package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.MergeSortLinkedList;

public class MergeSortLinkedListImpl implements MergeSortLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(6);
    head.next = new ListNode(4);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(1);
    head.next.next.next.next.next = new ListNode(2);

    MergeSortLinkedList engine = new MergeSortLinkedListImpl();
    engine.mergeSort(head);
  }

  @Override
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode midNode = getMiddle(head);
    ListNode secHalf = midNode.next;
    midNode.next = null;
    ListNode first = mergeSort(head);
    ListNode second = mergeSort(secHalf);
    return merge(first, second);
  }

  private ListNode merge(ListNode first, ListNode second) {
    if (first == null) return second;
    if (second == null) return first;
    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;
    while (first != null && second != null) {
      if (first.value < second.value) {
        cur.next = first;
        first = first.next;
      } else {
        cur.next = second;
        second = second.next;
      }
      cur = cur.next;
    }

    if (first == null) {
      cur.next = second;
    } else {
      cur.next = first;
    }

    return dummyHead.next;
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
