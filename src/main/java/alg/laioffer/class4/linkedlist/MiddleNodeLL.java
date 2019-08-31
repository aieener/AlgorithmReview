package alg.laioffer.class4.linkedlist;

public class MiddleNodeLL {
  // pay attention about odd and even case
  // Even case:
  // which one is better to stop at? n1->n2->n3->n4->n5->n6->NULL
  // n3 or n4?
  // n3 is better singly linked list,
  // because at n3, we could easily get n4!
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
