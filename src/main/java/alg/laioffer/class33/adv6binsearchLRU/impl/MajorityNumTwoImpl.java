package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.MajorityNumTwo;

import java.util.*;

/*
    Time O(n)
    Space (1)
 */
public class MajorityNumTwoImpl implements MajorityNumTwo {
    static class Majority {
        int val, count;
        public Majority(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    @Override
    public List<Integer> majority(int[] array) {
        List<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) return res;
        Majority candidateOne = new Majority(0, 0);
        Majority candidateTwo = new Majority(0, 0);
        // as long as count is 0, it will be treat as invalid candidate

        getCandidateValues(array, candidateOne, candidateTwo);

        return getMajority(array, res, candidateOne, candidateTwo);
    }

    private List<Integer> getMajority(int[] array, List<Integer> res,
                                      Majority candidateOne, Majority candidateTwo) {
        for(int curVal : array) {
            if(curVal == candidateOne.val) candidateOne.count++;
            if(curVal == candidateTwo.val) candidateTwo.count++;
        }
        int targetLen = array.length / 3;
        if(candidateOne.count > targetLen) res.add(candidateOne.val);
        if(candidateTwo.count > targetLen) res.add(candidateTwo.val);
        Collections.sort(res);
        return res;
    }

    private void getCandidateValues(int[] array, Majority candidateOne, Majority candidateTwo) {
        for (int curVal : array) {
            if(candidateOne.val == curVal) {
                candidateOne.count++;
            } else if (candidateTwo.val == curVal) {
                candidateTwo.count++;
            } else if(candidateOne.count == 0) {
                candidateOne.val = curVal;
                candidateOne.count = 1;
            } else if (candidateTwo.count == 0) {
                candidateTwo.val = curVal;
                candidateOne.count = 1;
            } else {
                candidateOne.count--;
                candidateTwo.count--;
            }
        }

        candidateOne.count = 0;
        candidateTwo.count = 0;
    }
}
