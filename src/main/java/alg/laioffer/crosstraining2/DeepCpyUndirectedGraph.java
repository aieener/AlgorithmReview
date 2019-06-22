package alg.laioffer.crosstraining2;

import alg.laioffer.class5.heap.bfs.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCpyUndirectedGraph {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    HashMap<GraphNode, GraphNode> oriToCpyLkUp = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for (GraphNode node : graph) {
      GraphNode cpy;
      if (!oriToCpyLkUp.containsKey(node)) {
        cpy = new GraphNode(node.key);
        cpy.neighbors = new ArrayList<>();
        oriToCpyLkUp.put(node, cpy);
      } else {
        cpy = oriToCpyLkUp.get(node);
      }

      for (GraphNode nei : node.neighbors) {
        GraphNode cpyNei;
        if (!oriToCpyLkUp.containsKey(nei)) {
          cpyNei = new GraphNode(nei.key);
          oriToCpyLkUp.put(nei, cpyNei);
        } else {
          cpyNei = oriToCpyLkUp.get(nei);
        }
        cpy.neighbors.add(cpyNei);
      }
      res.add(cpy);
    }
    return res;
  }

  public List<GraphNode> copyDFS(List<GraphNode> graph) {
    if (graph == null) return null;
    HashMap<GraphNode, GraphNode> oriToCpyLkUp = new HashMap<>();
    for(GraphNode node : graph) {
      if(!oriToCpyLkUp.containsKey(node)) {
        oriToCpyLkUp.put(node, new GraphNode(node.key));
        DFS(node, oriToCpyLkUp);
      }
    }
    return new ArrayList<>(oriToCpyLkUp.values());
  }

  private void DFS (GraphNode node, Map<GraphNode, GraphNode> oriToCpyLkUp) {
    GraphNode cpy = oriToCpyLkUp.get(node);
    for(GraphNode nei : node.neighbors) {
      if(!oriToCpyLkUp.containsKey(nei)){
        oriToCpyLkUp.put(nei, new GraphNode(nei.key));
        DFS(nei, oriToCpyLkUp);
      }
      cpy.neighbors.add(oriToCpyLkUp.get(nei));
    }
  }
}
