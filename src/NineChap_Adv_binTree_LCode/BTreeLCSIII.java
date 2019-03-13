package NineChap_Adv_binTree_LCode;

import java.util.ArrayList;
import java.util.List;

class MultiTreeNode {
    int val;
    List<MultiTreeNode> children;
    MultiTreeNode(int x) {
        this.val = x;
    }
}

class ResultType{
    int maxUp, maxDown, maxLen;
    ResultType(int up, int down, int len) {
        this.maxDown = down;
        this.maxUp = up;
        this.maxLen = len;
    }
}

public class BTreeLCSIII {
    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).maxLen;
    }

    /**
     * Better version of helper
     */
    private ResultType helper(MultiTreeNode root) {
        if(root == null) {
            // base case
            return new ResultType(0,0,0);
        }
        int up = 0;
        int down = 0;
        int len = 1;
        for(MultiTreeNode cur : root.children) {
            // divide to subprob
            ResultType res = helper(cur);

            // recursion rule
            // up
            if(cur != null && cur.val + 1 == root.val) {
               // parent 3->2->1
                up = Math.max(up, res.maxUp + 1);
            }
            //down
            if(cur != null && cur.val - 1 == root.val) {
                down = Math.max(down, res.maxDown + 1);
            }
            len = Math.max(len, res.maxLen);
        }
        len = Math.max(up + down + 1, len);
        return new ResultType(up, down, len);
    }

    /**
     * This version Helper passed the test but was bad
     */
    private ResultType Helper(MultiTreeNode root) {
        if(root == null) {
            return new ResultType(0,0,0);
        }
        List<ResultType> layer = new ArrayList<>();
        for(MultiTreeNode cur : root.children) {
            layer.add(helper(cur));
        }
        int up = 0;
        int down = 0;
        int len = 1;

        int i = 0;
        for(MultiTreeNode cur : root.children) {
            // up
            if(cur != null && cur.val + 1 == root.val){
                // 3->2->1;
                up = Math.max(up, layer.get(i).maxUp + 1);
            }
            // down
            if(cur != null && cur.val - 1 == root.val) {
                // 1->2->3;
                down = Math.max(down, layer.get(i).maxDown + 1);
            }
            len = Math.max(len, layer.get(i).maxLen);
            i++;
        }

        len = Math.max(len, up + down + 1);

        return new ResultType(up, down, len);
    }
}
