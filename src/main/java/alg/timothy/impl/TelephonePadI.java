package alg.timothy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TelephonePadI {

  public String[] combinations(int number) {
    CombinationsForTelephonePadI comBFS = new CombinationsForTelephonePadI();
    Map<Integer, String> dict = comBFS.getDict();
    List<Integer> input = comBFS.getInputArr(number);
    List<String> res = new ArrayList<>();
    findCom(res, input, dict, 0, new StringBuilder());
    return comBFS.getResult(res);
  }

  private void findCom(List<String> res, List<Integer> input, Map<Integer, String> dict, int level, StringBuilder sb) {
    if(level == input.size()) {
      res.add(sb.toString());
      return;
    }
    Integer curElem = input.get(level);
    String seed = dict.get(curElem);
    for(char ch : seed.toCharArray()) {
      sb.append(ch);
      findCom(res, input, dict, level + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
