package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.GeneralizedReservoirSampling;

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
      int prob = rand.nextInt(count); // prob = [0, totalSize)
      // [0--------(K-1)]K ----
      // probToEvictAndAdd = k / totalSize,
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
