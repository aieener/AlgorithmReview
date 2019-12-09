package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.ListNode;
import alg.laioffer.class4.linkedlist.PartitionLL;

public class PartitionLLImpl implements PartitionLL {
    @Override
    public ListNode partition(ListNode head, int target) {
        if(head == null || head.next == null) return head;
        ListNode lessPartitionDummy = new ListNode(0);
        ListNode biggerPartitionDummy = new ListNode(0);
        ListNode lessRunner = lessPartitionDummy;
        ListNode biggerRunner = biggerPartitionDummy;
        while(head != null) {
            if(head.value < target) {
                lessRunner.next = head;
                lessRunner = lessRunner.next;
            } else {
                biggerRunner.next = head;
                biggerRunner = biggerRunner.next;
            }
            head = head.next;
        }
        lessRunner.next = biggerPartitionDummy.next;
        biggerRunner.next = null;
        return lessPartitionDummy.next;
    }
}
