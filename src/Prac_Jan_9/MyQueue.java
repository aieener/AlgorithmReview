package Prac_Jan_9;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * Using ListNode implement queue
 * Not really nee the doubly linked List!
 * Add a single tail node would be fine
 */

public class MyQueue {
    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;

    // tail in head out or head in tail out ? I think both works

    // Here we pick add to tail
    public void offer( Integer a) {
        if(head == null) {
            head = new ListNode(a);
            tail = head;
        } else {
            ListNode newTail = new ListNode(a);
            tail.next = newTail;
            tail = tail.next;
        }

        size++;
    }

    //忘记maintain tail了..
    public Integer poll() {
        if(head == null) {
            return null;
        }
        Integer res = head.value;
        head = head.next;

        //----------------
        if(head == null) {
            tail = null;
        }
        //----------------

        size--;
        return res;
    }

    public Integer size() {
        return size;
    }

    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
