package alg.laioffer.crosstraining1;

import java.util.Arrays;

public class DedupI {
  public int[] dedup(int[] array) {
    if(array.length == 0) return array;
    int s = 0;
    for(int f = 0; f < array.length; f++) {
      if(array[f] != array[s]){
        s++;
        array[s] = array[f];
      }
    }
    return Arrays.copyOf(array,  s + 1);
  }
}

