package alg.laioffer.finalexam;

import alg.laioffer.class4.bintree.TreeNode;

public class areConusins {
    public boolean areCounsins(TreeNode root, TreeNode A, TreeNode B) {
        boolean[] res = new boolean[1];
        res[0] = false;
        helper(root, A, B, 0, res);
        return res[0];
    }

    // return the deeper level
    private int helper(TreeNode root, TreeNode node1, TreeNode node2, int level, boolean[] res) {
        if(root == null) {
            return -1;
        }
        if(root == node1 || root == node2) {
            return level;
        }

        int left = helper(root.left, node1, node2,level + 1, res);
        int right = helper(root.right, node1, node2, level + 1, res);
        if(left == right && left - 1 > level) {
            res[0] = true;
        }
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        areConusins ac = new areConusins();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        TreeNode r3 = root.left;
        TreeNode r5 = root.right;
        TreeNode r7 = root.left.left;
        TreeNode r8 = root.left.right;
        TreeNode r1 = root.right.left;
        TreeNode r2 = root.right.right;

        System.out.println(ac.areCounsins(root, r1, r7 ));
        System.out.println(ac.areCounsins(root, r1, r8 ));
        System.out.println(ac.areCounsins(root, r2, r7 ));
        System.out.println(ac.areCounsins(root, r2, r8 ));
        System.out.println(ac.areCounsins(root, r3, r5 ));
        System.out.println(ac.areCounsins(root, r5, r7 ));
    }
}
