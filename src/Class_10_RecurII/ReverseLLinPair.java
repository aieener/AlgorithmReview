package Class_10_RecurII;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * Created by yuding on 2/1/18.
 * Class 14 Recurr + LinkedList
 */
public class ReverseLLinPair {
    public ListNode reverseInPairs(ListNode head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }
        // subProblem: the sequence Matters! it take this line done,
        // will have stack over flow problem!!!
        ListNode headOfRest = reverseInPairs(head.next.next);
        // recur Rule
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = headOfRest;
        return newHead;
    }
}
