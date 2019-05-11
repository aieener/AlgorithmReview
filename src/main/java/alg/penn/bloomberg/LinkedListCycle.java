package alg.penn.bloomberg;

import alg.laioffer.class3.linkedlist.stack.queue.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == slow) {
            return true;
        }
        return false;
    }
}
