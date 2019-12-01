package alg.leetcode.array;

/**
 * This problem is Gready!
 *
 * Yes, the only one domino element was checked here,
 * and still it's enough because the rotation is the only allowed operation here.
 * because if on failed, then all will fail
 *  * try make A[0] in a whole row,
 *  *   the condition is that A[i] == A[0] || B[i] == A[0]
 *  * Try make B[0] in a whole row
 *  * the condition is that A[i] == B[0] || B[i] == B[0]
 *  * Else
 *  * Return -1
 */
public interface MinDominoRotationForEqualRow {
    int minDominoRotations(int[] A, int[] B);
}
