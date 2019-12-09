package alg.laioffer.class3.stackqueue;

public interface DequeByThreeStacks {
    void offerFirst(int element);

    void offerLast(int element);

    Integer pollFirst();

    Integer pollLast();

    Integer peekFirst();

    Integer peekLast();

    int size();

    boolean isEmpty();
}
