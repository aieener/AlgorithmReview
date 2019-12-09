package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.PreOrder;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderImpl implements PreOrder {
    @Override
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preOrder(root, res);
        return res;
    }
    private void preOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.key);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
