package alg.laioffer.class12.dp1.impl;

import alg.laioffer.class12.dp1.MaxProductCutting;

public class MaxProductCuttingImpl implements MaxProductCutting {
  /**
   * Left bigChunk, right smallChunk is more general
   * remember the case that no cuts --> Math.max(M[j], j)
   */
  @Override
  public int maxProduct(int length) {
    int[] M = new int[length + 1];
    M[0] = 0;
    M[1] = 1;
    for (int i = 2; i < length + 1; i++) {
      int curMax = 0;
      for (int j = 1; j < i; j++) {
        curMax = Math.max(curMax, Math.max(M[j], j) * (i - j));
      }
      M[i] = curMax;
    }
    return M[length];
  }
}
