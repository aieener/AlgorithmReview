package alg.amazon2020OA.freq2;

import alg.leetcode.amazon.graph.CriticalConnection;
import alg.leetcode.amazon.graph.impl.CriticalConnectionImpl;

import java.util.*;
/*
You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.

Input:
The input to the function/method consists of three arguments:

numNodes, an integer representing the number of nodes in the graph.
numEdges, an integer representing the number of edges in the graph.
edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
Output:
Return a list of integers representing the critical nodes.

Example:

Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
 */

public class CriticalRouters {
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
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        ));
    }
}
