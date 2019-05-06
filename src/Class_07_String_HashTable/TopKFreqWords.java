package Class_07_String_HashTable;

import java.util.*;

public class TopKFreqWords {
  public String[] topKFrequent(String[] combo, int k) {
    Map<String, Integer> map = getMap(combo);
    return reduce(map, k);
  }

  private String[] reduce(Map<String, Integer> map, int k) {
    Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      if(minHeap.size() < k) {
        minHeap.offer(entry);
      } else if(entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }

    int resSize = Math.min(k, minHeap.size());
    String[] res = new String[resSize];

    for(int i = resSize - 1 ; i >=0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }

  private Map<String, Integer> getMap(String[] combo) {
    Map<String, Integer> res = new HashMap<>();
    for (String val : combo) {
      int count = res.getOrDefault(val, 0);
      res.put(val, count + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    TopKFreqWords tk = new TopKFreqWords();
    String[] combo = new String[]{"a", "a", "b", "b", "b",
        "b", "c", "c", "c", "d"};
    String[] res = tk.topKFrequent(combo, 5);
    System.out.println(Arrays.toString(res));
  }
}
