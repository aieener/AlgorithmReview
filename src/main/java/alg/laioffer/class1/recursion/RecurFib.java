package alg.laioffer.class1.recursion;

public class RecurFib {
  /**
   * Recurversion time: 2^n
   * T(n) = T(n - 1 ) + T(n - 2)
   */
  public long fibonacciRecur(int K) {
    // base case
    if (K <= 0) {
      return 0;
    } else if (K == 1) {
      return 1;
    }
    return fibonacciRecur(K - 2) + fibonacciRecur(K - 1);
  }

  public long fibonacci(int K) {
    if (K<=0) return 0;
    long [] M = new long[K+1];
    //base case
    M[0] = 0;
    M[1] = 1;
    for(int i = 2; i < M.length; i++) {
      M[i] = M[i-1] + M[i-2];
    }
    return M[K];
  }

  public static void main(String[] args) {
    System.out.println(new RecurFib().fibonacciRecur(10));
    System.out.println(new RecurFib().fibonacci(10));
  }
}
