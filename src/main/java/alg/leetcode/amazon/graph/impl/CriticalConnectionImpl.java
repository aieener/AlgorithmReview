package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.CriticalConnection;

import java.util.*;

/**
 * timeCostLkup is disc (discover node i, time cost) in trajan approach
 *
 * We record the timestamp that we visit each node.
 * For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors.
 * If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle.
 * Otherwise, this edge from the parent to this node is a critical connection.
 * <p>
 * int [] timeCostLkup serves as the visited set, but also record the shortest time to reach from node '0'
 * ----
 * this is a 三部曲 bottom up recursion problem!
 * time limited exceed
 * timestamp counting from 1, because we use timeCost[i] == 0 to verify if the node is visited!
 * so the first time count is 1, then 2, 3, 4, ....
 */
public class CriticalConnectionImpl implements CriticalConnection {
    @Override
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connection) {
        List<List<Integer>> criticalConnections = new ArrayList<>();
        dfs(0, -1, formGraph(connection), new int[n], criticalConnections, new int[]{1});
        return criticalConnections;
    }

    /**
     * this recursion call returns the minTimeCost from startNode '0' to curNode
     */
    private int dfs(int curNode, int parentNode, Map<Integer, Set<Integer>> graph, int[] disc,
                    List<List<Integer>> res, int[] time) {
        if (disc[curNode] != 0) return disc[curNode]; // cycle, aka visited, continue;
        disc[curNode] = time[0]++;
        int minTime = Integer.MAX_VALUE;
        for (int nei : graph.get(curNode)) {
            if (nei != parentNode) { // skip the parentNode
                int neiTimeCost = dfs(nei, curNode, graph, disc, res, time);
                minTime = Math.min(minTime, neiTimeCost);
            }
        }
        if (minTime >= disc[curNode] && parentNode >= 0) {
            // then curNode and parentNode forms a bridge
            res.add(Arrays.asList(parentNode, curNode));
        }
        return Math.min(minTime, disc[curNode]);
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

    public static void main(String[] args) {
        CriticalConnection engine = new CriticalConnectionImpl();
        engine.criticalConnections(4, Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(2,0),
                Arrays.asList(1,3)
        ));
    }
}
