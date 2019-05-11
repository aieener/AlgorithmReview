package alg.laioffer.class4.bintree;

/**
 * Created by yuding on 1/19/18.
 */
public class InsertToBST {
    /**
     * Need to revisit to understand better!
     * 习题课 13
     */
    public TreeNode insert(TreeNode root, int target) {
        if(root == null) {
            return new TreeNode(target);
        } else if (root.key == target) {
            return root;
        }

        if(root.key > target) {
            // for most case, insert will return the original node
            root.left = insert(root.left, target);
        } else if (root.key < target) {
            // for most case, insert will return the original node
            root.right = insert(root.right, target);
        }
        return root;
    }

    public TreeNode insert2(TreeNode root , int target) {
        if(root == null) {
            // corner case
            return new TreeNode(target);
        }
        helper(root,target);
        return root;

    }

    public void helper(TreeNode root, int target) {
        // stop at null's upper level
        if(root.key > target) {
            if(root.left == null) {
                // corner case
                root.left = new TreeNode(target);
            } else {
                helper(root.left, target);
            }
        } else if(root.key < target) {
            if(root.right == null) {
                // corner case
                root.right = new TreeNode(target);
            } else {
                helper(root.right, target);
            }
        }
    }

    public TreeNode insertIter(TreeNode root, int target) {
        TreeNode newNode = new TreeNode(target);
        if(root == null) {
            return newNode;
        }

        TreeNode current = root;
        while(current != null) {
            if(current.key > target) {
                if(current.left != null) {
                    current = current.left;
                } else {
                    current.left = newNode;
                    break;
                }
            } else {
                if(current.right != null) {
                    current = current.right;
                } else {
                    current.right = newNode;
                    break;
                }
            }
        }
        return root;
    }
}
