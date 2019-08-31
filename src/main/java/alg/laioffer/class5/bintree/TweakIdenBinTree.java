package alg.laioffer.class5.bintree;

/**
 * 比Symmetric 多了一个或
 * time complexity:
 * branching factor :　４ 每一層4個叉
 * level : log n
 * T(n) = 1 + 4 + 4^2 + 4^3 + ... + 4 ^ (logn) ==>  2 ^ (2logn) = 2 ^ (logn^2) = n^2
 */
public class TweakIdenBinTree {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // base case
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }

        boolean caseOne = isTweakedIdentical(one.left, two.left);
        boolean caseTwo = isTweakedIdentical(one.left, two.right);
        boolean caseTree = isTweakedIdentical(one.right, two.left);
        boolean caseFour = isTweakedIdentical(one.right, two.right);
        return caseOne || caseTwo || caseTree || caseFour;
    }

}
