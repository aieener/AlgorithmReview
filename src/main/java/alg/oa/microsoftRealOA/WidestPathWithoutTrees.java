package alg.oa.microsoftRealOA;

import java.util.Arrays;

/*
given x = [5,5,5,7,7,7]
given y = [3,4,5,1,3,7] --> return 2

given x = [6,10,1,4,3]
given y = [2,5,3,1,6] --> return 4

Approach:
Since we have to find the vertical path, we can focus only in the x co-ordinates, i.e., values of X array
Now, we have to find the max width between the values in X array.
We can sort the X array and the difference between adjacents, while doing it we keep track of the max value found so far.
 */
public class WidestPathWithoutTrees {
  public int findPath(int[] x) {
    Arrays.sort(x);
    int maxWidth = 0;
    for (int i = 0; i < x.length - 1; i++) {
      maxWidth = Math.max(maxWidth, x[i + 1] = x[i]);
    }
    return maxWidth;
  }

  public static int solution(int X, int Y, int[] A) {
    int N = A.length;
    int result = -1;
    int nX = 0;
    int nY = 0;
    for (int i = 0; i < N; i++) {
      if (A[i] == X && A[i] != Y)
        nX += 1;
      else if (A[i] == Y && A[i] != X)
        nY += 1;
      if (nX == nY)
        result = i;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(solution(7, 42, new int[]{6, 42, 11, 7, 1, 42}));
    System.out.println(solution(0, 0, new int[]{13, 13, 1, 6}));
    System.out.println(solution(100, 63, new int[]{100, 63, 1, 6, 2, 13}));

  }
}
