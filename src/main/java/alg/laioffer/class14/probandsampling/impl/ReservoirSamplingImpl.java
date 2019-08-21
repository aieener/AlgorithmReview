package alg.laioffer.class14.probandsampling.impl;

import alg.laioffer.class14.probandsampling.ReservoirSampling;

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
    if(prob == 0) {
      sample = value;
    }
  }

  @Override
  public Integer sample() {
    return sample;
  }
}
