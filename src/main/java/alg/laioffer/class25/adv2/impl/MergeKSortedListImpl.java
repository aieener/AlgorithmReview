package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.MergeKSortedList;
import alg.laioffer.class4.linkedlist.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListImpl implements MergeKSortedList {
    @Override
    public ListNode merge(List<ListNode> listOfLists) {
        ListNode dummy = new ListNode(0);
        if (listOfLists == null || listOfLists.size() == 0) return dummy.next;
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode base, ListNode other) {
                return base.value - other.value;
            }
        });

        // plant seed
        for (ListNode head : listOfLists) {
            minHeap.offer(head);
        }

        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode toExpand = minHeap.poll();
            if (toExpand.next != null) {
                // generate
                minHeap.offer(toExpand.next);
            }
            cur.next = toExpand;
            cur = cur.next;
        }
        return dummy.next;
    }
}
