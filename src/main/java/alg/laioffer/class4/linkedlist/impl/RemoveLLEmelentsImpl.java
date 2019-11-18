package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.RemoveLLElement;

public class RemoveLLEmelentsImpl implements RemoveLLElement {
  @Override
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      if (val == cur.value) {
        //remove
        if (prev == null) {
          head = head.next;
        } else {
          prev.next = cur.next;
        }
      } else {
        // proceed
        prev = cur;
      }
      cur = cur.next;
    }
    return head;
  }
}
