package Vmware;

import Class_03_LL.ListNode;

/**
 * Created by yuding on 1/20/18.
 * This is LeetCode 328
 */
public class OddEvenListII {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);
        ListNode evenTail = evenDummy;
        ListNode oddTail = oddDummy;
        ListNode cur = head;
        int idx = 1;
        while(cur != null){
            if(isOdd(idx)){
                oddTail.next = cur;
                oddTail = oddTail.next;
            } else {
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            cur = cur.next;
            idx++;
        }

        // concat the two List
        oddTail.next = evenDummy.next;
        evenTail.next = null;
        return oddDummy.next;
    }
    private boolean isOdd(int idx) {
        if(idx % 2 != 0) {
            return true;
        }
        return false;
    }
}
