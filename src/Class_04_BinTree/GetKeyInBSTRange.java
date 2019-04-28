package Class_04_BinTree;

import java.util.ArrayList;
import java.util.List;

public class GetKeyInBSTRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
      List<Integer> res = new ArrayList<>();
      findSol(res, root, min, max);
      return res;
    }

    private void findSol(List<Integer> res,TreeNode node, int min, int max) {
      // preOrder, start record at min stop at max
      // base case
      if(node == null) {
        return;
      }

      if(node.key > min) {
        findSol(res, node.left, min, max);
      }
      if(node.key >= min && node.key <= max) {
        res.add(node.key);
      }
      if(node.key < max) {
        findSol(res, node.right, min, max);
      }
    }
}
