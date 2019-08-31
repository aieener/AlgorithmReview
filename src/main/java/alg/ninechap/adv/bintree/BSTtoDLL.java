package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class DoublyListNode {
   int val;
   DoublyListNode next, prev;

   DoublyListNode(int val){
      this.val = val;
      this.next = this.prev = null;
   }
}

public class BSTtoDLL {
    /**
     * My Sol: recursive method
     * LintCode 378
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(root.key);
        // reach leaf
        if(root.left == null && root.right == null) {
            return head;
        }

        // subProblem
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right);

        // recur rule
        if(left != null && right != null) {
            DoublyListNode leftTail = getTail(left);
            leftTail.next = head;
            head.prev = leftTail;
            head.next = right;
            right.prev = head;
            return left;
        } else if (left == null) {
            head.next = right;
            right.prev = head;
            return head;
        } else {
            DoublyListNode leftTail = getTail(left);
            leftTail.next = head;
            head.prev = leftTail;
            return left;
        }
    }

    private DoublyListNode getTail(DoublyListNode head) {
        while(head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    //----------------- stack version without using recur
    public DoublyListNode bstToDoublyList2(TreeNode root) {
        if(root == null) {
            return null;
        }
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode curNode = dummy;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            DoublyListNode nextNode = new DoublyListNode(cur.key);
            curNode.next = nextNode;
            nextNode.prev = curNode;
            curNode = nextNode;

            cur = cur.right;
        }
        return dummy.next;
    }
}
