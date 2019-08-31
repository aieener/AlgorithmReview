package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

public class MinDepthofBTree {
    public int minDepth(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }

        // subProblem
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //--------------------------
        // Remember to check if left and right equal to null!!!
        if(root.left == null){
            return right + 1;
        }
        if(root.right == null) {
            return left + 1;
        }
        //--------------------------
        return Math.min(left, right) + 1;
    }
}
