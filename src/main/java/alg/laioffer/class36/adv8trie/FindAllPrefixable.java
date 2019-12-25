package alg.laioffer.class36.adv8trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FindAllPrefixable {
  List<String> findAllWordsWithPrefix(TrieNode root, String prefix);

  class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public int count; // amt of words are on this subtree

    public TrieNode() {
      children = new HashMap<>();
      count = 0;
    }
  }
}
