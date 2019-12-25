package alg.oa.google.lc.impl;

import alg.oa.google.lc.OddEvenJumps;

import java.util.*;

/*
    same trick as :
        MostPoint Cross a line
        Longest Ascending SubSequence
        MaxValInSlidingWindow
 */
public class OddEvenJumpsMonoStackImpl implements OddEvenJumps {
    static class Pair {
        Integer idx, val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    @Override
    public int oddEvenJumps(int[] A) {
        int n = A.length, res = 1;
        boolean[] MOdd = new boolean[A.length];
        boolean[] MEven = new boolean[A.length];
        // base case
        MOdd[MOdd.length - 1] = true;
        MEven[MEven.length - 1] = true;
        List<Pair> increasingPair = getSortedPairByValue(A, (base, other) -> {
            if (base.val == other.val) return base.idx.compareTo(other.idx);
            return base.val.compareTo(other.val);
        });
        List<Pair> decreasingPair = getSortedPairByValue(A, (base, other) -> {
            if (base.val == other.val) return base.idx.compareTo(other.idx);
            return other.val.compareTo(base.val);
        });
        // monoStack refers to increasing index in stack | 4 3 2 1 top
        int[] oddNextLkup = getNextUsingMonoStack(increasingPair);
        int[] evenNextLkup = getNextUsingMonoStack(decreasingPair);

        for (int i = A.length - 2; i >= 0; i--) {
            if (oddNextLkup[i] != 0) {
                MOdd[i] = MEven[oddNextLkup[i]];
            }
            if (evenNextLkup[i] != 0) {
                MEven[i] = MOdd[evenNextLkup[i]];
            }
            if (MOdd[i]) {
                res++;
            }
        }
        return res;
    }

    // 马甲版 findNextGreater (greater idx)
    private int[] getNextUsingMonoStack(List<Pair> orderedPair) {
        int[] res = new int[orderedPair.size()];
        Deque<Integer> stack = new LinkedList<>();
        for (Pair pair : orderedPair) {
            while (!stack.isEmpty() && stack.peek() < pair.idx) {
                res[stack.peek()] = pair.idx;
                stack.pop();
            }
            stack.push(pair.idx);
        }
        return res;
    }

    private List<Pair> getSortedPairByValue(int[] A, Comparator<Pair> comparator) {
        List<Pair> increasingPairs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            increasingPairs.add(new Pair(i, A[i]));
        }
        Collections.sort(increasingPairs, comparator);
        return increasingPairs;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 2, 1, 4, 4, 5};
        new OddEvenJumpsMonoStackImpl().oddEvenJumps(input);
//        new OddEvenJumpsTreeMapImpl().oddEvenJumps(input);
    }
}
