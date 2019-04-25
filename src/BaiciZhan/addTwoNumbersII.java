package BaiciZhan;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * Feb 20
 * Created by yuding on 2/8/18.
 * LeetCode 445
 * Sol1 : reversing Lists, then use the same way as LeetCode 2
 * reversing lists is not allowed
 */
public class addTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr1 = reverse(l1);
        ListNode lr2 = reverse(l2);

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(lr1 != null && lr2 != null) {
            int curDig = ( carry + lr1.value + lr2.value) % 10;
            carry = ( carry + lr1.value + lr2.value) /10;
            tail.next = new ListNode(curDig);

            lr1 = lr1.next;
            lr2 = lr2.next;
            tail = tail.next;
        }

        while(lr1 != null) {
            int curDig = (carry + lr1.value) % 10;
            carry = (carry + lr1.value) / 10;
            tail.next = new ListNode(curDig);

            lr1 = lr1.next;
            tail = tail.next;
        }

        while(lr2 != null) {
            int curDig = (carry + lr2.value) % 10;
            carry = (carry + lr2.value) / 10;
            tail.next = new ListNode(curDig);

            lr2 = lr2.next;
            tail = tail.next;
        }

        if(carry != 0) {
            tail.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {

        if(head == null || head.next == null ) {
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

    // ------------------ prac ----------------
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse2(l1);
        l2 = reverse2(l2);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;


        int carray = 0;
        while(l1 != null && l2 != null) {
            int curDig = (l1.value + l2.value + carray) % 10;
            carray = (l1.value + l2.value + carray) / 10;
            tail.next = new ListNode(curDig);

            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }

        while( l1 != null) {
            int curDig = (l1.value + carray) % 10;
            carray = (l1.value  + carray) / 10;
            tail.next = new ListNode(curDig);

            l1 = l1.next;
            tail = tail.next;
        }

        while(l2 != null) {
            int curDig = (l2.value + carray) % 10;
            carray = (l2.value + carray) / 10;
            tail.next = new ListNode(curDig);

            l2 = l2.next;
            tail = tail.next;
        }

        if(carray != 0) {
            tail.next = new ListNode(carray);
        }

        return reverse(dummy.next);
    }
    private ListNode reverse2 (ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode curr = node;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

}
