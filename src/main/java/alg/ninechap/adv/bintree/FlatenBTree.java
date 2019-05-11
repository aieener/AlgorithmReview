package alg.ninechap.adv.bintree;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FlatenBTree {
    /**
     * FlatenBTree in preorder traversal
     * LintCode 453
     * Sol1: most straight forward method: non-recur method
     */
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        TreeNode cur = null;

        while (!stack.isEmpty()){
            cur = stack.pollFirst();
            if(cur.right != null) {
                stack.addFirst(cur.right);
            }

            if(cur.left != null) {
                stack.addFirst(cur.left);
            }

            if(stack.isEmpty()) {
                cur.right = null;
            } else {
                cur.right = stack.peekFirst();
            }
            cur.left = null;
        }
        return;
    }

    /**
     * Recursion
     * My version of Sol
     */

    public void flattenII(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root);
        return;
    }

    private TreeNode helper(TreeNode root){
        if(root == null) {
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if(left == null && right == null) {
            return root;
        } else if (left == null) {
            root.right = right;
            root.left = null;
            return root;
        } else if (right == null) {
            root.right = left;
            root.left = null;
            return root;
        }
        // concat left and right
        TreeNode leftTail = getTail(left);
        leftTail.right = right;
        root.right = left;
        root.left = null;
        return root;
    }

    private TreeNode getTail(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }
}

