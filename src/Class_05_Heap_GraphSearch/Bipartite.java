package Class_05_Heap_GraphSearch;


import java.util.*;

/**
 * Have no idea
 * 经典好题！
 * Check sol at Dec 31
 */
public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode, Integer> visited = new HashMap<>();

        for(GraphNode node : graph) {
            if (!BFS(node, visited)) { // check the color of the node's neighbors
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        // if node has already been traversed, no need to do it again
        if(visited.containsKey(node)){
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node); // seed
        visited.put(node, 0); // the node has not been visited yet, assign it with group 0
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0; // neiGroup is differ from curGroup

            for(GraphNode nei : cur.neighbors){
                if(!visited.containsKey(nei)){
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup){
                    return false;
                }
            }
        }
        return true;
    }

    //----------- practise -------------

    public boolean isBi (List<GraphNode> graph) {
        Map<GraphNode, Integer> visited = new HashMap<>();
        for(GraphNode cur : graph) {
            if(!bfs(cur, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
        if(visited.containsKey(node)) {
            return true;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.putIfAbsent(node, 0); // set default color to 0
        while(!queue.isEmpty()) {
            GraphNode curNode = queue.poll();
            Integer curColor = visited.get(curNode);
            Integer neiColor = curColor == 1 ? 0 : 1;
            for(GraphNode nei : curNode.neighbors) {
                if(visited.containsKey(nei)) {
                    if(visited.get(nei) != neiColor) {
                        return false;
                    }
                }else {
                        visited.put(nei, neiColor);
                        queue.offer(nei);
                }
            }
        }
        return true;
    }
}
