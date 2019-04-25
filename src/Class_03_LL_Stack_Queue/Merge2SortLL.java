package Class_03_LL_Stack_Queue;

public class Merge2SortLL {
  public ListNode merge(ListNode one, ListNode two) {
    if (one == null) return two;
    if (two == null) return one;

    ListNode dummy = new ListNode(0); // don't lose the head!
    ListNode cur = dummy;
    while (one != null && two != null) {
      if (one.value < two.value) {
        cur.next = one;
        cur = one;
        one = one.next;
      } else {
        cur.next = two;
        cur = two;
        two = two.next;
      }
    }
    if(one != null) {
      cur.next = one;
    } else if(two != null) {
      cur.next = two;
    }

    return dummy.next;
  }
}
