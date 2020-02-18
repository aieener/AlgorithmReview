package alg.oa.microsoftRealOA;

/*
leetcode 1304
Given an integer n, return any array containing n unique integers such that they add up to 0
A[i] = i * 2 - n + 1;
Naive idea
n = 1, [0]
n = 2, [-1, 1]

Now write more based on this
n = 3, [-2, 0, 2]
n = 4, [-3, -1, 1, 3]
n = 5, [-4, -2, 0, 2, 4]
n = 6, [-5, -3, 1, 1, 3, 5]

It spreads like the wave.
 */
public class FindNUniqIntegersThatSumUpTo0 {
  public int[] sumZero(int n) {
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = i * 2 - n + 1;
    }
    return res;
  }
}
