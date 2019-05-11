package alg.laioffer.class7.stringI.hashtable;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainChar {
  public String remove(String input, String t) {
    Set<Character> targetSet = makeSet(t);

    int fast = 0;
    int slow = 0;
    char [] inputArr = input.toCharArray();
    for(; fast < inputArr.length; fast++) {
       if(!targetSet.contains(inputArr[fast])) {
        inputArr[slow++] = inputArr[fast];
      }
    }
    return new String(inputArr, 0, slow);
  }

  private Set<Character> makeSet(String input) {
    Set<Character> set = new HashSet<>();
    char[] inputArr = input.toCharArray();
    for (char cur : inputArr) {
      set.add(cur);
    }
    return set;
  }

}
