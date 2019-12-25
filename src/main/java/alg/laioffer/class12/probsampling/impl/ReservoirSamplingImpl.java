package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.ReservoirSampling;

import java.util.Random;

public class ReservoirSamplingImpl implements ReservoirSampling {
  private int count;
  private Integer sample;
  private Random rand;
  public ReservoirSamplingImpl() {
    this.count = 0;
    this.sample = null;
    rand = new Random();
  }

  @Override
  public void read(int value) {
    count++;
    int prob = rand.nextInt(count);
    // the current read val has prob = 1/count to be as current sample
    if(prob == 0) {
      sample = value;
    }
  }

  @Override
  public Integer sample() {
    return sample;
  }
}
