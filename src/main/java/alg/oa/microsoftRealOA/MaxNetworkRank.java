package alg.oa.microsoftRealOA;

public class MaxNetworkRank {

  /*
  N Cities
  M roads
  A.length = M;
  A[i] and B[i] are cities at the two ends of the ith Road
  there are N cities
  network rank is the total number of the roads that are connected to either of the two cities
  find the maximal network rank in the whole infra
  A = [1,2,3,3]
  B = [2,3,1,4]
  N = 4   ---> return 4 (2,1) (2,3) (3,1) (3,4)

   */
  public int solution(int[] A, int[] B, int N) {
    int max = 0;
    int[] cityEdgeCount = new int[N + 1]; // city number from 1 to N, so this array we use [1, N]
    int edgeLen = A.length; // M
    // count num of roads for each city
    for (int i = 0; i < edgeLen; i++) {
      cityEdgeCount[A[i]] += 1;
      cityEdgeCount[B[i]] += 1;
    }
    // find the maxPair
    for (int i = 0; i < edgeLen; i++) {
      int curRank = cityEdgeCount[A[i]] + cityEdgeCount[B[i]] - 1;
      max = Math.max(max, curRank);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 3};
    int[] B = {2, 3, 1, 4};
    int N = 4;
    System.out.println(new MaxNetworkRank().solution(A, B, N));
  }
}
