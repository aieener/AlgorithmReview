package Class_07_String_HashTable;

import Vmware.SearchInRotatedSortedArray;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainChar {

  /**
   * Check Sol
   * Two Pointer!
   */
  public String remove(String input, String t) {
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);

    int slow = 0;
    for (int fast = 0 ; fast < array.length; fast++) {
      if( !set.contains(array[fast])) {
        array[slow] = array[fast];
        slow++;
      }
    }

    return new String(array, 0, slow);
  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }

  /**
   * My version (while loop)
   */
  public String remove2(String input, String t) {
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);
    int slow = 0;
    int fast = 0;
    while(fast < array.length) {
      if(!set.contains(array[fast])){
        array[slow] = array[fast];
        slow++;
      }
      fast++;
    }
    return new String(array,0,slow);
  }

  //--- prac ---
  public String remove3(String input, String t) {
    char[] array = input.toCharArray();
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }

    int s = 0; // the answer will be array[0, s-1]
    int f = 0;
    while(f < array.length){
      if(set.contains(array[f])){
        f++;
      } else {
        array[s++] = array[f++];
      }
    }
    return new String(array, 0, s);
  }
}
