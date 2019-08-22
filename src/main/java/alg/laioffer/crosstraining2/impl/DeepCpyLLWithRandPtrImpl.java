package alg.laioffer.crosstraining2.impl;

import alg.laioffer.crosstraining2.DeepCpyLLWithRandPtr;

import java.util.HashMap;
import java.util.Map;

public class DeepCpyLLWithRandPtrImpl implements DeepCpyLLWithRandPtr {
  @Override
  public RandomListNode copy(RandomListNode head) {
    if(head == null) return null;
    Map<RandomListNode, RandomListNode> lkup = new HashMap<>();
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cpy = dummy;

    while (head != null) {
      if (!lkup.containsKey(head)) {
        lkup.put(head, new RandomListNode(head.value));
      }
      cpy.next = lkup.get(head);
      cpy = cpy.next;
      if(head.random != null) {
        if (!lkup.containsKey(head.random)) {
          lkup.put(head.random, new RandomListNode(head.random.value));
        }
        cpy.random = lkup.get(head.random);
      }
      head = head.next;
    }
    return dummy.next;
  }
}
