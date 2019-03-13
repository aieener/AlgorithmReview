package Class_04_BinTree;
import Class_03_LL.ListNode;

import java.util.*;

// Why Deque but not Stack?
// because Stack interface suggest to use Deque instead !!!
// pop push will throw exception
// OfferFirst and PollFIrst won't have this problem

public class InOrder {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderrecur(root, res);
//        res = inOrderlaiOffer(root);
        return res;
    }

    private void inOrderrecur(TreeNode root, List<Integer> res){
        // base case
        if(root == null) {
            return;
        }

        inOrderrecur(root.left, res);
        res.add(root.key);
        inOrderrecur(root.right, res);
    }

    public List<Integer> inOrderlaiOffer(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }

    //--- prac ----

    public List<Integer> inOrder2 (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.pollFirst();
                res.add(curr.key);
                curr = curr.right;
            }
        }
        return;
    }
}
