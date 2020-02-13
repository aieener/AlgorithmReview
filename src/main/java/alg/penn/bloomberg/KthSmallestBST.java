package alg.penn.bloomberg;

import alg.laioffer.class5.bintree.TreeNode;

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
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        int res = root.key;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.pollFirst();
                k--;
                if (k == 0) {
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

    public int kthSmallestRecur(TreeNode root, int k) {
        int[] res = new int[1];
        inorder(root, new int[]{k}, res);
        return res[0];
    }

    private void inorder(TreeNode root, int[] k, int[] res) {
        if (root == null) return;
        inorder(root.left, k, res);
        k[0]--;
        if (k[0] == 0) {
            res[0] = root.key;
            return;
        }
        inorder(root.right, k, res);
    }

    //---- prac ----


}
