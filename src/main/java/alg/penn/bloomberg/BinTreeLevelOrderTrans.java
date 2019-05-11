package alg.penn.bloomberg;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Feb 20
 * LeetCode 102
 */
public class BinTreeLevelOrderTrans {
    /**
     * Sol 1, classical BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty()) {
            int num = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < num; i++) {
                TreeNode curNode = queue.poll();
                level.add(curNode.key);
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            res.add(level);
        }
        return res;
    }

    /**
     * Sol 2 my DFS way
     * Find depth is not necessary because the dfs we are doing
     * will transverse through each treeNode at exactly once for each!
     */

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        // first figure out max depth of the tree
        int maxLevel = findDepth(root);
        for(int i = 0; i < maxLevel; i++) {
            // initialize the list for each level
            res.add(new ArrayList<>());
        }
        // do dfs to fill the level
        dfs(res, root, 0, maxLevel);
        return res;
    }

    private int findDepth(TreeNode root) {
        //base case
        if(root == null) {
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return Math.max(left , right) + 1;
    }

    private void dfs(List<List<Integer>> res,  TreeNode root,
                    int curLevel, int maxLevel) {
        //base case
        if(curLevel > maxLevel || root == null) {
            return;
        }
        res.get(curLevel).add(root.key);
        dfs(res, root.left, curLevel + 1, maxLevel);
        dfs(res, root.right, curLevel + 1, maxLevel);
        return;
    }

    /**
     * Sol 3: DFS from LeetCode Sol
     */
    public List<List<Integer>> levelOrderDFS2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    private void levelHelper(List<List<Integer>> res, TreeNode root, int curLevel) {
       //base case
        if(root == null) {
            return;
        }
        if(curLevel >= res.size()) {
            res.add(new LinkedList<>());
        }

        res.get(curLevel).add(root.key);
        levelHelper(res, root.left, curLevel + 1);
        levelHelper(res, root.right, curLevel + 1);
    }

    //-------------------------------------
    public List<List<Integer>> levelOrderdfs3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        // base case
        if(root == null) {
            return;
        }
        if(res.size() == depth ){
            res.add(new ArrayList<>()); // add new layer
        }
        res.get(depth).add(root.key); // add curNode val to cur Level
        // go left first
        helper(res, root.left, depth+1);
        // then go right
        helper(res, root.right, depth+1);
        return;
    }



}
