package NineChap_Adv_binTree_LCode;

import Class_04_BinTree.TreeNode;

public class BTreeLCSII {
    class ResultType{
        public int maxLen, maxDown, maxUp;
        ResultType(int len, int down, int up){
            this.maxLen = len;
            this.maxDown = down;
            this.maxUp = up;
        }
    }

    public int longestConsecutive2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ResultType res =  helper(root);
        return res.maxLen;
    }

    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0,0,0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int down = 0;
        int up = 0;

        // down
        if(root.left != null && root.left.key + 1 == root.key) {
            down = Math.max(down, left.maxDown + 1);
        }

        if(root.right != null && root.right.key + 1 == root.key) {
            down = Math.max(down, right.maxDown + 1);
        }

        // up
        if(root.left != null && root.left.key - 1 == root.key) {
            up = Math.max(down, left.maxUp + 1);
        }

        if(root.right != null && root.right.key - 1 == root.key) {
            up = Math.max(up, right.maxUp + 1);
        }

        int len = down + 1 + up;
        len = Math.max(len, Math.max(left.maxLen, right.maxLen));
        return new ResultType(len, down, up);
    }
}
