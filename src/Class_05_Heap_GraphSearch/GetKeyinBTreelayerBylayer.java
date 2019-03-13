package Class_05_Heap_GraphSearch;

import Class_04_BinTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 最最基础的基础题
 */
public class GetKeyinBTreelayerBylayer {
    public List <List<Integer>> layerByLayer(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return res;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                layer.add(cur.key);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(layer);
        }
        return res;
    }

    //-----------
    public List<List<Integer>> layerByLayer2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                layer.add(cur.key);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
