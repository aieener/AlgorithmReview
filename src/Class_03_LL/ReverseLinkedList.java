package Class_03_LL;

import java.util.List;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head){
        // iterative version
        if(head == null){
            return head;
        }
        ListNode currNode = head;
        ListNode preNode = null;
        ListNode nextNode;

        while(currNode != null){
            // at each iter, only change two next ptr
            // the prev.ptr and cur.ptr and leave next alone!
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    public ListNode reverseRecurr(ListNode head) {
        // 触底反弹，DFS
        // review Class04 , three layer diagram
        // base case
        if(head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseRecurr(nextNode);

        nextNode.next = head;
        // if without head.next = null ===> there will be a CYCLE!!
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        ReverseLinkedList r1 = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);


        ListNode res = r1.reverse(head);
//        ListNode res = r1.reverse2(head);
//        ListNode res = r1.reverse1(head);
        res.printList();
    }

    // ---- prac ----
}
