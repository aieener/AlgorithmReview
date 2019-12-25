package alg.laioffer.class12.probsampling;

import java.util.Random;

public interface Random1000UsingRandom5 {
    int random1000();
    static class RandomFive {
        static private Random rand = new Random();
        static public int random5() {
            return rand.nextInt(5);
        }
    }
}
