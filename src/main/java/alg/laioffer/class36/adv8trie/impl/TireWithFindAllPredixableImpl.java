package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.FindAllPrefixable;
import alg.laioffer.class36.adv8trie.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TireWithFindAllPredixableImpl implements Trie, FindAllPrefixable {
  private TrieNode root;

  public TireWithFindAllPredixableImpl() {
    root = new TrieNode();
  }

  @Override
  public List<String> findAllWordsWithPrefix(TrieNode root, String prefix) {
    List<String> res = new ArrayList<>();
    // step 1 find the Node
    TrieNode startNode = findStartNode(prefix);
    if (startNode == null) return res;
    // step 2 do dfs on curNode to find all
    findAll(startNode, new StringBuilder(prefix), res);
    return res;
  }

  private void findAll(TrieNode startNode, StringBuilder sb, List<String> res) {
    // base case;
    if (startNode.isWord) {
      res.add(sb.toString());
    }

    // recur rule
    for (Map.Entry<Character, TrieNode> childEntry : startNode.children.entrySet()) {
      sb.append(childEntry.getKey());
      findAll(childEntry.getValue(), sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private TrieNode findStartNode(String prefix) {
    TrieNode curNode = this.root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode next = root.children.get(prefix.charAt(i));
      if (next == null) return null;
      curNode = next;
    }
    return curNode;
  }

  @Override
  public void insert(String word) {
    TrieNode curNode = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = root.children.get(word.charAt(i));
      if (next == null) {
        next = new TrieNode();
        root.children.put(word.charAt(i), next);
      }
      curNode = next;
      curNode.count++;
    }
    curNode.isWord = true;
  }

  @Override
  public boolean search(String word) {
    TrieNode curNode = findStartNode(word);
    if (curNode == null) return false;
    return curNode.isWord;
  }

  @Override
  public boolean startsWith(String prefix) {
    TrieNode curNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode next = root.children.get(prefix.charAt(i));
      if (next == null) {
        return false;
      }
      curNode = next;
    }
    return curNode.count > 0;
  }

  @Override
  public boolean delete(String word) {
    if (!search(word)) return false;
    TrieNode curNode = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = root.children.get(word.charAt(i));
      next.count--;
      if (next.count == 0) {
        curNode.children.remove(word.charAt(i));
      }
      curNode = next;
    }
    curNode.isWord = false;
    return true;
  }
}
