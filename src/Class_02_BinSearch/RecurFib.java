package Class_02_BinSearch;

public class RecurFib {
    /**
     * Recurversion time: 2^n
     * T(n) = T(n - 1 ) + T(n - 2)
     */
    public long fibonacci(int K){
        if(K <= 0){
            return 0;
        }
        //base case
        if(K == 1){
            return 1;
        }

        return fibonacci(K -1 ) + fibonacci(K -2);
    }


    /**
     * Need to revisit this fundemental DP problem!!
     */
    public long fibonacciDP(int K){
        if(K <= 0){
            return 0;
        }
        long a = 0;
        long b = 1;
        while (K > 1) {
            long temp = a + b;
            a = b;
            b = temp;
            K--;
        }
        return b;
    }

    //--- prac ---

    public long fibonacci2(int K){
        if(K <= 0) {
            return 0;
        }
        long a = 0;
        long b = 1;
        while( K > 1) {
            long temp = a + b;
            a = b;
            b = temp;
            K--;
        }
        return b;
    }
}
