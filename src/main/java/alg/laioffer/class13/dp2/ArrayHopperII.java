package alg.laioffer.class13.dp2;


import java.util.Arrays;

/**
 * Created by yuding on 2/9/18.
 * Last review 2/25/19
 * Left big Chunk + right small Chunk
 */
public class ArrayHopperII {
    /**
     * Sol 1 from left to right
     * Stuck with this one!
     * @param array
     * @return
     */
    public int minJump(int[] array) {
        int length = array.length;
        int[] M = new int[length];
        //base
        M[0] = 0;
        for(int i = 1; i < length; i++) {
            M[i] = -1; //initialized as unreachable
            for(int j = i - 1; j >= 0; j--) {
                if(j + array[j] >= i && M[j] != -1) {
                    if(M[i] == -1 || M[i] > M[j] + 1 ){
                        M[i] = M[j] + 1;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(M));
        return M[length - 1];
    }

    /**
     * Sol2 from right to left
     * This one follows the method we coverd in class
     * the above one is easier to follow...
     */

    public int minJump2(int[] array) {
        int length = array.length;
        int [] M = new int[length];
        boolean [] Mb = new boolean[array.length];
        if(array.length == 1){
            return 0;
        }
        //base
        M[length - 1] = 0;
        // 2 3 1 1 4
        // 0 0 0 0 0
        for(int j = length - 2; j >= 0; j--) {
            if(j + array[j] >= array.length - 1) {
                Mb[j] = true;
            } else {
                for(int i = array[j]; i >= 1; i--) {
                    if(Mb[j + i]) {
                        Mb[j] = true;
                        break;
                    }
                }
            }
            int counter = 1;
            M[j] = M[j + counter] + 1;
            while(counter <= array[j] && j + counter <= length - 1) {
                M[j] = Math.min(M[j + counter] + 1, M[j]);
                counter++;
            }
        }
        if(!Mb[0]) {
            return -1;
        }
        return M[0];
    }

    public static void main(String[] args) {
        ArrayHopperII ap = new ArrayHopperII();
        int [] arr = new int[] {2,3,1,1,4};
//        int [] arr = new int[] {1,2,0};
//        int [] arr = new int[] {2,1,1,1,4};
//        int [] arr = new int[] {4,2,1,2,0,0};
//        int [] arr = new int[] {4,2,1,1,0,4};
        System.out.println(ap.minJump(arr));
        System.out.println(ap.minJump2(arr));
    }

    // ------ prac --------
    // M[i] represent minJump to spot i from 0 , -1 means can't access
    public int minJump3(int[] array) {
        int [] M = new int[array.length];
        // base case
        M[0] = 0;
        for (int i = 1; i < array.length; i++ ) {
            M[i] = -1; // initialized as not accessable
            for (int j = 0; j < i; j++) {
                if(M[j] != -1 && (j + array[j] >= i)) {
                    // accesable && da nei tai
                    if(M[i] == -1 || M[i] > M[j] + 1) {
                        M[i] = M[j] + 1;
                    }
                }
            }
        }
        return M[array.length - 1];
    }
}
