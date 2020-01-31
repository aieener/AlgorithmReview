package alg.audible.impl;

import alg.audible.ConvertSortedListToBST;
import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class5.bintree.TreeNode;

public class ConvertSortedListToBSTImpl implements ConvertSortedListToBST {
    @Override
    public TreeNode sortedListToBST(ListNode head) {
        // base case
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.value);
        ListNode middlePrev = findMiddlePrev(head);
        ListNode mid = middlePrev.next;
        ListNode next = mid.next;
        TreeNode root = new TreeNode(mid.value);
        middlePrev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(next);
        return root;
    }

    private ListNode findMiddlePrev(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // this will make the res to be middlePrev, if want middle, then let fast = head
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
