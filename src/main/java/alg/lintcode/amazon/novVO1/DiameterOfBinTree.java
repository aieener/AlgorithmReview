package alg.lintcode.amazon.novVO1;

import alg.laioffer.class5.bintree.TreeNode;

/*
lintcode 1181
 */
public class DiameterOfBinTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{0};
        recur(root, res);
        return res[0] - 1;
    }

    // returns the maxLenFrom leaf to node
    private int recur(TreeNode node, int[] res) {
        // base case
        if (node == null) return 0;
        int left = recur(node.left, res);
        int right = recur(node.right, res);
        res[0] = Math.max(res[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
