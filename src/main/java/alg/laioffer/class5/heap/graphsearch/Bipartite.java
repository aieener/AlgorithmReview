package alg.laioffer.class5.heap.graphsearch;

import java.util.*;

/**
 * Last review Mar 15 2019
 * In class Notes: Heap and Graph search algorithms
 * Heap --> priority Queue
 * Classic binary Heap (二叉堆）
 * 1. Heap is a complete binTree (所有气泡一定在最后一层的右侧, 奠定物理连续的基础）
 * 2. index of lChild = indexOfParent * 2 + 1
 * 3. index of rChild = indexOfParent * 2 + 2
 * 4. findParent of node: (index - 1) / 2;
 * 5. implemented as an unsorted array that follows the rules above
 * 6. Every Single Node is smaller than is children (for minHeap)
 *
 * Heap operation:
 * 1. insert O(log(n)) percolateUp
 * 2. update O(log(n)) percolateUp/Down
 * 3. get/top O(1)
 * 4. pop : O(log(n)) percolateDown
 * 5. heapify:  O(n) make an unsorted array into a heap
 *
 * Classic PQueue question: find smallest k elements from an unsorted array of size n
 * sol 1: use a min-heap --> O(n + klogn)
 *  step 1 heapify O(n)
 *  step 2 call pop k times O(klogn)
 *
 * sol 2: use a max-heap --> O(n + klogn)
 *  铁打的营盘流水的兵 , 7 个小矮人
 *  add element to heap of size 7
 *  from 8th item, compare it to top,
 *  step 1 heapify first k element O(k)
 *  step 2 iterate over the rest (n-k) element.
 *      if smaller, update top to new
 *      if bigger, continue
 *      O(k + (n-k) log k)
 *
 *  which one is better?  sol 1 vs sol 2
 *  case 1: k <<< n      O(n)    vs   O(nlogk) hard to say
 *  case 2: k ~ n     O(nlogn)   vs  O(nlogn)  hard to say
 *
 *  Sol 3 quick select (don't work well with repeated data) like quick sort
 *  xxxxxxxxxx Pivot XXXXXXXXXXXXX 做partition
 *  average time O(n + n/2 + n/4 + ....) = O(n)
 *  worst time O(n + n-1 + n-2 + ...) = O(n^2)
 *
 *  when find kth element, partition to the left are the all k smallest elements
 *
 *  Graph
 *  adjacency matrix
 *      pros: representation is easy to implement. Edge removal takes O(1) time. queries like whether there
 *      is an edge from vertex u to vertex v are efficient and can be done O(1)
 *      cons: Consumes more space O(V^2). Even if the graph is sparse ---> waste of space
 *  adjacency list
 *      pros: space complexity O(|V| + |E|), adding vertex/node to the graph is easier
 *      cons: Time complexity is O(V) to check whether there is an edge from a node to the other O(1) for matrix
 *
 *  third options: use a hash_table
 *      <key=node, value = set of neighbors<Node>>
 *
 *  BFS process:
 *      1. expand a node
 *      2. generate s's neighbor node: reach out to its neighboring node
 *      3. Data structure : maintain a FIFO queue, put all generated nodes in the queue
 *      4. terminate condition: do a loop until the queue is empty
 *
 *     while ( Q not empty ) {
 *         expand a node
 *         generate all neighbors
 *     }
 *
 *  BFS 1: can't find shortest path unless the cost for all edge are equivalent
 *  BFS 2: best first search: use a priority queue --> find shortest path (Dijkstra's Alg)
 *    1. usage: find the shortest path cost from a single node to any other nodes in that graph(点到面)
 *    2. example: 从北京到中国其他主要城市的最短距离是多少
 *    3. data structure: priority queue
 *    4. one node can be expanded once and only once
 *    5. one node can be generate more than once ( cost can be reduced over time)
 *    6. all the cost of the nodes that are expanded are monotonically non-decreasing (单调递增）
 *    7. time complexity, for a graph with n node and the connectivity of the node is constant ( n log n)
 *    8. when a node is popped out for expansion, its value is fixed with is equal to the shortest distance
 *      from the starting node
 */

/**
 * Have no idea
 * 经典好题！
 * Check sol at Dec 31
 */
public class Bipartite {
  public boolean isBipartite(List<GraphNode> graph) {
    // write your solution here
    Map<GraphNode, Integer> nodeColorMap = new HashMap<>();
    for(GraphNode node: graph){
      if(!noDup(node, nodeColorMap)){
        return false;
      }
    }
    return true;
  }

  private boolean noDup(GraphNode node, Map<GraphNode, Integer> nodeColorMap){
    if(nodeColorMap.containsKey(node)){
      return true;
    }

    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    nodeColorMap.put(node, 0);
    while(!queue.isEmpty()){
      GraphNode nodeToExpand = queue.poll();
      int curColor = nodeColorMap.get(nodeToExpand);
      int neighborColor = curColor == 0 ? 1 : 0;

      for(GraphNode nei : nodeToExpand.neighbors){
        if(!nodeColorMap.containsKey(nei)){
          nodeColorMap.put(nei, neighborColor);
          queue.offer(nei);
        } else if (nodeColorMap.get(nei) != neighborColor){
          return false;
        }
      }
    }
    return true;
  }
}
