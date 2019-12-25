package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.MajorityNumThree;

import java.util.*;

public class MajorityNumThreeImpl implements MajorityNumThree {
    @Override
    public List<Integer> majority(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) return res;
        Map<Integer, Integer> candidates = getCandidates(array, k);
        validateCandidatesAndFillToRes(array, k, res, candidates);
        return res;
    }

    private void validateCandidatesAndFillToRes(int[] array, int k, List<Integer> res, Map<Integer, Integer> candidates) {
        for (int curVal : array) {
            if(candidates.containsKey(curVal))
                candidates.put(curVal, candidates.get(curVal) + 1);
        }
        int targetLen = array.length / k;
        for(Map.Entry<Integer, Integer> candidate : candidates.entrySet())  {
            if(candidate.getValue() > targetLen) res.add(candidate.getKey());
        }
    }

    private Map<Integer, Integer> getCandidates(int[] array, int k) {
        Map<Integer, Integer> candidatePool = new HashMap<>();
        int numOfCandidate = k - 1;
        for (int curVal : array) {
            if (candidatePool.size() < numOfCandidate) {
                candidatePool.put(curVal, candidatePool.getOrDefault(curVal, 0) + 1);
            } else {
                proccessCandidateCompetition(candidatePool, curVal);
            }
        }

        for (Map.Entry<Integer, Integer> candidate : candidatePool.entrySet()) {
            candidate.setValue(0);
        }
        return candidatePool;
    }

    private void proccessCandidateCompetition(Map<Integer, Integer> candidatePool, int curVal) {
        if (candidatePool.containsKey(curVal)) {
            candidatePool.put(curVal, candidatePool.get(curVal) + 1);
        } else {
            Set<Integer> removalSet = new HashSet<>();
            for (Map.Entry<Integer, Integer> candidate : candidatePool.entrySet()) {
                if (!removalSet.contains(candidate.getKey())) {
                    candidatePool.put(candidate.getKey(), candidate.getValue() - 1);
                }
                if (candidate.getValue() == 0) {
                    removalSet.add(candidate.getKey());
                }
            }
            // remove invalid ones from candidatePool
            for (int keyToRemove : removalSet) {
                candidatePool.remove(keyToRemove);
            }
        }
    }
}
