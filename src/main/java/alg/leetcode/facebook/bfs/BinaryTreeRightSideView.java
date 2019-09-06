package alg.leetcode.facebook.bfs;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.List;

/**
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public interface BinaryTreeRightSideView {
  List<Integer> rightSideView(TreeNode root);
}
