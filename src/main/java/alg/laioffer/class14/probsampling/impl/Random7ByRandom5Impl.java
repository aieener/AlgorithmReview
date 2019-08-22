package alg.laioffer.class14.probsampling.impl;

import alg.laioffer.class14.probsampling.Random7ByRandom5;

public class Random7ByRandom5Impl implements Random7ByRandom5 {
  @Override
  public int random7() {
    while(true) {
      int random25 = 5 * RandomFive.random5() + RandomFive.random5();
      if(random25 < 21) {
        return random25 % 7;
      }
    }
  }
}
