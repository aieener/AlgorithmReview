package alg.laioffer.class1.recursion;

import java.util.Arrays;


public class MoveZeros {
  public int[] moveZero(int[] array) {
    // basically the same as remove space
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] != 0) {
        array[slow++] = array[fast];
      }
    }

    for (; slow < array.length; slow++) {
      array[slow] = 0;
    }
    return array;
  }


  public static void main(String[] args) {
    MoveZeros sol = new MoveZeros();
    int[] array = new int[]{1, 2, 0, 3, 4, 0, 2, 3, 0, 0, 8};
    array = sol.moveZero(array);
    System.out.println(Arrays.toString(array));
  }

}
