package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.Trie;

import java.util.HashMap;
import java.util.Map;


public class TrieImpl implements Trie {
  TrieNode root;

  public TrieImpl() {
    root = new TrieNode();
  }

  @Override
  public void insert(String word) {
    TrieNode curNode = root;
    for (Character ch : word.toCharArray()) {
      TrieNode next = curNode.children.get(ch);
      if (next == null) {
        next = new TrieNode();
        curNode.children.put(ch, next);
      }
      curNode = next;
      curNode.count++;
    }
    curNode.isWord = true;
  }

  @Override
  public boolean search(String word) {
    TrieNode curNode = root;
    for (Character ch : word.toCharArray()) {
      TrieNode next = curNode.children.get(ch);
      if (next == null) return false;
      curNode = next;
    }
    return curNode.isWord;
  }

  @Override
  public boolean startsWith(String prefix) {
    TrieNode curNode = root;
    for (Character ch : prefix.toCharArray()) {
      TrieNode next = curNode.children.get(ch);
      if (next == null) return false;
      curNode = next;
    }
    return curNode.count > 0;
  }

  @Override
  public boolean delete(String word) {
    if (!search(word)) return false;
    TrieNode curNode = root;
    for (Character ch : word.toCharArray()) {
      TrieNode next = curNode.children.get(ch);
      next.count--;
      if (next.count == 0) {
        curNode.children.remove(ch);
      }
      curNode = next;
    }
    curNode.isWord = false;
    return true;
  }

  static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    int count; // amt of words are on this subtree

    TrieNode() {
      children = new HashMap<>();
      count = 0;
    }
  }
}
