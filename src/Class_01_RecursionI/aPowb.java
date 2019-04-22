package Class_01_RecursionI;

public class aPowb {
  public long power(int a, int b) {
    // base case
    if (a == 0) return 0;
    if (b == 0) return 1;
    if (b == 1 || a == 1) return a;

    // recur rule
    int firstHalf = b / 2;
    int secondHalf = b - b / 2;
    long res = power(a, firstHalf);
    if (secondHalf == firstHalf) {
      return res * res;
    } else {
      return res * res * a;
    }
  }

  public static void main(String[] args) {
    System.out.println(new aPowb().power(2, 3));
    System.out.println(new aPowb().power(0, 10));
    System.out.println(new aPowb().power(-2, 5));
  }
}
