package alg.penn.bloomberg;

import java.util.*;

/**
 * Created by yuding on 2/8/18.
 * LeetCode 692
 */
public class topKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        // step 1 form the map
        Map<String, Integer> map = new HashMap<>();

        for(String str : words) {
            Integer newFreq = map.getOrDefault(str, 0);
            map.put(str,newFreq + 1);
        }

        // step 2, make a priorityQueue
        // entry String --> freq
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(10, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if(e1.getValue() == e2.getValue()) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return e1.getValue() > e2.getValue() ? -1: 1;
            }
        });

        // step 3 add all entrys to priorityQueue

        int counter = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(counter < k) {
                maxHeap.offer(entry);
            } else if ( maxHeap.peek().getValue() < entry.getValue()){
                maxHeap.offer(entry);
            }
        }

        for(int i = 0; i < k; i++) {
           res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        topKFreqWords tk  = new topKFreqWords();
//        String[] words = new String []{"I","love", "leetcode","I", "love","coding"};
        String[] words = new String []{"a","aa", "aaa"};

        System.out.print(tk.topKFrequent(words, 2));
    }

    /**
     * write comparator seperatrly
     * @param words
     * @param k
     * @return
     */

    private Comparator<Map.Entry<String, Integer>> myEntryComparator = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if(e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e1.getValue() > e2.getValue() ? -1: 1;
        }
    };

    public List<String> topKFrequent2(String[] words, int k) {
        List<String> res = new ArrayList<>();

        // step 1 form the map
        Map<String, Integer> map = new HashMap<>();

        for(String str : words) {
            Integer newFreq = map.getOrDefault(str, 0);
            map.put(str,newFreq + 1);
        }

        // step 2, make a priorityQueue
        // entry String --> freq
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(10, myEntryComparator);

        // step 3 add all entrys to priorityQueue
        int counter = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(counter < k) {
                maxHeap.offer(entry);
            } else if ( maxHeap.peek().getValue() < entry.getValue()){
                maxHeap.offer(entry);
            }
        }

        for(int i = 0; i < k; i++) {
           res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    //---------- prac -------------
    public List<String> topKFrequentP(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> freqMap = formMap(words);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
                if(s1.getValue() == s2.getValue()) {
                    return s1.getKey().compareTo(s2.getKey());
                } else {
                    return s1.getValue() > s2.getValue() ? -1 : 1;
                }
            }
        });

        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        for(int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    private Map<String, Integer> formMap(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for(String str : words) {
            Integer curFreq = res.getOrDefault(str, 0);
            res.put(str, curFreq + 1);
        }

        return res;
    }
}
