package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.FactorCombinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorCombinationsImpl implements FactorCombinations {
  public static void main(String[] args) {
    FactorCombinations engine = new FactorCombinationsImpl();
    System.out.println(engine.combinations(24).toString());
  }

  @Override
  public List<List<Integer>> combinations(int target) {
    List<Integer> factors = findAllFactors(target);
    Collections.sort(factors);
    return findCombinations(factors, target);
  }

  private List<List<Integer>> findCombinations(List<Integer> factors, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (target == 1) return res;
    dfs(res, new int[factors.size()], 0, target, factors);
    return res;
  }

  private List<Integer> parseSol(int[] sol, List<Integer> factors) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < factors.size(); i++) {
      for (int j = 0; j < sol[i]; j++) {
        res.add(factors.get(i));
      }
    }
    return res;
  }

  private void dfs(List<List<Integer>> res, int[] curSol, int level, int remaining, List<Integer> factors) {
    if (level == factors.size() || remaining == 1) {
      if (remaining == 1) {
        res.add(parseSol(curSol, factors));
      }
      return;
    }

    int curFactor = factors.get(level);
    int numOfDivision = getNumOfDivision(remaining, curFactor);

    for (int i = 0; i <= numOfDivision; i++) {
      curSol[level] = i;
      int newRemain = divideNTimes(remaining, i, curFactor);
      dfs(res, curSol, level + 1, newRemain, factors);
    }
  }

  private int getNumOfDivision(int remaining, int curFactor) {
    int numOfDivision = 0;
    int remainingCpy = remaining;
    while (remainingCpy % curFactor == 0) {
      remainingCpy /= curFactor;
      numOfDivision++;
    }
    return numOfDivision;
  }

  private int divideNTimes(int input, int n, int factor) {
    for (int i = 0; i < n; i++) {
      input = input / factor;
    }
    return input;
  }

  private List<Integer> findAllFactors(int target) {
    List<Integer> res = new ArrayList<>();
    int right = target;
    for (int left = 1; left < right; left++) {
      if (target % (left + 1) == 0) {
        right = target / (left + 1);
        if (left < right) {
          res.add(left + 1);
          if (right != left + 1) res.add(right);
        }
      }
    }
    return res;
  }
}
