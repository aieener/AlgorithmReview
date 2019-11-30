package alg.leetcode.amazon.graph;

import java.util.List;

/**
 * LeetCode 1192: Amazon OA 2 Problem
 * tarjan alg: https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
 */
public interface CriticalConnection {
    List<List<Integer>> criticalConnections(int n, List<List<Integer>> connection);
}
