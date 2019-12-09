package alg.laioffer.class4.linkedlist.impl;

import alg.laioffer.class4.linkedlist.AddTwoNumbers;
import alg.laioffer.class4.linkedlist.ListNode;

public class AddTwoNumbersImpl implements AddTwoNumbers {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int l1Len = getLen(l1);
      int l2Len = getLen(l2);
      ListNode shorter = l1Len < l2Len ? l1 : l2;
      ListNode longer = shorter == l1 ? l2 : l1;

      int delta = Math.abs(l1Len - l2Len);
      ListNode dummy = new ListNode(0);
      ListNode runner = dummy;
      int carry = 0;
      while(longer != null) {
          int shorterVal = shorter != null ? shorter.value : 0;
          int curVal = shorterVal + longer.value + carry;

          if(curVal >= 10) {
              carry = curVal / 10;
              curVal = curVal % 10;
          } else {
              carry = 0;
          }
          runner.next = new ListNode(curVal);
          longer = longer.next;
          if(shorter != null) {
              shorter = shorter.next;
          }
          runner = runner.next;
      }

      if(carry != 0) {
          runner.next = new ListNode(carry);
      }

      return dummy.next;
  }

  private int getLen(ListNode node) {
      int len = 0;
      while(node != null) {
          node =node.next;
          len++;
      }
      return len;
  }
}
