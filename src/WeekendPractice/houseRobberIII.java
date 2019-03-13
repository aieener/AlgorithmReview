package WeekendPractice;

import Class_04_BinTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class houseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob
        res[1] = root.key + left[0] + right[0]; // rob

        return res;
    }
    //-------------- optimal recur sol
    public int robrecurOp(TreeNode root) {
        return robSubI(root, new HashMap<>());
    }

    private int robSubI(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSubI(root.left.left, map) + robSubI(root.left.right, map);
        }

        if (root.right != null) {
            val += robSubI(root.right.left, map) + robSubI(root.right.right, map);
        }

        val = Math.max(val + root.key, robSubI(root.left, map) + robSubI(root.right, map));
        map.put(root, val);

        return val;
    }

    //-------------- bad recur sol
    public int robreCurr(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.key, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        houseRobberIII hr = new houseRobberIII();
        System.out.println(hr.rob(root));
    }
}
