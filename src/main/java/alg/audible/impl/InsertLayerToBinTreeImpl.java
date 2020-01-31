package alg.audible.impl;

import alg.audible.InsertLayerToBinTree;
import alg.laioffer.class5.bintree.TreeNode;
import alg.util.PrintBinTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class InsertLayerToBinTreeImpl implements InsertLayerToBinTree {
    @Override
    public TreeNode insert(TreeNode root, int depth, int val) {
        // find depth Layer bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && depth != 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode toExpand = queue.poll();
                if (toExpand.left != null) {
                    queue.offer(toExpand.left);
                }
                if (toExpand.right != null) {
                    queue.offer(toExpand.right);
                }
            }
            depth--;
        }
        // find the level above depth
        while (!queue.isEmpty()) {
            // insert
            TreeNode toExpand = queue.poll();
            TreeNode oriLeft = toExpand.left;
            TreeNode oriRight = toExpand.right;
            toExpand.left = new TreeNode(val);
            toExpand.right = new TreeNode(val);
            toExpand.left.left = oriLeft;
            toExpand.right.right = oriRight;
        }
        return root;
    }

    public static void main(String[] args) {
        InsertLayerToBinTree engine = new InsertLayerToBinTreeImpl();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(2);
        left.right = new TreeNode(5);
        right.left = new TreeNode(7);
        engine.insert(root, 2, 0);
        PrintBinTreeUtil.printLevelOrder(root);
    }
}
