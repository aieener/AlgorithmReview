package alg.audible.impl;

import alg.audible.TopKSimilarElement;
import alg.laioffer.class6.heapandbfs.GraphNode;
import alg.penn.bloomberg.MissingNum;

import java.util.*;

public class TopKSimilarElementImpl implements TopKSimilarElement {
    @Override
    public List<GraphNode> findTopKSimilarNode(GraphNode input, int k) {
        List<GraphNode> res = new ArrayList<>();
        if (input == null) return res;
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        // plant seed
        queue.offer(input);
        visited.add(input);
        boolean isSeed = true;
        while (!queue.isEmpty() && k != 0) {
            GraphNode toExpand = queue.poll();
            if (!isSeed) {
                res.add(toExpand);
                k--;
            } else {
                isSeed = false;
            }
            for (GraphNode generated : toExpand.neighbors) {
                if (!visited.contains(generated)) {
                    queue.offer(generated);
                    visited.add(generated);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 1A, 2B, 3C, 4D, 5E, 6F
        GraphNode A = new GraphNode(1);
        GraphNode B = new GraphNode(2);
        A.neighbors.add(B);
        A.neighbors.add(new GraphNode(3));
        A.neighbors.add(new GraphNode(4));
        B.neighbors.add(A);
        B.neighbors.add(new GraphNode(5));
        B.neighbors.add(new GraphNode(6));

        TopKSimilarElement engine = new TopKSimilarElementImpl();
        List<GraphNode> res = engine.findTopKSimilarNode(A, 4);
        for (GraphNode cur : res) {
            System.out.println(cur.key);
        }
    }
}
