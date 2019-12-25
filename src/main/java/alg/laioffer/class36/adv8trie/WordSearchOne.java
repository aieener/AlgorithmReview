package alg.laioffer.class36.adv8trie;

/*
LeetCode 79
  board =
  [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
  ]

      Given word = "ABCCED", return true.
      Given word = "SEE", return true.
      Given word = "ABCB", return false.
 */
public interface WordSearchOne {
    boolean exist(char[][] board, String word);
}
