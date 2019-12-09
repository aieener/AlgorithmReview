package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.CheckIfLLHasCycle;
import alg.laioffer.class4.linkedlist.ListNode;

public class CheckIfLLHasCycleImpl implements CheckIfLLHasCycle {
    @Override
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}
