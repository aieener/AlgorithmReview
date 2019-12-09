package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.InOrder;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderImpl implements InOrder {
    @Override
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        inOrder(root, res);
        return res;
    }
    private void inOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inOrder(root.left,res);
        res.add(root.key);
        inOrder(root.right,res);
    }
}
