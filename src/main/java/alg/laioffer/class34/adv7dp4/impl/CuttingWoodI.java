package alg.laioffer.class34.adv7dp4.impl;

/**
 * 1D DP : 切绳子，单词，palindrome
 * 2D DP : this one is the hardest DP problem from LaiOffer
 * this one is very hard, linear scan 不 work here!
 * 中心开花
 * check lecture to understand it better Class 25 SUN
 */
public class CuttingWoodI {
  public int minCost(int[] cuts, int length) {
    int[] helper = new int[cuts.length + 2];
    // pad cuts with leftMost and rightMost partition
    helper[0] = 0;
    for (int i = 0; i < cuts.length; i++) {
      helper[i + 1] = cuts[i];
    }
    helper[helper.length - 1] = length;
    // minCost: the min Cost of cutting the partion (i, j); lastly return M[0][length-1]
    /**
     * M[j][i] = input[ j --> i] + M[j][k] + M[k][i] , where j < k < i
     */
    int[][] minCost = new int[helper.length][helper.length];
    for (int i = 1; i < helper.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (j + 1 == i) {
          minCost[j][i] = 0; // base case --> smallest problem, no cuts
        } else {
          minCost[j][i] = Integer.MAX_VALUE;
          for (int k = j + 1; k <= i - 1; k++) {
            minCost[j][i] = Math.min(minCost[j][i], minCost[j][k] + minCost[k][i]);
          }
          minCost[j][i] += helper[i] - helper[j];
        }
      }
    }
    return minCost[0][helper.length - 1];
  }
}
