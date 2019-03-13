package Class_04_BinTree;

import java.util.ArrayList;

public class isBST {
    public boolean isBSTPreOrder(TreeNode root) {
        //Method 1, preorder trans os BST is sorted!
        ArrayList<Integer> preorder = new ArrayList<>();
        preOrder(root, preorder);

        for(int i = 1; i < preorder.size(); i++) {
            if(preorder.get(i - 1) > preorder.get(i)){
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> res){
        if(root == null) {
            return;
        }
        preOrder(root.left, res);
        res.add(root.key);
        preOrder(root.right, res);
    }

    //-------- method 2 --- recur

    /**
     * + 1 - 1 很重要！
     */

    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    public boolean isBST(TreeNode root, int min, int max) {
        // base case
        if(root == null) {
            return true;
        }

        if(root.key < min || root.key > max ) {
            return false;
        }

        return isBST(root.left, min,root.key - 1) &&
                isBST(root.right, root.key + 1, max);

    }


    //------ practice
    public boolean isBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBST2(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST2(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.key >= max || root.key <= min) {
            return false;
        }

        boolean left = isBST2(root.left, min, root.key);
        if(!left){
            return false;
        }

        boolean right = isBST2(root.right, root.key, max);
        if(!right) {
            return false;
        }
        return true;
    }

}
