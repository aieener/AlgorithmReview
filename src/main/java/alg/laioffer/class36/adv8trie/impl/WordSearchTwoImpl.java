package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.WordSearchTwo;

import java.util.*;

public class WordSearchTwoImpl implements WordSearchTwo {
  @Override
  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    // step 1 build TrieLite & load Trie
    TrieLite trie = new TrieLite();
    load(trie, words);

    // step 2 search on board, look at trie
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        dfs(board, row, col, trie.root, res, new StringBuilder());
      }
    }
    return res;
  }

  private void dfs(char[][] board, int row, int col, TrieNode trieNode, List<String> res, StringBuilder sb) {
    char curChar = board[row][col];
    if (curChar == '#' || trieNode.children.get(curChar) == null) return;

    TrieNode nextNode = trieNode.children.get(curChar);
    int[] deltaRow = new int[]{-1, 1, 0, 0};
    int[] deltaCol = new int[]{0, 0, -1, 1};

    sb.append(curChar);
    if(nextNode.isWord) {
      res.add(sb.toString());
      nextNode.isWord = false;
    }

    board[row][col] = '#'; // mark as visited on this search
    for(int i = 0; i < deltaCol.length; i++) {
      int nextRow = row + deltaRow[i];
      int nextCol = col + deltaCol[i];
      if(inBound(board, nextRow, nextCol)) {
        dfs(board, nextRow, nextCol, nextNode, res, sb);
      }
    }
    board[row][col] = curChar; // back tracking
    sb.deleteCharAt(sb.length() - 1);
  }

  private boolean inBound(char[][] board, int row, int col) {
    int rowLen = board.length;
    int colLen = board[0].length;
    return row >= 0 && row < rowLen && col >= 0 && col < colLen;
  }

  private void load(TrieLite trie, String[] words) {
    for (String word : words) {
      trie.insert(word);
    }
  }

  static class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    TrieNode() {
      this.children = new HashMap<>();
      this.isWord = false;
    }
  }

  static class TrieLite {
    private TrieNode root;

    TrieLite() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode curNode = this.root;
      for(Character ch : word.toCharArray()) {
        TrieNode next = curNode.children.get(ch);
        if(next == null) {
          next = new TrieNode();
          curNode.children.put(ch, next);
        }
        curNode = next;
      }
      curNode.isWord = true;
    }
  }
}
