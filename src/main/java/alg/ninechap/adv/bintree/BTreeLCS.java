package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

public class BTreeLCS {
    /**
     * Binary Tree Longest Consecutive Sequence
     * Debug and check the call stack! 打擂台 to understand this problem better
     */
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lenWithoutRoot) {
        if(root == null) {
            return 0;
        }

        int len = 1;
        if(parent != null && parent.key + 1 == root.key) {
            len = 1 + lenWithoutRoot;
        }
        // 一路扎到左路底
        int left = helper(root.left, root, len);
        // 一路扎到right bottom
        int right  = helper(root.right, root, len);

        // len is the val if root is connects to it's children
        // left is the LCS on the left branch
        // right is the LCS on the right branch
        // 打擂台
        return Math.max(len, Math.max(left, right));
    }



    // --- Other accepted solution by me
    public int globalMax = 0;
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        helper(root);
        return globalMax;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // subProb
        int len = 1;
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        if(root.left != null && root.left.key - 1 == root.key) {
            len = Math.max(len, leftMax + 1);
        }
        if(root.right != null && root.right.key - 1 == root.key) {
            len = Math.max(len, rightMax + 1);
        }
        globalMax = Math.max(len, globalMax);
        return len;
    }
    // --------
    public static void main(String[] args) {
        BTreeLCS bt = new BTreeLCS();
        /**
         *  1
         *   \
         *    3
         *   / \
         *  2  4
         *      \
         *       5
         */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(bt.longestConsecutive(root));
    }
}
