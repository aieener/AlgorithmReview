package alg.laioffer.class36.trie.impl;

import alg.laioffer.class36.trie.Trie;

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
    for(int i = 0; i < word.length(); i++) {
      TrieNode next = curNode.children.get(word.charAt(i));
      if(next == null) {
        next = new TrieNode();
        curNode.children.put(word.charAt(i), next);
      }
      curNode = next;
      curNode.count++;
    }
    curNode.isWord = true;
  }

  @Override
  public boolean search(String word) {
    TrieNode curNode = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = curNode.children.get(word.charAt(i));
      if (next == null) return false;
      curNode = next;
    }
    return curNode.isWord;
  }

  @Override
  public boolean startsWith(String prefix) {
    TrieNode curNode = root;
    for(int i = 0; i < prefix.length(); i++) {
      TrieNode next = curNode.children.get(prefix.charAt(i));
      if(next == null) return false;
      curNode = next;
    }
    return curNode.count > 0;
  }

  @Override
  public boolean delete(String word) {
    if(!search(word)) return false;
    TrieNode curNode = root;
    for(int i = 0; i < word.length(); i++) {
      TrieNode next = curNode.children.get(word.charAt(i));
      next.count--;
      if(next.count == 0) {
        curNode.children.remove(word.charAt(i));
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
