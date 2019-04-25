package Class_03_LL_Stack_Queue;

public class InsertinSLL {
  // Cation the trap!
  // 操作任何数据结构， 一定注意一头一尾corner case！

  // Notice, in java is do void, we are losing the HEAD!
  // This is no like C++!!!
  public ListNode insert(ListNode head, int value) {
    if (head == null) {
      return new ListNode(value);
    }

    // find the place to insert
    ListNode placeToInsert = findPlaceToInsert(head, value);
    // do insert
    ListNode newNodeToInsert = new ListNode(value);
    if (placeToInsert == null) {
      newNodeToInsert.next = head;
      return newNodeToInsert;
    } else {
      newNodeToInsert.next = placeToInsert.next;
      placeToInsert.next = newNodeToInsert;
      return head;
    }
  }

  private ListNode findPlaceToInsert(ListNode head, int value) {
    ListNode cur = head;
    ListNode res = null;
    while (cur != null && cur.value < value) {
      res = cur;
      cur = cur.next;
    }
    return res;
  }

  public static void main(String[] args) {
    InsertinSLL il = new InsertinSLL();
    ListNode head = new ListNode(1);
    il.insert(head, 3);
    head.printList();
  }
  //---- prac ----
}
