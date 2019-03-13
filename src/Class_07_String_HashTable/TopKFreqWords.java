package Class_07_String_HashTable;

import java.util.*;

public class TopKFreqWords {
    class Pair{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
    public String[] topKFrequent(String[] combo, int k){
        /**
         * My Sol, 第一次做通过 PriorityQueue + HashMap
         */
        if(combo.length == 0){
            return new String[0];
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String cur : combo){
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int len = 0;
        if(k > map.size()){
            len = map.size();
        } else {
            len = k;
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.freq == o2.freq){
                    return 0;
                }
                return o1.freq > o2.freq ? -1 : 1;
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        String[] res = new String[len];
        for(int i = 0; i < len ; i++ ){
            if(maxHeap.isEmpty()){
                break;
            }
            res[i] = maxHeap.poll().word;
        }
        return res;
    }

    /**
     * LaiOffer Sol
     * Core difference:
     *      1. break down methods! don't put everything together!
     *      2. Using Map.Entry <Key, Val> as the element type so I don't need to
     *          create a class Pair
     */

    public String [] TopKFrequent(String[] combo, int k) {
        if(combo.length == 0) {
            return new String [0];
        }
        Map<String, Integer> freqMap = getFreqMap(combo);

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });

        for(Map.Entry<String , Integer> entry: freqMap.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()){
                // only offer if the req is larger than the minimum req in the pqueue
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo){
        Map<String, Integer> freqMap = new HashMap<>();
        for(String s : combo){
            Integer freq = freqMap.get(s);
            if(freq == null) {
                freqMap.put(s,1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minheap){
        String[] result = new String[minheap.size()];
        for(int i = minheap.size() - 1; i >= 0; i--) {
            result[i] = minheap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFreqWords tk = new TopKFreqWords();
        String[] combo = new String []{"a", "a", "b", "b","b",
        "b", "c", "c", "c","d"};
        String[] res = tk.topKFrequent(combo, 5);
        String[] res2 = tk.TopKFrequent(combo, 6);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }

    // --- prac ---
    public String[] topKFrequent2(String[] combo, int k) {
        if(combo.length == 0 ){
            return new String[0];
        }
        // count the occurance of the words
        Map<String, Integer> map = new HashMap<>();
        countOccur(combo,  map);
        // get the len of the output
        int len = map.size() > k ? k : map.size();
        String[] res = new String[len];

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(len, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t0, Map.Entry<String, Integer> t1) {
                if (t0.getValue().equals(t1.getValue())){
                    return 0;
                }
                return t0.getValue() > t1.getValue() ? 1 : -1;
            }
        });

        int counter = 0;
        for(Map.Entry<String, Integer> curEntry : map.entrySet()) {
            if(counter < len) {
                minHeap.offer(curEntry);
            } else if(curEntry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(curEntry);
            }
            counter++;
        }

        for(int i = len - 1; i >=0 ; i--){
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    private void countOccur(String[] combo, Map<String, Integer> map) {
        for(String cur : combo) {
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
    }
}
