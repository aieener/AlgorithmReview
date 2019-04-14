package Class_04_BinTree;

import java.util.*;

public class PreOrder {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderRecur(root, res);
        return res;
    }

    private void preOrderRecur(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.key);
            if(cur.right != null) {
                stack.addFirst(cur.right);
            }

            if(cur.left != null) {
                stack.addFirst(cur.left);
            }
        }
    }

    //---- prac ----
    public List<Integer> preOrder2 (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.key);
            if(cur.right != null){
                stack.offerFirst(cur.right);
            }
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        return res;
    }

    //---DFS鼻祖printPreorder
    public void printTreePreOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.key);
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }
}
