package alg.laioffer.class3.linkedlist.stack.queue;

public class PartitionLL {
  // Amazon 常出 keep the origin relative order
  public ListNode partition(ListNode head, int target) {
    // split the list to two, then cancat it
    ListNode smallerDummy = new ListNode(0);
    ListNode smaller = smallerDummy;
    ListNode biggerDummy = new ListNode(0);
    ListNode bigger = biggerDummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.value <= target) {
        smaller.next = cur;
        smaller = cur;
      } else {
        bigger.next = cur;
        bigger = cur;
      }
      cur = cur.next;
    }
    // concat
    if (smaller != null) {
      smaller.next = biggerDummy.next;
    }
    return smallerDummy.next;
  }


  public static void main(String[] args) {
    PartitionLL pll = new PartitionLL();

    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(1);
  }
}
