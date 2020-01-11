package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.BinTreeZigzag;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinTreeZigZagImpl implements BinTreeZigzag {
    @Override
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null ) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        // plant seed
        queue.offerLast(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode toExpand;
                if(level % 2 != 0) {
                    // odd level prepare data to regular order: pollLast, offerFirst, left first then right
                    toExpand = queue.pollLast();
                    if(toExpand.left != null) {
                        queue.offerFirst(toExpand.left);
                    }
                    if(toExpand.right != null) {
                        queue.offerFirst(toExpand.right);
                    }
                } else {
                    // even level prepare data for reverse order : pollFirst, offerLast, right first, then left
                    toExpand = queue.pollFirst();
                    if(toExpand.right != null) {
                        queue.offerLast(toExpand.right);
                    }
                    if(toExpand.left != null) {
                        queue.offerLast(toExpand.left);
                    }
                }
                res.add(toExpand.key);
            }
            level++;
        }
        return res;
    }
}
