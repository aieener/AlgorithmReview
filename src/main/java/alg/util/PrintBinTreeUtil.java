package alg.util;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinTreeUtil {
    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode toExpand = queue.poll();
                if (toExpand.key == Integer.MIN_VALUE) {
                    sb.append("null ");
                } else {
                    sb.append(toExpand.key + " ");
                    if (toExpand.left != null) {
                        queue.offer(toExpand.left);
                    } else {
                        queue.offer(new TreeNode(Integer.MIN_VALUE));
                    }
                    if (toExpand.right != null) {
                        queue.offer(toExpand.right);
                    } else {
                        queue.offer(new TreeNode(Integer.MIN_VALUE));
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
