package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.ReverseLL;

public class ReverseLLRecurImpl implements ReverseLL {
    @Override
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode originNextNode = head.next;
        ListNode newHead = reverse(originNextNode);
        originNextNode.next = head;
        head.next = null;
        return newHead;
    }
}
