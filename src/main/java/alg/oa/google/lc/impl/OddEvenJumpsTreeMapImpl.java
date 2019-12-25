package alg.oa.google.lc.impl;

import alg.oa.google.lc.OddEvenJumps;

import java.util.Map;
import java.util.TreeMap;

/*
    O(NlogN)
    First let's create a boolean DP array.
dp[i][0] stands for you can arrive index n - 1 starting from index i at an odd step.
dp[i][1] stands for you can arrive index n - 1 starting from index i at an even step.
Initialization:
Index n - 1 is always a good start point, regardless it's odd or even step right now. Thus dp[n - 1][0] = dp[n - 1][1] = true.
DP formula:
dp[i][0] = dp[index_next_greater_number][1] - because next is even step
dp[i][1] = dp[index_next_smaller_number][0] - because next is odd step
Result:
Since first step is odd step, then result is count of dp[i][0] with value true.

To quickly find the next greater or smaller number and its index: traverse the array reversely and store data into a TreeMap using the number as Key and its index as Value.

Time complexity O(nlgn), Space complexity O(n). n is the length of the array.
 */
public class OddEvenJumpsTreeMapImpl implements OddEvenJumps {
    /*
        TreeMap Ceiling Key, floorKey
        or Queue<<value, idx>> first --> max, last --> min

        TreeMap Interface: ceiling >=  | floor <=
       1. Entry<K, V> ceilingEntry(K Key) : It is used to return a key-value mapping associated with the least key greater than or
                equal to the given key, or null if there is no such key.

       2. K ceilingKey(K key) : This has also the same work as that of the upper one but the only difference is that it
                DOES NOT contains the value, just K
                It simply returns the least key greater or equal to the given key, else returns NULL.
     */
    @Override
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // <value, idx> , treemap sorted by value
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        map.put(A[n - 1], n - 1);
        int res = 1;

        for (int i = n - 2; i >= 0; i--) { // back to beginning
            // both nextGreaterIdx and nextSmallerIdx is known and visited!
            // Odd step
            Integer nextGreaterVal = map.ceilingKey(A[i]);
            if (nextGreaterVal != null) {
                int nextGreaterIdx = map.get(nextGreaterVal);
                dp[i][0] = dp[nextGreaterIdx][1];
            }
            // Even step
            Integer nextSmallerVal = map.floorKey(A[i]);
            if (nextSmallerVal != null) {
                int nextSmallerIdx = map.get(nextSmallerVal);
                dp[i][1] = dp[nextSmallerIdx][0];
            }
            map.put(A[i], i);

            if(dp[i][0]){
                res++;
                System.out.println(i);
            }
        }

        return res;
    }
}
