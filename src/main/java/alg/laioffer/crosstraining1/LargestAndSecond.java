package alg.laioffer.crosstraining1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestAndSecond {
  static class Element {
    int value;
    List<Integer> comparedValue;
    Element(int value) {
      this.value = value;
      this.comparedValue = new ArrayList<>();
    }
  }

  public int[] largestAndSecond(int[] array) {
    Element [] helper = convert(array);
    int largerLen = array.length;
    while(largerLen > 1) {
      compareAndSwap(helper, largerLen);
      largerLen = (largerLen + 1) / 2;
    }
    return new int[] {helper[0].value, largest(helper[0].comparedValue)};
  }

  private void compareAndSwap(Element[] helper, int largerLen) {
    for(int i = 0; i < largerLen / 2; i++) {
      if(helper[i].value < helper[largerLen - i - 1].value) {
        swap(helper, i, largerLen - 1 - i);
      }
      helper[i].comparedValue.add(helper[largerLen - 1 - i].value);
    }
  }

  private int largest(List<Integer> value) {
    int res = value.get(0);
    for(int num : value) {
      res = Math.max(res, num);
    }
    return res;
  }

  private void swap(Element[] helper, int left, int right) {
    Element temp = helper[left];
    helper[left] = helper[right];
    helper[right] = temp;
  }

  private Element[] convert(int[]array){
    Element[] helper = new Element[array.length];
    for(int i = 0; i < array.length; i++) {
      helper[i] = new Element(array[i]);
    }
    return helper;
  }

  public static void main(String[] args) {
    LargestAndSecond core = new LargestAndSecond();
    System.out.println(Arrays.toString(core.largestAndSecond(new int[]{5, 4, 2, 1, 3, 6})));
  }
}
