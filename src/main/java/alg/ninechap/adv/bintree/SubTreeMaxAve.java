package alg.ninechap.adv.bintree;

import alg.laioffer.class4.bintree.TreeNode;

public class SubTreeMaxAve {
    ResultType res = new ResultType(Integer.MAX_VALUE, 0, null);

    class ResultType{
        int sum;
        int numOfNodes;
        TreeNode node;
        ResultType(int sum, int numOfNodes, TreeNode node) {
            this.sum = sum ;
            this.numOfNodes = numOfNodes;
            this.node = node;
        }
    }

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if(root == null) {
            return root;
        }
        helper(root);
        return res.node;
    }

    private ResultType helper (TreeNode node) {
        if(node == null) {
            return new ResultType(0,0, null);
        }

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);

        int num = left.numOfNodes + right.numOfNodes + 1;
        int sum = left.sum + right.sum + node.key;

        if(res.node == null ||
               res.sum * num <= res.numOfNodes * sum ) {
            res.sum = sum;
            res.numOfNodes = num;
            res.node = node;
        }
        return new ResultType(sum, num , node);
    }
}
