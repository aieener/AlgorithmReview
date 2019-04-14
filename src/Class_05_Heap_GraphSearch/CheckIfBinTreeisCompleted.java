package Class_05_Heap_GraphSearch;

import Class_04_BinTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A good BFS problem
 * CTCI also has this one, 必须掌握！
 * 然而第一次做任然不会...
 * 需要反复复习！
 */
public class CheckIfBinTreeisCompleted {
    public boolean isCompleted(TreeNode root){
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // if the flag is set true, there should not be any child nodes
        // afterwards
        boolean flag = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll(); // seed
            if(cur.left == null) {
                // if left is null, should not have any child!
                // raise a flag!
                flag = true;
            } else if (flag) {
                // if flag is set but we still see a left child
                return false;
            } else {
                queue.offer(cur.left);
            }

            if(cur.right == null) {
                flag = true;
            } else if(flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }

    //--- prac ---
}
