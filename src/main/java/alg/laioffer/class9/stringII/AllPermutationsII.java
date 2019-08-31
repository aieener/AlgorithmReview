package alg.laioffer.class9.stringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
  // time O(n!)
  // space O(n + n-1 + n-2 + ... + 1) = O(n^2)
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    permutations(res, 0, set.toCharArray());
    return res;
  }

  private void permutations(List<String> res, int level, char[] input) {
    // base case
    if (level == input.length) {
      res.add(new String(input));
      return;
    }

    Set<Character> handledChars = new HashSet<>();
    for (int i = level; i < input.length; i++) {
      if (!handledChars.contains(input[i])) {
        swap(input, level, i);
        permutations(res, level + 1, input);
        swap(input, level, i);
        handledChars.add(input[i]);
      }
    }
  }


  private void swap(char[] array, int l, int r) {
    char temp = array[l];
    array[l] = array[r];
    array[r] = temp;
  }

  public static void main(String[] args) {
    String input = "aabc";
    System.out.println(new AllPermutationsII().permutations(input));

  }
}
