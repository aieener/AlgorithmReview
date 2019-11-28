package alg.laioffer.class4.linkedlist;


public class ReverseLinkedList {
    public ListNode reverseIter(ListNode head) {
        // write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseRecur(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;
        // recur rule
        ListNode newSecondTail = head.next;
        ListNode res = reverseRecur(newSecondTail);
        newSecondTail.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ReverseLinkedList r1 = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

    }
}
