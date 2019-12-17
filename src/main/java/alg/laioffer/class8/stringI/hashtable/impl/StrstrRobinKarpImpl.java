package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.Strstr;

public class StrstrRobinKarpImpl implements Strstr {
    @Override
    public int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) return 0;
        int largePrime = 101;
        int prime = 31;
        /*
            hash = (s0 * prime ^ k + s1 * prime ^(k - 1) + ... + sk * prime^0) % largePrime
            seed = (prime ^ k + prime^(k-1) + .... + prime ^ 0) % largePrime
         */
        // calc targetHash
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); i++) {
            seed = makeHash(seed, 0, prime, largePrime);
            targetHash = makeHash(targetHash, small.charAt(i), prime, largePrime);
        }

        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = makeHash(hash, large.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && isStrstr(large, small, 0)) return 0;

        for (int i = 1; i <= large.length() - small.length(); i++) {
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime); // 剪掉头
            hash = makeHash(hash, large.charAt(i + small.length() - 1), prime, largePrime); // + 新数再乘prime
            if (hash == targetHash && isStrstr(large, small, i)) return i;
        }
        return -1;
    }

    private int makeHash(int prevHashValue, int newChar, int prime, int largePrime) {
        return (prevHashValue * prime % largePrime + newChar) % largePrime;
    }

    private int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }
        return hash;
    }

    private boolean isStrstr(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StrstrRobinKarpImpl().strstr("hello", "ll"));
    }
}
