package alg.penn.bloomberg;

import alg.laioffer.class5.bintree.TreeNode;

/**
 * Created by yuding on 2/11/18.
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode root, int lower, int upper){
        // base case
        if(root == null) {
            return true;
        }

        // recur rule
        if(root.key <= lower || root.key >= upper) {
            return false;
        }
        // subProb
        return helper(root.left, lower,root.key) &&
                helper(root.right, root.key, upper);
    }

    //-----------------prac--------------
    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper2(root, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    private boolean helper2(TreeNode root, int left_bound, int right_bound) {
        if(root == null) {
            return true;
        }
        // recur rule
        if(root.key <= left_bound || root.key >= right_bound) {
            return false;
        }
        //sub prob
        return helper(root.left , left_bound, root.key) &&
                helper(root.right, root.key, right_bound);
    }
}
