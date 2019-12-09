package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.GetKeysInBSTInGivenRange;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBSTInGivenRangeImpl implements GetKeysInBSTInGivenRange {
    @Override
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        recur(root, min, max, res);
        return res;
    }

    private void recur(TreeNode root, int min, int max, List<Integer> res) {
        // base case
        if(root == null) return;

        if(root.key > min) {
            recur(root.left, min, max, res);
        }
        if(root.key >= min && root.key <= max) {
            res.add(root.key);
        }
        if(root.key < max) {
            recur(root.right, min, max, res);
        }
    }
}
