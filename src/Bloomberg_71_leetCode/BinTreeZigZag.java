package Bloomberg_71_leetCode;

import Class_04_BinTree.TreeNode;

import java.util.*;

/**
 * Feb 20
 * Created by yuding on 2/15/18.
 * LeetCode 103
 */
public class BinTreeZigZag {
    /**
     * BFS sol with Deque
     */

    public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean rever = false;
        while(!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                if(!rever) {
                    // just do as queue
                    TreeNode curNode = deque.pollLast();
                    level.add(curNode.key);
                    if(curNode.left != null) {
                        deque.offerFirst(curNode.left);
                    }
                    if(curNode.right != null) {
                        deque.offerFirst(curNode.right);
                    }

                } else {
                    // do it reversely
                    TreeNode curNode = deque.pollFirst();
                    level.add(curNode.key);
                    if(curNode.right != null) {
                        deque.offerLast(curNode.right);
                    }
                    if(curNode.left != null) {
                        deque.offerLast(curNode.left);
                    }
                }
            }
            rever = ! rever;
            res.add(level);
        }
        return res;
    }

    /**
     * BFS sol
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean rever = false;
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode curNode = queue.poll();
                level.add(curNode.key);
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            if(rever) {
                Collections.reverse(level);
            }
            rever = !rever;
            res.add(level);
        }

        return res;
    }

    /**
     * DFS Sol
     */

    public List<List<Integer>> zigzagLevelOrderdfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(res, 0 , root);
        boolean rever = false;
        for(List<Integer> list : res) {
            if(rever){
                Collections.reverse(list);
            }
            rever = !rever;

        }
        return res;
    }
    private void dfs( List<List<Integer>>res, int curLevel, TreeNode root) {
        // base case
        if(root == null) {
            return;
        }

        if(curLevel > res.size()){
            res.add(new ArrayList<>());
        }
        res.get(curLevel).add(root.key);

        dfs(res,curLevel + 1, root.left);
        dfs(res,curLevel + 1, root.right);
    }

    //------------- prac -------------
    public List<List<Integer>> zigzagLevelOrderprac(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(res, 0, root);
        return res;
    }
    private void helper (List<List<Integer>> res, int level, TreeNode root) {
        // base case
        if(root == null) {
            return;
        }

        if(res.size() == level) {
            res.add(new LinkedList<>()); // add a new List
        }
        if(level % 2 == 0) {
            // even level, don't rever
            res.get(level).add(root.key);
            // rever next level
            dfs(res,level + 1, root.right);
            dfs(res,level + 1, root.left);

        } else {
            // odd level, rever
            int lastPos = res.get(level).size();
            res.get(level).add(lastPos, root.key);
            // odd level, not rever next level
            dfs(res,level + 1, root.left);
            dfs(res,level + 1, root.right);

        }
    }

}
