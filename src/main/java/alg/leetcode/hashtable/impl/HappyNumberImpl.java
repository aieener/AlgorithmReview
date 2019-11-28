package alg.leetcode.hashtable.impl;

import alg.leetcode.hashtable.HappyNumber;

import java.util.HashSet;

public class HappyNumberImpl implements HappyNumber {
    @Override
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        return isHappy(n, visited);
    }

    private boolean isHappy(int n, HashSet<Integer> visited) {
        if (visited.contains(n)) return false;
        visited.add(n);
        int nextNumber = 0;
        while (n > 0) {
            int curDigit = n % 10;
            nextNumber += curDigit * curDigit;
            n /= 10;
        }
        if (nextNumber == 1) return true;
        return isHappy(nextNumber, visited);
    }
}
