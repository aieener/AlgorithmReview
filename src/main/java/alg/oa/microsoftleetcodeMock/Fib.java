package alg.oa.microsoftleetcodeMock;

public class Fib {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int prev = 0;
        int cur = 1;
        for (int i = 2; i <= N; i++) {
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }
}
