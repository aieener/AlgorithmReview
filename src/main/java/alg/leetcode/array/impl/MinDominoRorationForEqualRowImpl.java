package alg.leetcode.array.impl;

import alg.leetcode.array.MinDominoRotationForEqualRow;

import java.util.HashMap;
import java.util.Map;

/**
 * majority number 变种做法, not optimal：
 */
public class MinDominoRorationForEqualRowImpl implements MinDominoRotationForEqualRow {
    static class Majority {
        int value;
        int count;

        Majority(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    @Override
    public int minDominoRotations(int[] A, int[] B) {
        Majority majorA = findMajority(A);
        Majority majorB = findMajority(B);
        int costToMakeAEqual = trySwap(A, B, majorA.value);
        int costToMakeBEqual = trySwap(B, A, majorB.value);
        if (costToMakeAEqual != -1 && costToMakeBEqual != -1) {
            return Math.min(costToMakeAEqual, costToMakeBEqual);
        } else if (costToMakeAEqual != -1) {
            return costToMakeAEqual;
        } else return costToMakeBEqual;
    }

    private int trySwap(int[] arrToEqual, int[] other, int targetValue) {
        int count = 0;
        for (int i = 0; i < arrToEqual.length; i++) {
            int cur = arrToEqual[i];
            if (cur != targetValue) {
                if (other[i] != targetValue) return -1;
                count++;
            }
        }
        return count;
    }

    private Majority findMajority(int[] num) {
        Majority res = new Majority(-1, 0);
        for (int cur : num) {
            if (res.value == -1 || res.value == cur) {
                res.value = cur;
                res.count++;
            } else {
                res.count--;
                if (res.count == -1) res.value = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinDominoRotationForEqualRow engine = new MinDominoRorationForEqualRowImpl();
        int[] A = new int[] {2,1,2,4,2,2};
        int[] B = new int[] {5,2,6,2,3,2};
        engine.minDominoRotations(A,B);
    }
}
