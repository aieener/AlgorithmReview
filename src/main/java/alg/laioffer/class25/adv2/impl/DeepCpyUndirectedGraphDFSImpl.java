package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class5.heap.bfs.GraphNode;
import alg.laioffer.crosstraining2.DeepCpyUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCpyUndirectedGraphDFSImpl implements DeepCpyUndirectedGraph {
  @Override
  public List<GraphNode> copy(List<GraphNode> graph) {
    if(graph == null) return null;
    List<GraphNode> cpyGraph = new ArrayList<>();
    Map<GraphNode, GraphNode> lkup = new HashMap<>();
    for (GraphNode node : graph) {
      dfsCpy(node, lkup);
      cpyGraph.add(lkup.get(node));
    }
    return cpyGraph;
  }

  private void dfsCpy(GraphNode node, Map<GraphNode, GraphNode> lkup) {
    if(lkup.containsKey(node)) return;
    // copy node
    lkup.put(node, new GraphNode(node.key));
    GraphNode nodeCpy = lkup.get(node);
    for(GraphNode nei : node.neighbors) {
      dfsCpy(nei, lkup);
      nodeCpy.neighbors.add(lkup.get(nei));
    }
  }
}
