package alg.penn.bloomberg;
import java.util.*;

/**
 * Created by yuding on 2/8/18.
 * 株连九族题
 * find children problem! similar to VMware's animal predator question
 * first, find the [parent, chidren] map
 * parent --> children
 *
 * then do a bfs or dfs on the kill id to get it's subtree
 */
public class KillProcess {
    /**
     * DFS approach
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // first, form a map that maps parents to it's children
        // map: parent -- >[childrens]
        for(int i = 0; i < ppid.size(); i++) {
            if(ppid.get(i) > 0) {
                List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<>());
                children.add(pid.get(i));
                map.put(ppid.get(i), children);
            }
        }

        // then do dfs
        List<Integer> children = new ArrayList<>();
        children.add(kill);
        dfs(map, children, kill);
        return children;
    }

    private void dfs(Map<Integer, List<Integer>> map, List<Integer> children, int kill){
        // base case:
        if(!map.containsKey(kill)) {
            return;
        } else {
            for(Integer id : map.get(kill)) {
                children.add(id);
                dfs(map, children, id);
            }
        }
    }

    /**
     * Sol 2: BFS
     */

    public List<Integer> killProcessBFS(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // map: parent --> children

        for(int i = 0; i < ppid.size(); i++) {
            if(ppid.get(i) > 0) {
                List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<>());
                children.add(pid.get(i));
                map.put(ppid.get(i), children);
            }
        }
        // then do bfs
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(kill);
        while(!queue.isEmpty()) {
            // expand
            Integer curId = queue.poll();
            res.add(curId);
            if(map.containsKey(curId)) {
                for(Integer id : map.get(curId)) {
                    queue.offer(id);
                }
            }
        }
        return res;
    }

    // ----------- prac -----------
    public List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill) {
        // form graph
        Map<Integer, List<Integer>> map = formMap(pid, ppid);
        // do dfs or bfs

        List<Integer> res = new ArrayList<>();
        res.add(kill);
        helper(res, map, kill);
        return res;
    }
    private void helper(List<Integer> res, Map<Integer, List<Integer>> map, int tar) {
        List<Integer> curChildren = map.getOrDefault(tar, null);
        if(curChildren == null) {
            // base case
            return;
        } else {
            for(Integer curId : curChildren){
                res.add(curId);
                helper(res,map,curId);
            }
        }
    }

    private Map<Integer, List<Integer>> formMap(List<Integer> pid, List<Integer> ppid) {
        // Map parant --> children
        Map<Integer, List<Integer>> res = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++ ) {
            if(ppid.get(i) != 0 ) {
                List<Integer> curChildren = res.getOrDefault(ppid.get(i), new ArrayList<>());
                curChildren.add(pid.get(i));
                res.putIfAbsent(ppid.get(i), curChildren);
            }
        }
        return res;
    }
}
