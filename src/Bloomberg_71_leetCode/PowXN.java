package Bloomberg_71_leetCode;

/**
 * Created by yuding on 2/11/18.
 * LeetCode 50
 */
public class PowXN {
    /**
     * Brute Force time exceed version
     */
    public double myPowBF(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        for(long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }


    /**
     * Better version
     */

    public double myPowRecur(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        // base case
        if(n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n/2);
        if(n %2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public static void main(String[] args) {
        PowXN pw = new PowXN();
        System.out.print(pw.myPowRecur(2.100, 3));
    }

    /**
     * Iter version
     */
    public double myPowIter(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        double currentProd = x;
        for(long i = N; i > 0; i /= 2) {
            if((i%2) == 1) {
                ans = ans * currentProd;
            }
            currentProd = currentProd * currentProd;
        }
        return ans;
    }

    //------- prac --------
    public double myPow(double x, int n) {
        long N = n;
        // hanld neg n
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow2(x, N);
    }
    private double fastPow2(double x, long n) {
        // base case
        if(n == 0) {
            return 1.0;
        }

        double half = fastPow2(x, n/2);
        if(n/2 % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}

