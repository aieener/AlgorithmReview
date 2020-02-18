package alg.oa.microsoftRealOA;

/*
leetcode 413
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any
two consecutive elements is the same.

The function should return the number of arithmetic slices in the array A.
 */
public class ParticleVelocity {
  public int numberOfArithmeticSlices(int[] A) {
    int[] M = new int[A.length];
    // M[i] represents numOfArth in range [0,i], that has to ending at idx i
    // induction rule : M[i] = M[i-1] + 1 if A[i] - A[i-1] == A[i-1] - A[i-2] | otherwise 0
    // ARR: 1 3 5 7 9 15 20 25 28 29
    // M    0 0 1 2 3 0  0  1  0  0
    // res = sum over M
    int res = 0;
    for (int i = 2; i < M.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        M[i] = 1 + M[i - 1];
        res += M[i];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ParticleVelocity engine = new ParticleVelocity();
    System.out.println(engine.numberOfArithmeticSlices(new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
  }
}
