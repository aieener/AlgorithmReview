package alg.laioffer.class6.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * * Sun: DFS comes from AI, to
 * Recursion vs DFS
 * DFS, in more general scope, it is one kind of search alg
 * DFS can be implemented in either recursive way or in iterate way
 * <p>
 * Back-tracking vs DFS (back-traking is like a nickname)
 * Back-tracking describes the behavior of DFS (From AI Books)
 * <p>
 * DFS 一定是在一个recur里面调用自己两次或两次以上
 * this is due to Von Nioman architecture that is single threaded
 * 一个叉的树跑，其他的挂起, 一头扎到底， 触底反弹
 * <p>
 * 最大的DFS鼻祖题: printTreePreOrder use recursion! DFS EX 0
 * <p>
 * DFS 基本方法：
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * 2. how many different states should we try to put on this level
 */

/**
 * DFS EX 4
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
public class AllPermutation {
  // in class sol swap swap trick
  // when delete letter, DON't Delete letter in the middle!!! O(n) expensive !

  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    permutations(res, 0, set.toCharArray());
    return res;
  }

  private void permutations(List<String> res, int level, char[] input) {
    // base case
    if (level == input.length) {
      res.add(new String(input));
    }

    for (int i = level; i < input.length; i++) {
      swap(input, level, i);
      permutations(res, level + 1, input);
      swap(input, level, i);
    }
  }

  private void swap(char[] input, int l, int r) {
    char buf = input[l];
    input[l] = input[r];
    input[r] = buf;
  }

  public static void main(String[] args) {
    AllPermutation ap = new AllPermutation();
    String input = "abc";
//        List<String> res = ap.permutation(input);
//        List<String> res2 = ap.permutationsWithOrder(input);
////        List<String > res3 = ap.permutationsLai(input);
    System.out.println(ap.permutations(input));
//        System.out.println(res2);
  }
}
