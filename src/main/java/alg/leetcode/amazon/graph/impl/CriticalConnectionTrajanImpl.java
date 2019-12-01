package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.CriticalConnection;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=TyWtx7q2D7Y
 * https://stackoverflow.com/questions/11218746/bridges-in-a-connected-graph/11221469#11221469
 * trajan alg is the straight forward dfs approach + DP memoization the minTime.
 * low[]: low-link value of a node is the smallest/lowest node id reachable from that node when doing a DFS (including itself)
 * the nodes with same low-link value belongs to the same strongly connected component
 * low[] helps to identify if there is a cycle
 * not complete
 * Time: O(V + E)
 */
public class CriticalConnectionTrajanImpl implements CriticalConnection {
    @Override
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connection) {
        List<List<Integer>> criticalConnections = new ArrayList<>();
        int[] disc = new int[n]; // if disc[i] == 0 then i is unvisited, store the minCost from head
        int[] low = new int[n];
        // if low[i] < timeCostlkup[i] then node i in cycle
        // otherwise parentNode -> curNode is a solution
        int[] globalTime = new int[]{1};
        for (int i = 0; i < n; i++) {
            if (disc[i] == 0){
                // only traverse if is not visited
                dfs(0, -1, low, disc, formGraph(connection), criticalConnections, globalTime);
            }
        }
        return criticalConnections;
    }

    private void dfs(int curNode, int prevNode, int [] low,  int[] disc, Map<Integer, Set<Integer>> graph,
                     List<List<Integer>> res, int[] time) {
        time[0]++;
        disc[curNode] = low[curNode] = time[0];
        for(int nei  : graph.get(curNode)) {
            if(nei == prevNode) continue;
            if(disc[nei] == 0) {
                dfs(nei, curNode, low, disc, graph, res, time);
                low[curNode] = Math.min(low[curNode], low[nei]);
                if(low[nei] > disc[curNode] ) {
                    res.add(Arrays.asList(curNode, nei));
                }
            } else {
                low[curNode] = Math.max(low[curNode], disc[nei]);
            }
        }
    }

    private Map<Integer, Set<Integer>> formGraph(List<List<Integer>> connection) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> con : connection) {
            graph.putIfAbsent(con.get(0), new HashSet<>());
            graph.putIfAbsent(con.get(1), new HashSet<>());
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }
        return graph;
    }
}
