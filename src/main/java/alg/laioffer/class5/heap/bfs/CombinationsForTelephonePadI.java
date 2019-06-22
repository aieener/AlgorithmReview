package alg.laioffer.class5.heap.bfs;

import java.util.*;

public class CombinationsForTelephonePadI {
  public Map<Integer, String> getDict() {
    Map<Integer, String> dict = new HashMap<>();
    dict.put(0, "");
    dict.put(1, "");
    dict.put(2, "abc");
    dict.put(3, "def");
    dict.put(4, "ghi");
    dict.put(5, "jkl");
    dict.put(6, "mno");
    dict.put(7, "pqrs");
    dict.put(8, "tuv");
    dict.put(9, "wxyz");
    return dict;
  }

  /**
   * BFS sol
   */
  public String[] combinations(int number) {
    List<Integer> input = getInputArr(number);

    Map<Integer, String> dict = getDict();
    List<String > res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Queue<StringBuilder> queue = new LinkedList<>();
    queue.offer(sb);
    while (!queue.isEmpty()) {
      StringBuilder cur = queue.poll();
      if(cur.length() == input.size()) {
        res.add(cur.toString());
      } else {
        for(char i : dict.get(input.get(cur.length())).toCharArray()){
          StringBuilder toExpand = new StringBuilder(cur);
          toExpand.append(i);
          queue.offer(toExpand);
        }
      }
    }
    return getResult(res);
  }

  public List<Integer> getInputArr(int number) {
    String buf = String.valueOf(number);
    // remove 1 and 0 and put to arr
    List<Integer> input = new ArrayList<>();
    for(int i = 0; i < buf.length(); i++) {
      if(buf.charAt(i) =='1' || buf.charAt(i)=='0') {
        continue;
      }
      input.add(buf.charAt(i) - '0');
    }
    return input;
  }

  public String[] getResult(List<String> res) {
    String[] result = new String[res.size()];
    for(int i = 0; i < res.size(); i++) {
      result[i] = res.get(i);
    }
    return result;
  }
}
