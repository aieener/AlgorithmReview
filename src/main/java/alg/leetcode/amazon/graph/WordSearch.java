package alg.leetcode.amazon.graph;

/**
 *board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * WordSearchII is at Trie section of LaiOffer
 */
public interface WordSearch {
  public boolean exist(char[][] board, String word);
}
