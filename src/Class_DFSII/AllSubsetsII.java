package Class_DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * all Subsets with Dups
 * add a or not add a
 */
public class AllSubsetsII {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    StringBuilder sb = new StringBuilder();
    char[] input = set.toCharArray();
    Arrays.sort(input);
    System.out.println(input);
    subSet(input, res, 0, sb);
    return res;
  }

  private void subSet(char[] input, List<String> res, int level, StringBuilder sb) {
    // base case
    if (level == input.length) {
      res.add(sb.toString());
      return;
    }
    //add
    sb.append(input[level]);
    subSet(input, res, level + 1, sb);
    sb.deleteCharAt(sb.length() - 1);


    // my version
//    if (level > 0 && input[level] == input[level - 1]) {
//      if (sb.length() > 0 && sb.charAt(sb.length() - 1) == input[level]) {
//        return;
//      }
//    }

    // laioffer version
    while (level < input.length - 1 && input[level] == input[level + 1]) {
      level++;
    }
    // not add
    subSet(input, res, level + 1, sb);
  }

  public static void main(String[] args) {
    String input = "abab";
    System.out.println(new AllSubsetsII().subSets(input).toString());
  }
}
