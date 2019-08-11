package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.WordLadder;

import java.util.*;

/**
 * BFS : Best first search, Dijkstra
 * preprocessing: dog -> d*g, *og, do*
 * create lkup = {
 *   d*g : dog, dig, ...
 *   *og : dog, hog, ...
 *   ...
 * }
 */
public class WordLadderImpl implements WordLadder {

  public static void main(String[] args) {
    List<String> input = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    String begin = "hit";
    String end = "cog";
    WordLadder wl = new WordLadderImpl();
    System.out.println(wl.ladderLength(begin, end, input));
  }

  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, List<String>> patternLkup = preprocessing(beginWord.length(), wordList);
    return bfs(patternLkup, beginWord, endWord);
  }

  private int bfs(Map<String, List<String>> patternLkup, String beginWord, String endWord) {
    Queue<Word> queue = new LinkedList<>();
    queue.offer(new Word(beginWord, 1));
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int len = beginWord.length();
    while(!queue.isEmpty()) {
      Word nodeToExpand = queue.poll();
      // get neighbors
      String curWord = nodeToExpand.value;
      int curLevel = nodeToExpand.level;
      for(int i = 0; i < nodeToExpand.value.length(); i++) {
        String pattern = getPattern(len, curWord, i);
        if(patternLkup.containsKey(pattern)) {
          for(String targetWord: patternLkup.get(pattern)) {
            if(targetWord.equals(endWord)) return curLevel + 1;
            if(!visited.contains(targetWord)) {
              queue.offer(new Word(targetWord, curLevel + 1));
              visited.add(targetWord);
            }
          }
        }
      }
    }
    return 0;
  }

  private String getPattern(int len, String curWord, int i) {
    return curWord.substring(0, i) + '*' + curWord.substring(i + 1, len);
  }

  private Map<String, List<String>> preprocessing(int len, List<String> wordList) {
    Map<String, List<String>> patternLkup = new HashMap<>();
    for (String word : wordList) {
      for (int i = 0; i < len; i++) {
        String pattern = getPattern(len, word, i);
        List<String> patternWords = patternLkup.getOrDefault(pattern, new ArrayList<>());
        patternWords.add(word);
        patternLkup.put(pattern, patternWords);
      }
    }
    return patternLkup;
  }

  class Word {
    int level;
    String value;
    Word(String value, int level) {
      this.level = level;
      this.value = value;
    }
  }
}
