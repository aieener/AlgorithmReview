package Class_03_LL;

public class CheckCycleLL {
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow && fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == slow){
            return true;
        }
        return false;

    }

    //------------- prac ---------

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(slow != fast && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow == fast) {
            slow = head;
            while(slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}
