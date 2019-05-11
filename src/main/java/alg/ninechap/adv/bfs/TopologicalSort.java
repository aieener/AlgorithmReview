package alg.ninechap.adv.bfs;


import java.util.*;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};

public class TopologicalSort {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        ArrayList<DirectedGraphNode> resOrder =  new ArrayList<>();
        if(graph == null) {
            return resOrder;
        }

        // indegree
        Map<DirectedGraphNode, Integer> indegree = findIndegree(graph);
        // startNode
        ArrayList<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);
        // bfs
        bfs(indegree, startNodes, resOrder);
        return resOrder;
    }
    private void bfs(Map<DirectedGraphNode, Integer> indegree,
                     ArrayList<DirectedGraphNode> startNodes,
                     ArrayList<DirectedGraphNode> resOrder) {

        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for(DirectedGraphNode cur : startNodes) {
            resOrder.add(cur);
            queue.offer(cur);
        }

        while(!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            // expand curNode
            for(DirectedGraphNode curNei : curNode.neighbors) {
                // neighbor's degree --
                indegree.put(curNei, indegree.get(curNei) - 1 );
                if (indegree.get(curNei) == 0) {
                    queue.offer(curNei); // generate new Nodes
                    resOrder.add(curNei);
                }
            }
        }
        return ;
    }

    private ArrayList<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        for(Map.Entry<DirectedGraphNode, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    private Map<DirectedGraphNode, Integer> findIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> res = new HashMap<>();
        // initialize it
        for(DirectedGraphNode cur : graph) {
            res.put(cur, 0);
        }

        // fill up with it
        for(DirectedGraphNode cur : graph) {
            for(DirectedGraphNode nei : cur.neighbors){
                res.put(nei,res.get(nei) + 1);
            }
        }
        return res;
    }
}
