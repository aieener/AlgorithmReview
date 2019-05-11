package alg.laioffer.class1.recursion;

import java.util.Arrays;

/**
 * Need to practice more for this problem!!
 * Focus on the mid pointer K
 */
// left side of i is -1
// right side of j is 1
// parts between i and k are 0
// between k and j are unexplored
public class RainbowI {
  public int[] rainbowSort(int[] array) {
    if (array.length == 0) return array;
    /**
     * at left of left : -1
     * at right of right : 1
     * betweeen left and mid is 0;
     * mid to end: unexplored
     */
    int left = 0;
    int mid = 0;
    int right = array.length - 1;
    while( mid <= right) {
      if(array[mid] == -1) {
        swap(array, left, mid);
        left++;
        mid++;
      } else if (array[mid] == 0) {
        mid++;
      } else {
        swap(array, right, mid);
        right--;
      }

    }
    return array;
  }


  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    int[] input = new int[]{1,0,1,-1,0};
    System.out.println(Arrays.toString(new RainbowI().rainbowSort(input)));
  }
}
