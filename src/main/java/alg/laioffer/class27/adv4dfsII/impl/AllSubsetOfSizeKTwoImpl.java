package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllSubsetOfSizeKTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetOfSizeKTwoImpl implements AllSubsetOfSizeKTwo {
  @Override
  public List<String> subSetsIIOfSizeK(String set, int k) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] inputArr = set.toCharArray();
    Arrays.sort(inputArr);
    dfs(inputArr, res, new StringBuilder(), 0, k);
    return res;
  }

  private void dfs(char[] inputArr, List<String> res, StringBuilder curSol, int curLevel, int k) {
    if (curLevel == inputArr.length || curSol.length() == k) {
      if (curSol.length() == k) res.add(curSol.toString());
      return;
    }
    char curVal = inputArr[curLevel];
    // add
    curSol.append(curVal);
    dfs(inputArr, res, curSol, curLevel + 1, k);
    curSol.deleteCharAt(curSol.length() - 1);

    // not add, skip all curVal
    while (curLevel < inputArr.length && inputArr[curLevel] == curVal) {
      curLevel++;
    }
    dfs(inputArr, res, curSol, curLevel, k);
  }
}
