package alg.laioffer.class12.probsampling;

import java.util.Random;

public interface Random7ByRandom5 {
  public int random7();
  static class RandomFive {
    static private Random rand = new Random();
    static public int random5() {
      return rand.nextInt(5);
    }
  }
}
