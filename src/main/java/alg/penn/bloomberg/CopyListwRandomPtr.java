package alg.penn.bloomberg;

import java.util.*;

/**
 * Created by yuding on 2/8/18.
 * LeetCode 138
 * Using HashMap
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {this.label = x;}
}

public class CopyListwRandomPtr {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }

        RandomListNode dummmy = new RandomListNode(0);
        RandomListNode preNode = dummmy;
        RandomListNode newNode;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // this map: oriNode -> newNode

        RandomListNode curr = head;

        while(curr != null) {
            if(map.containsKey(curr)) {
                newNode = map.get(curr);
            } else {
                newNode = new RandomListNode(curr.label);
                map.put(curr, newNode);
            }
            preNode.next = newNode;

            if(curr.random != null) {
                if(map.containsKey(curr.random)) {
                    newNode.random = map.get(curr.random);
                } else {
                    newNode.random = new RandomListNode(curr.random.label);
                    map.put(curr.random, newNode.random);
                }
            }
            preNode = preNode.next;
            curr = curr.next;
        }
        return dummmy.next;
    }

    /**
     * Sol 2 without HashMap: copyNext, copyRandom, split it back
     */

    public RandomListNode copyRandomListNoHash(RandomListNode head){
        if(head == null){
            return head;
        }
        copyNext(head); // 1->2->3 ===> 1->1'->2->2'->3->3'
        copyRandom(head);
        return split(head);
    }

    private void copyNext(RandomListNode head){
        while(head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while(head != null) {
            // move even idx item's random to its next
            if(head.next.random != null) {
                head.next.random = head.next.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode split(RandomListNode head) {
        // 1->2->3 ===> 1->1'->2->2'->3->3'
        RandomListNode newHead = head.next;
        RandomListNode curr = head;
        while(curr != null) {
            RandomListNode cpyNode = curr.next;
            curr.next =cpyNode.next;
            curr = curr.next;
            if(cpyNode.next != null) {
                cpyNode.next = cpyNode.next.next;
            }
        }
        return newHead;
    }

    //-------------- prac --------------
    public RandomListNode copyRandomList3(RandomListNode head) {
        if(head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // do the copy in one run
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        RandomListNode curr = head;

        while(curr!= null) {
            RandomListNode curCpy = map.getOrDefault( curr , new RandomListNode(curr.label));
            map.putIfAbsent(curr, curCpy);
            tail.next = curCpy;

            if (curr.random != null) {
                RandomListNode curRand = map.getOrDefault( curr.random , new RandomListNode(curr.random.label));
                map.putIfAbsent(curr.random, curRand);
                tail.next.random = curRand;

            }

            tail = tail.next;
            curr = curr.next;
        }
        return dummy.next;

    }
}
