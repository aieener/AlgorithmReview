package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.RemoveLLElement;

public class RemoveLLEmelentsImpl implements RemoveLLElement {
    @Override
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null) {
            if(cur.value == val) {
                cur = cur.next;
                prev.next = cur; // handling target is at tail case
            } else {
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
