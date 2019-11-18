package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllPermutationsOfSubsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsOfSubsetsSwapImpl implements AllPermutationsOfSubsets {

  @Override
  public List<String> allPermutationsOfSubsets(String str) {
    Set<String> res = new HashSet();    //deduplicate
    char[] arr = str.toCharArray();
    getPerm(arr, 0, res);
    return new ArrayList<>(res);
  }

  public void getPerm(char[] arr, int idx, Set<String> res) {
    if (idx == arr.length) {
      res.add(new String(arr));
      return;
    }

    for (int i = idx; i < arr.length; i++) {    //start from 档板
      swap(arr, i, idx);

      res.add(new String(arr, 0, i)); //档板之前的substring 加入结果

      getPerm(arr, idx + 1, res);
      swap(arr, i, idx);
    }
  }

  private void swap(char[] input, int l, int r) {
    char temp = input[l];
    input[l] = input[r];
    input[r] = temp;
  }
}
