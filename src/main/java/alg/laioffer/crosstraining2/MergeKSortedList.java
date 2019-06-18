package alg.laioffer.crosstraining2;

import alg.laioffer.class3.linkedlist.stack.queue.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
  /**
   * this one is basically exact like mergeKSortedArray
   * just use LL, remeber dummyNode trick
   */
  public ListNode merge(List<ListNode> listOfLists) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if(o1.value == o2.value) return 0;
        return o1.value < o2.value ? -1 : 1;
      }
    });
    for(ListNode node : listOfLists) {
      if(node != null) {
        minHeap.offer(node);
      }
    }

    while(!minHeap.isEmpty()) {
      ListNode target = minHeap.poll();
      cur.next = target;
      if(target.next!= null) {
        minHeap.offer(target.next);
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
