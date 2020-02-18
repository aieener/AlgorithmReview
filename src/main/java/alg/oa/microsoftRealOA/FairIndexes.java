package alg.oa.microsoftRealOA;

/*
given int[] A and int[] B with same len

index k is fair if A[0] + .. + A[k-1], A[k] + .. A[n-1]
and B[0] + .. + B[k-1], B[k] + .. B[n-1] are ALL EQUAL

return 0 if no fair idx
return num of Fair idx
 */
public class FairIndexes {
  public static void main(String[] args) {
    int[] A1 = {4, -1, 0, 3}, B1 = {-2, 5, 0, 3}; // return 2, {2, 3}
    int[] A2 = {2, -2, -3, 3}, B2 = {0, 0, 4, -4}; // return 1 {2}
    int[] A3 = {4, -1, 0, 3}, B3 = {-2, 6, 0, 4}; // return 0
    int[] A4 = {3, 2, 6}, B4 = {4, 1, 6}; // return 0
    int[] A5 = {1, 4, 2, -2, 5}, B5 = {7, -2, -2, 2, 5}; //return 2 {2,4}
    System.out.println(getNumOfFairIndexes(A1, B1));
    System.out.println(getNumOfFairIndexes(A2, B2));
    System.out.println(getNumOfFairIndexes(A3, B3));
    System.out.println(getNumOfFairIndexes(A4, B4));
    System.out.println(getNumOfFairIndexes(A5, B5));
  }

  private static int getNumOfFairIndexes(int[] A, int[] B) {
    int res = 0, sumA = 0, sumB = 0;
    // calc Total Sum
    for (int i = 0; i < A.length; i++) {
      sumA += A[i];
      sumB += B[i];
    }
    // curSum
    int tmpA = 0, tmpB = 0;
    for (int i = 0; i < A.length - 1; i++) {
      tmpA += A[i];
      tmpB += B[i];
      if (sumA == 2 * tmpA && sumB == 2 * tmpB && tmpA == tmpB)
        res++;
    }
    return res;
  }
}
