package Class_04_BinTree;

public class CheckBalanBinTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return  1 + Math.max(left, right);
    }

    // LaiOffer version
    public boolean isBalancedLaiOffer(TreeNode root) {
        if(root == null) {
            return true;
        }
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // ---- practice
    public boolean isBalanced2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return height2(root) != -1;
    }

    private int height2 (TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height2(root.left);
        if(left == -1) {
            return -1;
        }
        int right = height2(root.right);
        if(right == -1) {
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left,right) + 1;
    }



}
