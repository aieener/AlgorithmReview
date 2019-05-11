package alg.laioffer.class10.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

/**
 * Created by yuding on 2/2/18.
 */
public class LCALai {
    public TreeNode lowestCommonAncestor(TreeNode root,
            TreeNode one, TreeNode two) {
        // Write your solution here
        if(root == null || one == root || two == root) {
            return root;
        }

        TreeNode left =  lowestCommonAncestor(root.left, one, two);
        TreeNode right =  lowestCommonAncestor(root.right, one, two);

        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }
}
