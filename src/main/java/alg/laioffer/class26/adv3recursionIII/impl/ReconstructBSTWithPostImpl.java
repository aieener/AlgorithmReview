package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.ReconstructBSTWithPost;
import alg.laioffer.class5.bintree.TreeNode;

public class ReconstructBSTWithPostImpl implements ReconstructBSTWithPost {
    @Override
    public TreeNode reconstruct(int[] post) {
        int[] idx = new int[]{post.length - 1}; // serve like a counter
        return helper(post, idx, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] idx, int min) {
        // base case
        if (idx[0] < 0 || post[idx[0]] <= min) return null; // finish iter or invalid
        TreeNode node = new TreeNode(post[idx[0]--]);
        node.right = helper(post, idx, node.key);
        node.left = helper(post, idx, min);
        return node;
    }
}
