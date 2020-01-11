package alg.leetcodeFreq.chunk1.hard.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.leetcodeFreq.chunk1.hard.SerializeAndDeserializeBinTree;

import java.util.*;

public class SerializeAndDeserializeBinTreeImpl implements SerializeAndDeserializeBinTree {

    private final String COMMA = ",";
    private final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append(NULL + COMMA);
                continue;
            }
            res.append(node.key + COMMA);
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(COMMA);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals(NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals(NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }



    public static void main(String[] args) {
        long[] input = new long[] {3,6,2,9,-1,10};
//        TreeNode root = new TreeNode(1);
//        root.left= new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        SerializeAndDeserializeBinTree engine = new SerializeAndDeserializeBinTreeImpl();
//        engine.deserialize(engine.serialize(root));

    }
}
