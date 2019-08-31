package alg.laioffer.class5.bintree;

/**
 * Created by yuding on 1/21/18.
 * 重点常考题！
 * 练习课14
 * Time : O(height)只走一支 + O(deleteSmallest) = O(height) + O(height) = O(height)
 * Space : O(height)
 */
public class deleteinBST {
    public TreeNode delete (TreeNode root, int target) {
        // base case
        if (root == null) {
            return null ;
        }
        // subProb
        if(target < root.key) {
            root.left = delete(root.left, target);
            return root;
        }
        if (target > root.key) {
            root.right = delete(root.right , target);
            return root;
        }
        // if reaches here, the deleting node is the root

        // case 1: has no children (included in case 2 and case 3)
        if(root.left == null && root.right == null) {
            // connect the parent to null
            return null;
        }

        // case 2: there is no left child
        if(root.left == null) {
            return root.right;
        }

        // case 3: there is no right child
        if(root.right == null) {
            return root.left;
        }

        // case 4: has both left and right children

        // case 4.1: right child has no left child case 4.1
        if(root.right.left == null) {
            root.right.left = root.left;
            return root.right; // delete the original root
        }

        // case 4.2 right child has left child
        // need to find min in right child
        TreeNode smallest = deleteSmallest(root);
        smallest.left = root.left; // smallest replace root
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        // using two ptr : 惯用技巧 ListNode use it as well
        TreeNode prev = null;
        TreeNode cur = root;
        while(cur.left != null) { // want cur stop at min
            prev = cur;
            cur = cur.left;
        }

        // 4.1 can't be included here due to NPE
        // prev will be null for 4.1
        prev.left = cur.right;
        return cur;
    }

    //--- prac ---
}
