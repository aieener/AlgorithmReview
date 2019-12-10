package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.laioffer.class6.heapandbfs.BinTreeLayerByLayer;

import java.util.ArrayList;
import java.util.List;

public class BinTreeLayerByLayerDFSImpl implements BinTreeLayerByLayer {
    @Override
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int height = getHeight(root);
        for(int i = 0; i < height; i++) {
            res.add(new ArrayList<>());
        }
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int curLevel) {
       if(root == null || curLevel == res.size() ) return;
       List<Integer> curList = res.get(curLevel);
       curList.add(root.key);
       dfs(root.left, res, curLevel + 1);
       dfs(root.right, res, curLevel + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
