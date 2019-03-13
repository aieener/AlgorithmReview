package Class_12_DPI;

/**
 * last review : 2/10/19
 * Created by yuding on 2/8/18.
 * {7, 2, 3, 1, 5, 8, 9, 6},
 * longest ascending subarray is {1, 5, 8, 9}, length is 4.
 *
 * DP M[i] represent the len of the subarray ending at i
 *      M[i] = M[i - 1] + 1 if (it is ascending)
 *           = 1            if it is not ascending anymore
 */
public class LongestAscendingSubArray {
    /**
     * My Sol
     * @param array
     * @return
     */
    public int longest(int[] array) {
        if(array == null || array.length ==0) {
            return 0;
        }
        int[] M = new int[array.length];
        //base case
        M[0] = 1;

        int res = M[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            res = Math.max(M[i],res);
        }
        return res;
    }

    /**
     * LaiOffer Sol
     */
    public int longest2(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int res = 1;
        int cur = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] > array[i - 1]) {
                cur++;
                res = Math.max(cur,res);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
