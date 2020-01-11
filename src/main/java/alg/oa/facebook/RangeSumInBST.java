package alg.oa.facebook;

import alg.laioffer.class5.bintree.TreeNode;

public class RangeSumInBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        // base case
        if (root == null) return 0;
        int leftSum = rangeSumBST(root.left, L, R);
        int rightSum = rangeSumBST(root.right, L, R);

        if (root.key >= L && root.key <= R) {
            return root.key + leftSum + rightSum;
        }
        return leftSum + rightSum;
    }
}
