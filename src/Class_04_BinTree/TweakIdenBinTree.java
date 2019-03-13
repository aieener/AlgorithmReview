package Class_04_BinTree;

/**
 * 比Symmetric 多了一个或
 */
public class TweakIdenBinTree {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if(one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if(one.key != two.key) {
            return false;
        }

        boolean onelleft =  isTweakedIdentical(one.left, two.left);
        boolean onerright =  isTweakedIdentical(one.right, two.right);
        boolean onelright =  isTweakedIdentical(one.left, two.right);
        boolean onerleft =  isTweakedIdentical(one.right, two.left);


        // tweaked || non-tweaked
        return onelleft && onerright || onerleft && onelright;
    }

    //--- prac ----

    public boolean isTweakedIdentical2(TreeNode one, TreeNode two) {
        if(one == null && two == null) {
            return true;
        } else if(one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }

        boolean onelr = isTweakedIdentical2(one.left, two.right);
        boolean onerl = isTweakedIdentical2(one.right, two.left);
        boolean onell = isTweakedIdentical2(one.left, two.left);
        boolean onerr = isTweakedIdentical2(one.right, two.right);
        return onelr && onerl || onell && onerr;
    }
}
