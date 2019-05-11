package alg.ninechap.adv.bintree;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinTreePathSumII {
    /**
     * Your are given a binary tree in which each node contains a value.
     * Design an algorithm to get all paths which sum to a given value.
     *
     * The path does not need to start or end at the root or a leaf,
     * but it must go in a straight line down.
     * 这道题是自上而下，并非一来就一头扎到底.
     * Need revisit
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper(res, path, root, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode node, int sum,
                        int level) {
        // term condition
        if(node == null) {
            return;
        }
        int tmp = sum;

        path.add(node.key);
        for(int i = level; i >= 0; i--) {
            tmp -= path.get(i);
            if(tmp == 0) {
                //recur rule
                List<Integer> temp = new ArrayList<>();
                for(int j = i; j <= level; ++j) {
                    temp.add(path.get(j));
                }
                res.add(temp);
            }
        }

        // subproblem
        helper(res, path, node.left, sum, level + 1);
        helper(res, path, node.right, sum, level + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        BinTreePathSumII bs = new BinTreePathSumII();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        List<List<Integer>> res = bs.binaryTreePathSum2(root, 6);
        System.out.println(res);
    }
}
