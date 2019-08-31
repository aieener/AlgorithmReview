package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode 480
 * Given a binary tree, return all root-to-leaf paths.
 * Need to revisit!!!
 */
public class BinTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for(String path : left) {
            res.add(root.key + "->" + path);
        }

        for(String path : right) {
            res.add(root.key + "->" + path);
        }

        // check if reaches the bottom
        if(left.size() == 0 && right.size() == 0) {
//        if(res.size() == 0) {
            res.add(Integer.toString(root.key));
        }
        return res;
    }

    //---- practise
    public List<String> binaryTreeP(TreeNode root) {
        List<String> res = new ArrayList<>();
        // base case
        if(root == null) {
            return res;
        }

        // divide to subprob
        List<String> leftRes = binaryTreeP(root.left);
        List<String> rightRes = binaryTreeP(root.right);

        // recur rule
        for(String cur : leftRes) {
            cur = root.key + "->" + cur;
            res.add(cur);
        }
        for(String cur : rightRes) {
            cur = root.key + "->" + cur;
            res.add(cur);
        }

        // reach buttom
        if(leftRes.size() == 0 && rightRes.size() == 0) {
            res.add(Integer.toString(root.key));
        }
        return res;
    }
}
