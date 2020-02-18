package alg.oracle.phone;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinTree {
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
    Queue<TreeNode> parentQueue = new LinkedList<>();
    String[] values = data.split(COMMA);
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    parentQueue.add(root);
    int i = 1;
    while (!parentQueue.isEmpty() && i < (values.length - 1)) {
      TreeNode parent = parentQueue.poll();
      if (!values[i].equals(NULL)) {
        TreeNode left = new TreeNode(Integer.parseInt(values[i]));
        parent.left = left;
        parentQueue.add(left);
      }

      if (!values[i + 1].equals(NULL)) {
        TreeNode right = new TreeNode(Integer.parseInt(values[i + 1]));
        parent.right = right;
        parentQueue.add(right);
      }
      i += 2;
    }
    return root;
  }


  public static void main(String[] args) {
    String input = "3,6,2,9,-1,10,null";
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    SerializeDeserializeBinTree engine = new SerializeDeserializeBinTree();
    System.out.println(engine.serialize(root));
    System.out.println(engine.serialize(engine.deserialize(input)));
  }
}
