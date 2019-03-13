package Class_04_BinTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GetKeyInBSTRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        getRange(root, min, max, res);
        return res;
    }

    public void getRange(TreeNode root, int min, int max,
                                  List<Integer> res) {
        // base case
        if (root == null) {
            return ;
        }

        // Noticed inorder to get ascending order, do left , cen, right!
        //prune: 剪枝
        if(root.key > min) {
            getRange(root.left, min, max, res);
        }

        if(root.key >= min && root.key <= max) {
            res.add(root.key);
        }

        //prune:
        if(root.key < max) {
            getRange(root.right, min, max,res);
        }
    }


    //--- my iterative way
    public List<Integer> getRangeIter(TreeNode root, int min, int max) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while(curr != null || ! stack.isEmpty()){
            while(curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            curr = stack.pollFirst();
            if(curr.key >= min && curr.key <= max) {
                res.add(curr.key);
            }
            if (curr.key > max){
                break;
            }
            curr = curr.right;
        }
        return res;
    }

    // ---- prac ---
    public List<Integer> getRange2(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(res, root, min, max);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }
        if(root.key > min) {
            helper(res, root.left, min, max);
        }

        if(root.key <= max && root.key >= min) {
            res.add(root.key);
        }
        if(root.key < max ){
            helper(res, root.right, min, max);
        }
    }
}
