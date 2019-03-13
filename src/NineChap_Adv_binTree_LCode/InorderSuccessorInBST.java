package NineChap_Adv_binTree_LCode;

import Class_04_BinTree.TreeNode;

public class InorderSuccessorInBST {
    /**
     * Inorder Successor in BST
     * Inorder: left, mid, right
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null && root != p) {
            if(root.key > p.key){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if(root == null) {
            // did not find node p
            return null;
        }

        // curr is now p
        // 2 cases: 要么往右下走， 要么往上汇中

        // Case 1
        if( root.right == null) {
            // if p don't have right child then just return successor
            // 往上汇中
            return successor;
        }

        // Case 2
        // if p has a right child
        // 往右下走
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
