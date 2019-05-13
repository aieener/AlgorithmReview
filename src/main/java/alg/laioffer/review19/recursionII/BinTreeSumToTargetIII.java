package alg.laioffer.review19.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinTreeSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
    // base case
    if (root == null) {
      return false;
    }

    List<TreeNode> path = new ArrayList<>();
    return helper(root, path,  target);
  }

  private boolean helper(TreeNode root, List<TreeNode> path, int target) {
    path.add(root);
    if(checkPath(path, target)) return true;
    if(root.left != null && helper(root.left, path, target)) return true;
    if(root.right != null && helper(root.right, path, target)) return true;
    path.remove(path.size() - 1);
    return false;
  }

  private boolean checkPath(List<TreeNode> path, int target) {
    int sum = 0;
    for(int i = path.size() - 1; i >=0; i--){
      sum += path.get(i).key;
      if(sum == target) return true;
    }
    return false;
  }
}
