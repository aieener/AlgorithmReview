package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.ReverseLL;

public class ReverseLLIterImpl implements ReverseLL {
    @Override
    public ListNode reverse(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode prev = null;
       ListNode cur = head;
       ListNode next;
       while(cur != null) {
           next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
       }
       return prev;
    }
}
