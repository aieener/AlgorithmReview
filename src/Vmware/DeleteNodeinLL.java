package Vmware;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * Created by yuding on 1/20/18.
 */
public class DeleteNodeinLL {
    public ListNode delete(ListNode head) {
        if(head == null ){
            return head;
        }
        ListNode tail = head;
        ListNode prev = null;
        ListNode newHead = head;
        while(tail != null) {
            if(isOddNode(tail)){
                tail = tail.next;
                if(prev != null){
                    prev.next = tail;
                } else {
                    newHead = tail;
                }
            } else {
                prev = tail;
                tail = tail.next;
            }

        }
        return newHead;
    }

    private boolean isOddNode(ListNode node) {
        if (node.value % 2 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DeleteNodeinLL dl = new DeleteNodeinLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode newHead = dl.delete(head);
//        System.out.print(newHead);
        newHead.printList();
    }
}

