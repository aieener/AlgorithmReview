package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.ClosestNumberInBSTTwo;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestNumInBSTTwoImpl implements ClosestNumberInBSTTwo {
    @Override
    public int[] closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inOrderTraversal(queue, root, target, k);
        int[] res = new int[queue.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = queue.poll();
        }
        return res;
    }
    private void inOrderTraversal(Queue<Integer> queue, TreeNode node, double target, int k) {
        if(node == null) {
            return;
        }
        inOrderTraversal(queue,node.left, target, k);
        if(queue.size() < k) {
            queue.offer(node.key);
        } else {
            if(Math.abs(target - (double) node.key) < Math.abs(target - (double)queue.peek())) {
                queue.offer(node.key);
                queue.poll();
            }
        }
        inOrderTraversal(queue,node.right, target, k);
    }
}
