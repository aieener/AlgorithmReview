package alg.laioffer.class4.linkedlist;
/*
  input N1 -> N2 -> N3 -> ...
  output N1 -> Nn -> N2 -> Nn-1 -> ....
 */
public interface ReorderLL {
    ListNode reorder(ListNode head);
}
