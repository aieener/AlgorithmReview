package alg.oa.bb;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if(graph == null || graph.length == 0 || graph[0].length == 0) return res;
        // root node = graph[0][0]
        // node i has children = graph[i]
        // find path from root to node graph[rowLen][colLen];
        List<Integer> sol = new ArrayList<>();
        sol.add(0);
        dfs(graph, res, sol , 0);
        return res;
    }

    private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> curSol, int level) {
        // base case
        if(level == graph.length - 1) {
            // reach target, record solution
            res.add(new ArrayList<>(curSol));
            return;
        }

        int[] curVisitableLevel = graph[level];
        for(int nextLevel : curVisitableLevel) {
            curSol.add(nextLevel);
            dfs(graph, res, curSol, nextLevel);
            curSol.remove(curSol.size() - 1);
        }
    }
}
