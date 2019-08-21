package alg.laioffer.class14.probandsampling.impl;

import alg.laioffer.class14.probandsampling.PerfectShuffle;

import java.util.Random;

public class PerfectShuffleImpl implements PerfectShuffle {
  @Override
  public void shuffle(int[] array) {
    Random rand = new Random();
    for(int i = 0; i < array.length; i++) {
      int randIdx = i + rand.nextInt(array.length - i);
      swap(array, randIdx, i);
    }
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
