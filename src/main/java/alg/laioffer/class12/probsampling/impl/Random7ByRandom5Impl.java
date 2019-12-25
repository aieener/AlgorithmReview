package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.Random7ByRandom5;

public class Random7ByRandom5Impl implements Random7ByRandom5 {
  @Override
  public int random7() {
    while(true) {
      int random25 = 5 * RandomFive.random5() + RandomFive.random5();
      if(random25 < 21) {
        /*
          because
            0  1   2  3  4  5  6
            7  8   9 10 11 12 13
            14 15 16 17 18 19 20
            equal chances to get 0 to 7! (prob(0..7) = 3 / 20)
         */
        return random25 % 7;
      }
    }
  }
}
