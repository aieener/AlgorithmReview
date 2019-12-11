package alg.leetcode.array.impl;

import alg.leetcode.array.MinDominoRotationForEqualRow;

/**
 * try make A[0] in a whole row,
 * the condition is that A[i] == A[0] || B[i] == A[0]
 * a and b are the number of swap to make a whole row A[0]
 * <p>
 * Try B[0]
 * the condition is that A[i] == B[0] || B[i] == B[0]
 * a and b are the number of swap to make a whole row B[0]
 * <p>
 * Return -1
 */
public class MinDominoRotationBetterImpl implements MinDominoRotationForEqualRow {
    public int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x) return -1;
                // A[i] != x and B[i] == x
            else if (A[i] != x) rotations_a++;
                // A[i] == x and B[i] != x
            else if (B[i] != x) rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    @Override
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || A[0] == B[0]) return rotations;
            // If one could make all elements in A or B equal to B[0]
        else return check(B[0], B, A, n);
    }
}