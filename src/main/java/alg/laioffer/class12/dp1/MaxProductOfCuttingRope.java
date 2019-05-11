package alg.laioffer.class12.dp1;


/**
 * last review : 2/10/19
 * Created by yuding on 2/8/18.
 * This one is very very very important basic DP problem!!!
 * Base case: M[0] = 1 (meaningless), M[1] = 0 M[1] = max(1, M[1])
 * Induction Rule:
 * M[i] represents the max product of rope with len i
 * M[i] = max(case1, case2, case3,...)
 */


public class MaxProductOfCuttingRope {
    /**
     * Sol1:
     * Left Big Chunk + right Big Chunk
     */
    public int maxProduct(int length) {
        int [] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;   // base case
        for(int i = 1; i < length + 1; i++) {
            int curMax = 0;
            // da lei tai
            for(int j = 1; j <= i/2; j++) {
                // it has 1 ,2 ,3 ... i/2 cases
                // we know M[j] by the time we deal with i
                curMax = Math.max(curMax, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
            }
            M[i] = curMax;
        }
        return M[length];
    }

    /**
     * Sol2:
     * LeftBig Chunk + right Small Chunk
     * break the symmetry
     */

    public int maxProduct2(int length) {
        int [] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;   // base case
        for(int i = 1; i < length + 1; i++) {
            int curMax = 0;
            // da lei tai
            for(int j = 1; j < i; j++) {
                // it has 1 ,2 ,3 ... i/2 cases
                // we know M[j] by the time we deal with i
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
            }
            M[i] = curMax;
        }
        return M[length];
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope mp = new MaxProductOfCuttingRope();
        System.out.println(mp.maxProduct2(3));
        System.out.println(mp.maxProduct3(3));
    }

    // ------ prac --------
    // M[i] represents the max product of rope with len i
    // M[i] = max(case1, case2, case3,...)
    public int maxProduct3(int length) {
        int[] M = new int[length + 1]; // so from 0 to length
        // because the questions ask for the answer for length long
        // the answer will be record in M[length]
        // base case
        M[0] = 0; // len = 0 invalid
        M[1] = 0; // also invalid: len = 1, no cut

        for(int i = 1; i < length + 1; i++) {
            // look back
            int curMax = 0;
            for(int j = 1; j < i; j++) {
                curMax = Math.max(Math.max(j, M[j]) * (i - j), curMax);
            }
            M[i] = curMax;
        }
        return M[length];
    }
}
