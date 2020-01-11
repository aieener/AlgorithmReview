package alg.leetcodeFreq.chunk1.hard;

import alg.laioffer.class5.bintree.TreeNode;

public interface SerializeAndDeserializeBinTree { // into levelOrder with nulls
    String serialize(TreeNode root);
    TreeNode deserialize(String data);
}
