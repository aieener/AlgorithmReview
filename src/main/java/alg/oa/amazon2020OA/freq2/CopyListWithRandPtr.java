package alg.oa.amazon2020OA.freq2;

import alg.laioffer.class25.adv2.DeepCpyLLWithRandPtr;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandPtr {
    public DeepCpyLLWithRandPtr.RandomListNode copy(DeepCpyLLWithRandPtr.RandomListNode head) {
        if (head == null) return null;
        Map<DeepCpyLLWithRandPtr.RandomListNode, DeepCpyLLWithRandPtr.RandomListNode> lkup = new HashMap<>();
        DeepCpyLLWithRandPtr.RandomListNode dummy = new DeepCpyLLWithRandPtr.RandomListNode(0);
        DeepCpyLLWithRandPtr.RandomListNode cpy = dummy;

        while (head != null) {
            if (!lkup.containsKey(head)) {
                lkup.put(head, new DeepCpyLLWithRandPtr.RandomListNode(head.value));
            }
            cpy.next = lkup.get(head);
            cpy = cpy.next;
            if (head.random != null) {
                if (!lkup.containsKey(head.random)) {
                    lkup.put(head.random, new DeepCpyLLWithRandPtr.RandomListNode(head.random.value));
                }
                cpy.random = lkup.get(head.random);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
