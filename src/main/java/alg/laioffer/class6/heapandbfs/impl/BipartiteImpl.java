package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class6.heapandbfs.Bipartite;
import alg.laioffer.class6.heapandbfs.GraphNode;

import java.util.*;

public class BipartiteImpl implements Bipartite {
    private final Integer WHITE = 1;
    private final Integer BLACK = 0;

    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() <= 1) return true;
        Map<GraphNode, Integer> colorLkup = new HashMap<>();
        for (GraphNode node : graph) {
            if (!bfs(node, colorLkup)) return false;
        }
        return true;
    }

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> colorLkup) {
        if (colorLkup.containsKey(node)) return true;
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        colorLkup.put(node, WHITE);

        while (!queue.isEmpty()) {
            GraphNode nodeToExpand = queue.poll();
            Integer neighborColor = colorLkup.get(nodeToExpand) == BLACK ? WHITE : BLACK;
            for (GraphNode nei : nodeToExpand.neighbors) {
                if (!colorLkup.containsKey(nei)) {
                    queue.offer(nei);
                    colorLkup.put(nei, neighborColor);
                } else if (colorLkup.get(nei) != neighborColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
