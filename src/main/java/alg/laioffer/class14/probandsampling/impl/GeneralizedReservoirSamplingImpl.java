package alg.laioffer.class14.probandsampling.impl;

import alg.laioffer.class14.probandsampling.GeneralizedReservoirSampling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneralizedReservoirSamplingImpl implements GeneralizedReservoirSampling {
  private final int k;
  List<Integer> result;
  private Random rand;
  private int count;

  public GeneralizedReservoirSamplingImpl(int k) {
    this.k = k;
    this.count = 0;
    this.rand = new Random();
    result = new ArrayList<>();
  }

  @Override
  public void read(int value) {
    count++;
    if (count <= k) {
      result.add(value);
    } else {
      int prob = rand.nextInt(count);
      if (prob < k) {
        result.set(prob, value);
      }
    }
  }

  @Override
  public List<Integer> sample() {
    return result;
  }
}
