package alg.laioffer.class7.dfs.impl;

import alg.laioffer.class7.dfs.AllPermutationOne;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 4
 * last review : Aug 30, 2019
 * ------ initial review comment ----------
 * Whenever every single permutation contains all elements in the initial input, then
 * you should consider SWAP and SWAP approach
 * ex．　Ｎ个磁铁，某些相互排斥，能不能找出一种排列可以放在箱子里两辆不排斥
 * for (int i = index; i < input.length; i++) {
 * if(do not conflict) { // <--- apply rules here
 * swap(input, index, i);
 * Perm(input, index + 1);
 * swap(input, index, i); //回复母节点状态
 * }
 * }
 * given a string with non dup letters, print out all permutations
 * Last review Mar 13 2019
 * Notes from Class 7_DFS_Sun
 * <p>
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * the length of the input string
 * 2. how many different states should we try to put on this level
 * first layer 3, second 3*2, third 3 * 2 * 1
 * <p>
 * input                        abc
 * L0           a(rem=bc)           b(rem=ac)        c(rem=ba)
 * L1      b(rem=c) c(rem=b)    a(rem=c)  c(rem=a)    ....
 * L2
 * <p>
 * Space = O(n)
 * Time = O(n!)
 */
public class AllPermutationOneImpl implements AllPermutationOne {
  @Override
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    dfs(set.toCharArray(), 0, res);
    return res;
  }

  private void dfs(char[] source, int level, List<String> res) {
    // base case
    if (level == source.length) {
      res.add(new String(source));
      return;
    }

    for (int idx = level; idx < source.length; idx++) {
      swap(source, level, idx);
      dfs(source, level + 1, res);
      swap(source, level, idx);
    }
  }

  private void swap(char[] source, int left, int right) {
    char temp = source[left];
    source[left] = source[right];
    source[right] = temp;
  }
}
