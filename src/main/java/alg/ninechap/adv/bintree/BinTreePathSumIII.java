package alg.ninechap.adv.bintree;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode 472
 * List II version, this one is 自上而下 而非一头扎地
 * Give a binary tree, and a target number,
 * find all path that the sum of nodes equal to target,
 * the path could be start and end at any node in the tree.
 *
 * THis is one is HARD, copy the sol from ninechapt
 */
public class BinTreePathSumIII {
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, res);
        return res;
    }

    private void dfs(ParentTreeNode root, int target, List<List<Integer>> res) {
        // base case
        if(root == null) {
            return;
        }

        List<Integer> path = new ArrayList<>();

        // recur rule ---> this is the HARD part!
        findSum(root, null, target, path, res);

        // subProblem
        dfs(root.left, target, res);
        dfs(root.right, target, res);
    }

    private void findSum(ParentTreeNode root, ParentTreeNode parent, int target,
                         List<Integer> path, List<List<Integer>> res){
        path.add(root.key);
        target -= root.key;

        if(target == 0) {
            res.add(new ArrayList<>(path));
        }

        if(root.parent != null && root.parent !=  parent){
            findSum(root.parent, root, target, path, res);
        }

        if(root.left != null && root.left !=  parent){
            findSum(root.left, root, target, path, res);
        }

        if(root.right != null && root.right !=  parent){
            findSum(root.right, root, target, path, res);
        }

        path.remove(path.size() - 1);
    }


}
