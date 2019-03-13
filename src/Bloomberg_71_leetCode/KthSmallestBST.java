package Bloomberg_71_leetCode;

import Class_04_BinTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuding on 2/15/18.
 * LeetCode 230
 * inorder traverse --> sorted
 */
public class KthSmallestBST {
    /**
     * Iter sol
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        int res = root.key;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.pollFirst();
                k--;
                if(k == 0) {
                    res = curr.key;
                    break;
                }
                curr = curr.right;
            }
        }
        return res;
    }

    /**
     * recur Sol
     */

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        helper(inorder, root);
        return inorder.get(k);
    }

    private void helper(List<Integer> inorder, TreeNode root) {
        // base case
        if(root == null) {
            return;
        }
        helper(inorder, root.left);
        inorder.add(root.key);
        helper(inorder, root.right);
    }

    //---- prac ----



}
