package alg.penn.vmware;

import alg.laioffer.class4.linkedlist.ListNode;

/**
 * Created by yuding on 1/20/18.
 * This one is similar to LeetCode 328
 * but it is taking the node values
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);
        ListNode evenTail = evenDummy;
        ListNode oddTail = oddDummy;
        ListNode cur = head;
        while(cur != null){
            if(isOdd(cur)){
                oddTail.next = cur;
                oddTail = oddTail.next;
            } else {
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            cur = cur.next;
        }

        // concat the two List
        oddTail.next = evenDummy.next;
        evenTail.next = null;
        return oddDummy.next;
    }
    private boolean isOdd(ListNode node) {
        if(node.value % 2 != 0) {
            return true;
        }
        return false;
    }
}
