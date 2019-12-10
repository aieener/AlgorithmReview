package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.laioffer.class6.heapandbfs.CheckIfBinTreeIsCompleted;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinTreeIsCompletedImpl implements CheckIfBinTreeIsCompleted {
    @Override
    public boolean isCompleted(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundBubble = false;
        while (!queue.isEmpty()) {
            TreeNode nodeToExpand = queue.poll();
            if (nodeToExpand.left != null) {
                if (foundBubble) return false;
                queue.offer(nodeToExpand.left);
            } else {
                foundBubble = true;
            }
            if (nodeToExpand.right != null) {
                if (foundBubble) return false;
                queue.offer(nodeToExpand.right);
            } else {
                foundBubble = true;
            }
        }
        return true;
    }
}
