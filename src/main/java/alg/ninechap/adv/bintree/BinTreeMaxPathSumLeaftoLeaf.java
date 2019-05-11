package alg.ninechap.adv.bintree;

import alg.laioffer.class4.bintree.TreeNode;


public class BinTreeMaxPathSumLeaftoLeaf {
    /**
     * MySol
     */
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        // subProb
        PathSum(root);
        return globalMax;
    }

    private int PathSum(TreeNode node){
        // this function finds the max path from node to leaf
        //base case
        if(node.left == null && node.right == null) {
            return node.key;
        }

        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(node.left != null) {
            left = PathSum(node.left);
        }
        if(node.right != null) {
            right = PathSum(node.right);
        }
        if(node.left != null && node.right != null) {
            globalMax =  Math.max(globalMax, left + right + node.key);
        }
        return Math.max(left , right) + node.key;
    }

    /**
     * LaiOfferSol
     */

    public int maxPathSum2(TreeNode root) {
        int [] max = new int[] {Integer.MIN_VALUE};
        maxSumHelper(root, max);
        return max[0];
    }
    private int maxSumHelper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = maxSumHelper(root.left ,max);
        int right = maxSumHelper(root.right ,max);

        if(root.left != null && root.right != null) {
            max[0] = Math.max(max[0] , left + right + root.key);
            return Math.max(left, right) + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }

    public static void main(String[] args) {
        BinTreeMaxPathSumLeaftoLeaf bl = new BinTreeMaxPathSumLeaftoLeaf();
//        TreeNode root = new TreeNode(-15);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(11);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(14);

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-6);
        root.left.left = new TreeNode(-3);
        root.left.right = new TreeNode(-4);
        root.left.left.left = new TreeNode(-7);
        root.left.right.left = new TreeNode(-5);


//        int max = bl.maxPathSum(root);
        int max = bl.maxPathSum2(root);
        System.out.println(max);

    }
}
