package NineChap_Adv_binTree_LCode;

import Class_04_BinTree.TreeNode;

public class BinTreeMaxPathSum {
    /**
     * LintCode 94
     * Given a binary tree, find the maximum path sum.
     * The path may start and end at any node in the tree.
     */
    class ResultType{
        // maxPath has at least one edge --> two Nodes --> two side path
        // singlePath can have NO edge --> be a single Node --> one side path
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        ResultType res = helper(root);
        return res.maxPath;
    }

    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        //subProblem
        // 一头扎到底！
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        //recur rule
        int singlePath, maxPath;
        singlePath = Math.max(left.singlePath, right.singlePath) + root.key;
        singlePath = Math.max(0, singlePath);

        maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.key);

        return new ResultType(singlePath, maxPath);
    }

    //------ practice
    class Resulttype{
        int singlePath, maxPath;
        Resulttype(int sin, int max) {
            singlePath = sin;
            maxPath = max;
        }
    }

    public int bTreeMaxPathSum(TreeNode root){
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        Resulttype res = Helper(root);
        return res.maxPath;
    }

    private Resulttype Helper(TreeNode root) {
        if(root == null) {
            return new Resulttype(0, Integer.MIN_VALUE);
        }
        Resulttype left = Helper(root.left);
        Resulttype right  = Helper(root.right);

        int sinPath;
        int maxPath;
        sinPath = Math.max(left.singlePath, right.singlePath) + root.key;
        sinPath = Math.max(0, sinPath);

        maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.key);
        return new Resulttype(sinPath, maxPath);
    }

}
