package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.S95Percentile;

import java.util.List;

public class S95PercentileImpl implements S95Percentile {
    // bucket sort that known maxLen is 4096
    @Override
    public int percentile95(List<Integer> lengths) {
        int TOTAL_LEN = 4097;
        int[] bucket = new int[TOTAL_LEN];
        // load to bucket
        for (Integer len : lengths) {
            bucket[len]++;
        }
        // from end to first find first count > 0.5 * lengths.size(); which is the 95th
        int count = 0;
        int len = TOTAL_LEN;
        while(count <= 0.05 * lengths.size()) {
            len--;
            count += bucket[len];
        }
        /* OR from first to end find first count > 0.95 * len
            int count = 0;
            int len = 0;
            while(count < 0.95 * lengths.size()) {
                len++;
                count += bucket[len];
            }
         */
        return len;
    }
}
