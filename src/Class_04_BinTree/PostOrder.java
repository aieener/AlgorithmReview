package Class_04_BinTree;

import java.util.*;

public class PostOrder {
    public List<Integer> postOrder(TreeNode root) {
        // LaiOffer version

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return res;
        }
        stack.offerFirst(root);

        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();

            if (prev == null || curr == prev.left || curr == prev.right) {
                // try to go down
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    // can't go further, add leaf
                    stack.pollFirst();
                    res.add(curr.key);
                }
            } else if (prev == curr.right || prev == curr.left && curr.right == null) {
                // if we going up from the right or left, but can't go to right afterwards
                stack.pollFirst();
                res.add(curr.key);
            } else {
                stack.offerFirst(curr.right);
            }
            prev = curr;
        }

        return res;
    }


    public List<Integer> postOrderV2(TreeNode root) {
        // Space O(n) bad
        // not real time

        // pre-order: cen ; left ; right
        // post-order: left ; right ; cen
        //-----------------------
        // pre-order with left right switch: cen; right ; left ;
        // reverse this switch pre-order: left ; right ; cen

        // Post order is the REVERSE version of the pre-order with
        // traverse right subtree before traverse left subtree
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root) ;
        while (!stack.isEmpty()){
            TreeNode curr = stack.pollFirst();
            res.add(curr.key);

            if(curr.left != null) {
                stack.offerFirst(curr.left);
            }

            if(curr.right != null) {
                stack.offerFirst(curr.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    // 九章 version
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek(); // 一直要到最后取值了才pop！！
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                // 要么root, 要么在左， 要么在右;
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                // 左边到底了左上回中看右下有没有节点
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                // 到”底“了 取数 pop stack
                result.add(curr.key);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }

    //---- prac ----
    public List<Integer> postOrder2 (TreeNode root) {
        // postorder: left right cen --reverse--> cen left right -->like preorder
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return res;
        }
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            res.add(cur.key);
            if(cur.left != null) {
                stack.addFirst(cur.left);
            }
            if(cur.right != null) {
                stack.addFirst(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
