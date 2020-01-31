package alg.audible;

import alg.laioffer.class6.heapandbfs.GraphNode;

import java.util.List;

public interface TopKSimilarElement {
    /*
        A : B C D
        B : E F
        find top 4 (k = 4) with input A ==> BCDE or BCDF
        Caution about cycle and invalid input
     */
    List<GraphNode> findTopKSimilarNode(GraphNode input, int k);
}
