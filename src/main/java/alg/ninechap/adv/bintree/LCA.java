package alg.ninechap.adv.bintree;

import alg.laioffer.class5.bintree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class ParentTreeNode {
    public ParentTreeNode parent, left, right;
    public int key;

    public ParentTreeNode (int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class LCA {
    /**
     * Basic version
     * LeetCode 235
     * LintCode 88
     */
    public TreeNode LCA(TreeNode root, TreeNode A, TreeNode B){
        // base case
        if(root == null) {
            return null;
        }

        if(root == A || root == B) {
            return root;
        }

        // divide
        TreeNode left = LCA(root.left , A, B);
        TreeNode right = LCA(root.right, A, B);

        if(left != null && right != null){
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    /**
     *  LCA where not can absent in the tree
     *  LintCode : 578
     */
    class ResultType{
        boolean A_exist, B_exist;
        TreeNode res;
        ResultType(boolean A_exist, boolean B_exist, TreeNode res) {
            this.A_exist =  A_exist;
            this.B_exist = B_exist;
            this.res = res;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType res = helper(root, A, B);
        if(res.A_exist && res.B_exist){
            return res.res;
        } else {
            return null;
        }
    }
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) {
            return new ResultType(false, false, null);
        }

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean A_exist = left.A_exist || right.A_exist || root == A;
        boolean B_exist = left.B_exist || right.B_exist || root == B;

        if(A == root || B == root) {
            return new ResultType(A_exist, B_exist, root);
        }

        if(left.res != null && right.res != null){
            return new ResultType(A_exist, B_exist, root);
        } else if (left.res != null){
            return new ResultType(A_exist, B_exist, left.res);
        } else if (right.res != null){
            return new ResultType(A_exist, B_exist, right.res);
        }

        return new ResultType(A_exist, B_exist, null);
    }

    /**
     * LCA with parent Node
     * LintCode 474
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> A_ToRoot = getRoot(A);
        List<ParentTreeNode> B_ToRoot = getRoot(B);

        int A_size = A_ToRoot.size() - 1;
        int B_size = B_ToRoot.size() - 1;
        ParentTreeNode res = null;
        while(A_size >= 0 && B_size >= 0) {
            if(A_ToRoot.get(A_size) != B_ToRoot.get(B_size)){
                break;
            }
            res = A_ToRoot.get(A_size);
            A_size--;
            B_size--;
        }
        return res;
    }

    private List<ParentTreeNode> getRoot(ParentTreeNode node) {
        List<ParentTreeNode> res = new ArrayList<>();
        if(node == null) {
            return res;
        }
        while(node != null){
            res.add(node);
            node = node.parent;
        }
        return res;
    }
}
