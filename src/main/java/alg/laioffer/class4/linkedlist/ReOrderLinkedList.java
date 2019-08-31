package alg.laioffer.class4.linkedlist;

public class ReOrderLinkedList {
  public ListNode reorder(ListNode head) {
    if (head == null) {
      return head;
    }
    // first split the List into two
    ListNode midNode = findMid(head);

    ListNode first = head;
    ListNode second = midNode.next;
    midNode.next = null;
    // merge the two list
    // reverse the second
    second = reverse(second);

    // 1 -> 2 -> 3 -> 4
    // a -> b -> c
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (first != null && second != null) {
      tail.next = first;
      first = first.next;
      tail.next.next = second;
      second = second.next;
      tail = tail.next.next;
    }

    if(first != null) {
      tail.next = first;
    } else {
      tail.next = second;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }


  public static void main(String[] args) {
    ReOrderLinkedList rll = new ReOrderLinkedList();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);

    ListNode res = rll.reorder(head);
    res.printList();
  }
}
