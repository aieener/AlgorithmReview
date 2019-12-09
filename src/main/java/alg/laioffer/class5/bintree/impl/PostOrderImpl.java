package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.PostOrder;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderImpl implements PostOrder {
    @Override
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postOrder(root, res);
        return res;
    }
    private void postOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.key);
    }
}
