package alg.oa.facebook;

import java.util.List;

public class NestedListWeightSumII {
    interface NestedInteger {
        // Constructor initializes an empty nested list.
//              public NestedInteger();

        // Constructor initializes a single integer.
//              public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] res = new int[]{0};
        if (nestedList == null || nestedList.size() == 0) return res[0];
        int depth = findDepth(nestedList);
        dfs(nestedList, depth - 1, res);
        return res[0];
    }

    private int findDepth(List<NestedInteger> nets) {
        int childMaxDepth = 1;
        for (NestedInteger net : nets) {
            if (!net.isInteger()) {
                childMaxDepth = Math.max(childMaxDepth, findDepth(net.getList()));
            }
        }
        return childMaxDepth + 1;
    }

    private void dfs(List<NestedInteger> nets, int level, int[] res) {
        if (level < 0) return;
        for (NestedInteger net : nets) {
            if (net.isInteger()) {
                res[0] += net.getInteger() * level;
            } else {
                dfs(net.getList(), level - 1, res);
            }
        }
    }
}
