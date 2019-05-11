package alg.ninechap.adv.bintree;

import alg.laioffer.class4.bintree.TreeNode;

/***
 * using global variable
 * LintCode 596
 */
public class MinimumSubtree {

    int minSum = Integer.MAX_VALUE;
    TreeNode minNode = null;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if(root == null){
            return root;
        }
        findMin(root);
        return minNode;
    }

    private int findMin(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = findMin(root.left);
        int right = findMin(root.right);
        int sum = root.key + left + right;

        if(sum < minSum) {
            minNode = root;
            minSum = sum;
        }
        return sum;
    }
}
