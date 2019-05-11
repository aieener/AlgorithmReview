package alg.laioffer.prac.jan9;

/**
 * Using ListNode to implement Stack
 * 从最底层来实现
 * Assume stack store Integer only, we will revisit this once coverd generics
 * LaiOffer Practise class 9
 */
public class MyStack {

    private static class ListNode{
        /**
         * Good Code style
         * static inner class 不依附于 outsider class
         * one can instantiated obj for innerclass without outer class
         */
        public int value;
        public ListNode next;
        public ListNode(int value){
            this.value = value;
            next = null;
        }
    }

    private ListNode head;
    private int size = 0;

    public MyStack() {
    }

    // methods
    public void push(Integer a){
        // push at the front, if put at end one need doubly linked list!
        ListNode newHead = new ListNode(a);
        newHead.next = head;
        head = newHead;
        size++;
    }

    // 返回Integer instead of int cause if there is nothing, we can return null
    public Integer pop() {
        if(head != null){
            head = head.next;
            size--;
            return head.value;
        }
        return null;
    }

    public Integer peek() {
        if(head != null) {
            return head.value;
        }
        return null;
    }

    public Integer size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }
}
