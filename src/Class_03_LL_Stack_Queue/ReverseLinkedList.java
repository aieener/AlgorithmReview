package Class_03_LL_Stack_Queue;


public class ReverseLinkedList {
  public ListNode reverseIter(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;
    while(cur.next != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return cur;
  }

  public ListNode reverseRecur(ListNode head) {
    if (head == null || head.next == null) return head;
    return recur(head, null);
  }

  private ListNode recur(ListNode cur, ListNode prev) {
    // base case
    if(cur == null) {
      return prev;
    }
    // recurRule
    ListNode next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
    return recur(cur, prev);
  }


  public static void main(String[] args) {
    ReverseLinkedList r1 = new ReverseLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

  }
}
