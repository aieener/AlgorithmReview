package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllSubsetsOfSizeK;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeKImpl implements AllSubsetsOfSizeK {
  public static void main(String[] args) {
    AllSubsetsOfSizeK engine = new AllSubsetsOfSizeKImpl();
    System.out.println(engine.subSetsOfSizeK("kjpfe", 3));
  }

  @Override
  public List<String> subSetsOfSizeK(String set, int k) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    dfs(res, set, k, 0, new StringBuilder());
    return res;
  }

  private void dfs(List<String> res, String set, int k, int curLevel, StringBuilder curSol) {
    //base case
    if (curSol.length() == k || curLevel == set.length()) {
      if (curSol.length() == k) {
        res.add(curSol.toString());
      }
      return;
    }

    // add cur
    curSol.append(set.charAt(curLevel));
    dfs(res, set, k, curLevel + 1, curSol);
    curSol.deleteCharAt(curSol.length() - 1);

    // not add cur
    dfs(res, set, k, curLevel + 1, curSol);
  }
}
