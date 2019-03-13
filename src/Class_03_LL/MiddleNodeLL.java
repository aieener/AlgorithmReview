package Class_03_LL;

public class MiddleNodeLL {
    public ListNode middleNode(ListNode head){
        // pay attention about odd and even case
        // Even case:
        // which one is better to stop at? n1->n2->n3->n4->n5->n6->NULL
        // n3 or n4?
        // n3 is better singly linked list,
        // because at n3, we could easily get n4!


        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        // inorder to stop at n3, stop at fast.next.next == null

        // Note:
        // There would be a trouble if one take out fast.next
        // n1->n2->n3
        // after first step, fast at n3, n3.next.next ==> NPE error!!!

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
