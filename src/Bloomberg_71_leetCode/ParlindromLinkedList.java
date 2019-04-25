package Bloomberg_71_leetCode;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * Created by yuding on 2/18/18.
 * LeetCode 234
 * find Middle,
 * reverse the part after Middle
 * then 2 ptr compare
 */
public class ParlindromLinkedList {
    public boolean isParlindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode secHalf = reverse(middle.next);

        while(secHalf != null && head != middle.next) {
            if(secHalf.value != head.value) {
                return false;
            }
            secHalf = secHalf.next;
            head= head.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ParlindromLinkedList pl = new ParlindromLinkedList();
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(0);
        System.out.print(pl.isParlindrome( head ));
    }

    //---------- prac ------------
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMiddle2(head);
        ListNode l2 = reverse2(mid.next);

        while(head != mid.next && l2 != null) {
            if(head.value != l2.value) {
                return false;
            }
        }
        return true;
    }

    private ListNode findMiddle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev= null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next  = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
