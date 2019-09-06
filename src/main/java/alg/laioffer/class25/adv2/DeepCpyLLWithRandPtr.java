package alg.laioffer.class25.adv2;


public interface DeepCpyLLWithRandPtr {
  RandomListNode copy(RandomListNode head);

  class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
      this.value = value;
    }
  }
}
