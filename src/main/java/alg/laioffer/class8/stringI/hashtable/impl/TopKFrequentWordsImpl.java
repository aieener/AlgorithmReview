package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.TopKFrequentWords;

import java.util.*;

public class TopKFrequentWordsImpl implements TopKFrequentWords {
    @Override
    public String[] topKFrequent(String[] combo, int k) {
        Map<String, Integer> freqMap = count(combo);
        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        String[] res = new String[minHeap.size()];
        for (int i = res.length - 1; i >=0 ; i++) {
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }

    private Map<String, Integer> count(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : combo) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }
        return freqMap;
    }
}
