package Class_04_BinTree;

import java.util.ArrayList;

public class CheckSymBinTree {

    // Focus on this one!
    // LaiOffer Sol

    public boolean isSymmetricLaiSol(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right) ;
    }

    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if(one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }

        return isSymmetric(one.left, two.right) &&
                isSymmetric(one.right, two.left);
    }

    // my thought: inorder trans will be palindrome
    // Passed!!! hahaha
    public boolean isSymmetric (TreeNode root) {
        ArrayList<Integer> inorder = InOrder(root);

        for(int i = 0, j = inorder.size() - 1; i < j; i++, j--) {
            if(inorder.get(i) != inorder.get(j)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> InOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        InOrderRecur(root, res);
        return res;
    }

    private void InOrderRecur(TreeNode root, ArrayList<Integer> res){
        if(root == null) {
            return;
        }
        InOrderRecur(root.left, res);
        res.add(root.key);
        InOrderRecur(root.right, res);
    }
    //----- practice ---------
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }
    private boolean isSymmetric2(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return true;
        } else if (A == null || B == null){
            return false;
        } else if (A.key != B.key) {
            return false;
        }
        return isSymmetric2(A.left, B.right) && isSymmetric2(A.right, B.left);
    }

}
