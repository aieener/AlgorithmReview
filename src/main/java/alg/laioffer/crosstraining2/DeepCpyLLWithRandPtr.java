package alg.laioffer.crosstraining2;

public interface DeepCpyLLWithRandPtr {
  class RandomListNode{
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
  }

  public RandomListNode copy (RandomListNode head);
}
