package alg.laioffer.crosstraining2;

import java.util.HashMap;

public class DeepCpyLLWithRandNum {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) return null;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode curCpy = dummy;

    HashMap<RandomListNode, RandomListNode> oriToCpyLookUp = new HashMap<>();
    while (head != null) {
      // cpy next
      if (!oriToCpyLookUp.containsKey(head)) {
        oriToCpyLookUp.put(head, new RandomListNode(head.value));
      }
      curCpy.next = oriToCpyLookUp.get(head);
      // cpy random
      if (head.random != null) {
        if (!oriToCpyLookUp.containsKey(head.random)) {
          oriToCpyLookUp.put(head.random, new RandomListNode(head.random.value));
        }
        curCpy.next.random = oriToCpyLookUp.get(head.random);
      }

      head = head.next;
      curCpy = curCpy.next;
    }

    return dummy.next;
  }

  class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
      this.value = value;
    }
  }
}
