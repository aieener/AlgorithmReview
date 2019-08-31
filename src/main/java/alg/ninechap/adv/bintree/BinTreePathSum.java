package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find all paths that sum of the nodes in
 * the path equals to a given number target.
 * A valid path is from root node to any of the leaf nodes.
 */
public class BinTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) {
            return res;
        }
        path.add(root.key);
        helper(root, target - root.key, path, res);
        return res;
    }

    private void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> res) {
        // meet leaf
        if(root.left == null && root.right == null) {
            if(target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }


        // subprob
        if(root.left != null){
            path.add(root.left.key);
            helper(root.left, target - root.left.key, path, res);
            path.remove(path.size() - 1);

        }
        // subprob
        if(root.right != null) {
            path.add(root.right.key);
            helper(root.right, target - root.right.key, path, res);
            path.remove(path.size() - 1);
        }

    }
}
