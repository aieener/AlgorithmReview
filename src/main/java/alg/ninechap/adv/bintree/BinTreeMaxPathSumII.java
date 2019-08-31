package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

public class BinTreeMaxPathSumII {
    /**
     * LintCode 475
     * Given a binary tree, find the maximum path sum from root.
     * The path may end at any node in the tree and contain at
     * least one node in it. so can be a singlePath
     */
    public int maxPathSum2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(0, Math.max(left, right)) + root.key;
    }
}
