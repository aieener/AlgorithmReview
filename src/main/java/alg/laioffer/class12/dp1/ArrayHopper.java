package alg.laioffer.class12.dp1;

/**
 * last review : 2/10/19
 * Created by yuding on 2/8/18.
 * base case M[n - 1] = true;
 * induction rule: M[i] = M[i - j] where j is the distance i can reach
 * This one also uses left big chunck and right small chuck, small chuck means can't be cut
 */
public class ArrayHopper {
    /**
     * Sol 1 M[i] means can jump from 0 to i
     * base case M[0] = true;
     *
     * induction rule :
     *  M[i] = true if there exist an j that j < i and j + A[j] >= i
     *      and M[j] = true;
     *      = false otherwise
     */
    public boolean canJump(int[] array) {
        boolean [] M = new boolean[array.length];
        M[0] = true;
        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < i; j++) {
                if(M[j] && array[j] + j >= i ) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[array.length - 1];
    }

    /**
     * Sol 2 M[i] means can jump from i to array.length - 1
     * target = array.length - 1;
     * base case: M[target] = true;
     * induction rule :
     *  M[i] = true if there exist a j element that i < j <= A[i] + i
     *          ( from i, the farest spot one get go is A[i] + i)
     *          and M[j] = true;
     *        false otherwise
     */
    public boolean canJumpRever(int[] array) {
        if(array.length == 1) {
            return true;
        }
        boolean [] M = new boolean[array.length];
        for(int i = array.length - 2; i>=0; i--) {
            if(i + array[i] >= array.length - 1) {
                M[i] = true;
            } else {
                for(int j = array[i]; j >= 1; j--) {
                    if(M[j + i]) {
                        M[i] = true;
                        break;
                    }
                }
            }
        }
        return M[0];
    }

    //---- prac -----
    // practive jum from start to end
    // M[i] represents from 0, one can jump to ith spot
    // M[i]: case 1: for all range it can jump, say j,
    //      M[i] will be true if any M[i - j] is true;
    // linear scan, hui tou kan
    public boolean canJump3(int[] array) {
        boolean[] M = new boolean[array.length];
        // base case
        M[0] = true;
        for(int i = 0; i < array.length; i++) {
            M[i] = false;
            for(int j = 0; j < i; j++) {
                // we know the answer for M[j]!!!
                if(M[j] && j + array[j] >= i) {
                    M[i] = true;
                }
            }
        }
        // the last spot is array.length - 1;
        return M[array.length - 1];
    }
}
