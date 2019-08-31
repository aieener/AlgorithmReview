package alg.penn.blackstone;

import alg.laioffer.class4.linkedlist.ListNode;

/**
 * Created by yuding on 2/7/18.
 * LeetCode 2
 */
public class AddTwoNumberList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        while(l1 != null && l2 != null) {
            tail.next = new ListNode((carry + l1.value + l2.value) % 10);
            carry = ( carry + l1.value + l2.value) / 10;
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = new ListNode ((carry + l1.value) % 10);
            carry = ( carry + l1.value) / 10;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = new ListNode ((carry + l2.value) % 10);
            carry = ( carry + l2.value) / 10;
            tail = tail.next;
            l2 = l2.next;
        }
        if(carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        AddTwoNumberList al = new AddTwoNumberList();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode res = al.addTwoNumbers(l1,l2);
        res.printList();
    }

    //----------- prac ------------------

}
