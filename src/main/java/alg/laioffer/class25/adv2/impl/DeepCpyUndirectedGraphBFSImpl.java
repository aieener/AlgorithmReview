package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.DeepCpyUndirectedGraph;
import alg.laioffer.class6.heapandbfs.GraphNode;

import java.util.*;

public class DeepCpyUndirectedGraphBFSImpl implements DeepCpyUndirectedGraph {
  @Override
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    List<GraphNode> cpyGraph = new ArrayList<>();
    Map<GraphNode, GraphNode> lkup = new HashMap<>();
    for (GraphNode node : graph) {
      bfsCpy(node, lkup);
      cpyGraph.add(lkup.get(node));
    }
    return cpyGraph;
  }

  private void bfsCpy(GraphNode node, Map<GraphNode, GraphNode> lkup) {
    if (lkup.containsKey(node)) return;

    Queue<GraphNode> queue = new LinkedList<>();

    lkup.put(node, new GraphNode(node.key));
    queue.offer(node);

    while (!queue.isEmpty()) {
      GraphNode nodeToExpand = queue.poll();
      GraphNode cpyNode = lkup.get(nodeToExpand);

      for (GraphNode nei : nodeToExpand.neighbors) {
        if (!lkup.containsKey(nei)) {
          lkup.put(nei, new GraphNode(nei.key));
          queue.offer(nei);
        }
        GraphNode neiCpy = lkup.get(nei);
        cpyNode.neighbors.add(neiCpy);
      }
    }
  }
}
