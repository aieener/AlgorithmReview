package alg.laioffer.crosstraining1;

import java.util.Arrays;

public class MoveZeroII {
  public int[] moveZero(int[] array) {
    int slow = -1;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] != 0) {
        array[++slow] = array[fast];
      }
    }
    slow++;
    for (; slow < array.length; slow++) {
      array[slow] = 0;
    }
    return array;
  }

  public int[] moveZeroII(int[] array) {
    int slow = 0; // not including slow, (0, slow) are non-zero
    int fast = 0;
    for (; fast < array.length; fast++) {
      if (array[fast] != 0) {
        swap(array, fast, slow++);
      }
    }
    return array;
  }

  private void swap(int[] array, int l, int r) {
    int temp = array[l];
    array[l] = array[r];
    array[r] = temp;
  }

  public static void main(String[] args) {
    MoveZeroII engine = new MoveZeroII();
    engine.moveZeroII(new int[]{0, 0, 1, 1, 0, 1, 0});
  }
}
