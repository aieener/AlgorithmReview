package BaiciZhan;

import Class_04_BinTree.TreeNode;

import java.util.*;

/**
 * Created by yuding on 3/24/18.
 */
public class countNumofNodeofBinTree {
    public List<Integer> countNumLayer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int curLevel = queue.size();
            res.add(curLevel);
            for(int i = 0; i < curLevel; i++) {
                TreeNode curNode = queue.poll();
//                temp.add(curNode.key);
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
//        System.out.println(temp);
        return res;
    }

    public static void main(String[] args) {
        countNumofNodeofBinTree cb = new countNumofNodeofBinTree();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);
        System.out.println(cb.countNumLayer(root));
    }
}
