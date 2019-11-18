package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.AddTwoNumbers;
import alg.laioffer.class4.linkedlist.ListNode;

public class AddTwoNumbersImpl implements AddTwoNumbers {
  public static void main(String[] args) {
    ListNode first = new ListNode(9);
    first.next = new ListNode(9);
    first.next.next = new ListNode(9);
    first.next.next.next = new ListNode(9);

    ListNode second = new ListNode(1);
    second.next = new ListNode(1);
    AddTwoNumbers engine = new AddTwoNumbersImpl();
    engine.addTwoNumbers(first, second);
  }

  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = carry + l1.value + l2.value;
      int curVal = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(curVal);
      l1 = l1.next;
      l2 = l2.next;
      cur = cur.next;
    }
    if (carry != 0) {
      if (l1 != null) {
        cur.next = addTwoNumbers(l1, new ListNode(1));
      } else if (l2 != null) {
        cur.next = addTwoNumbers(l2, new ListNode(1));
      } else {
        cur.next = new ListNode(1);
      }
    } else {
      if (l1 != null) {
        cur.next = l1;
      } else if (l2 != null) {
        cur.next = l2;
      }
    }
    return dummy.next;
  }
}
