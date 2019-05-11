package alg.laioffer.finalexam;


import java.util.Arrays;

public class minSplit {
    /**
     *
     * M[i] the min split for i;
     * M[0] = 0;
     * M[1] = 1;
     * M[2] = 2;
     * M[3] = 3;
     * M[4] = 1 = 2^2 ;
     */
    public int minSplit(int num) {
        if (num == 1) {
            return 1;
        }
        int[] M = new int[num + 1];
        M[0] = 0;
        M[1] = 1;
        for(int i = 2; i < M.length; i++) {
            M[i] = i; // worst case
            for(int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i], 1 + M[i - j*j]);
            }
        }
        System.out.println(Arrays.toString(M));
        return M[M.length - 1];
    }

    public static void main(String[] args) {
        minSplit m = new minSplit();
        System.out.println(m.minSplit(7));
    }
}
