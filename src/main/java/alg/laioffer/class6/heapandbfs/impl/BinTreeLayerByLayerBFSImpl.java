package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.laioffer.class6.heapandbfs.BinTreeLayerByLayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeLayerByLayerBFSImpl implements BinTreeLayerByLayer {
    @Override
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode nodeToExpand = queue.poll();
                curLayer.add((nodeToExpand.key));
                if(nodeToExpand.left != null) {
                    queue.offer(nodeToExpand.left);
                }
                if (nodeToExpand.right != null) {
                    queue.offer(nodeToExpand.right);
                }
            }
            res.add(curLayer);
        }
        return res;
    }
}
