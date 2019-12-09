package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.laioffer.class5.bintree.TweakedIdenticalBinTree;

public class TweakedIdentitalBinTreeImpl implements TweakedIdenticalBinTree {
    @Override
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) return true;
        else if (one == null || two == null) return false;
        if (one.key != two.key) return false;
        return (isTweakedIdentical(one.left, two.left)
                && isTweakedIdentical(one.right, two.right))
                || (isTweakedIdentical(one.right, two.left)
                && isTweakedIdentical(one.left, two.right));
    }
}
