package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.CriticalConnection;

import java.sql.PreparedStatement;
import java.util.*;

public class CriticalConnectionImpl implements CriticalConnection {
    @Override
    public List<List<Integer>> criticalConnection(int n, List<List<Integer>> connection) {
        HashMap<Integer, List<List<Integer>>> visited = new HashMap<>();
        return dfs(n, getConnection(connection), visited);
    }

    private List<List<Integer>> dfs(int curNode, Map<Integer, Set<Integer>> connection, HashMap<Integer, List<List<Integer>>> visited) {
        if (visited.containsKey(curNode)) return visited.get(curNode);
        List<List<Integer>> result = new ArrayList<>();
        visited.put(curNode, result);
        for (Integer nei : connection.get(curNode)) {
            List<List<Integer>> critical = dfs(nei, connection, visited);
            result.addAll(validateCritical(critical, curNode));
        }
        visited.put(curNode, result);
        return result;
    }

    private List<List<Integer>> validateCritical(List<List<Integer>> critical, int curNode) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> con : critical) {
            if (con.get(0) != curNode || con.get(1) != curNode) {
                res.add(Arrays.asList(con.get(0), con.get(1)));
            }
        }
        return res;
    }

    private Map<Integer, Set<Integer>> getConnection(List<List<Integer>> connection) {
        Map<Integer, Set<Integer>> connectionLkup = new HashMap<>();
        for (List<Integer> con : connection) {
            connectionLkup.putIfAbsent(con.get(0), new HashSet<>());
            connectionLkup.putIfAbsent(con.get(1), new HashSet<>());
            connectionLkup.get(con.get(0)).add(con.get(1));
            connectionLkup.get(con.get(1)).add(con.get(0));
        }
        return connectionLkup;
    }

    /**
     * at my layer
     * check if any of my neighbor returns any critical con
     * then among these con, check if I connect to them, if not then it is
     */
}
