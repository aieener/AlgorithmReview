package alg.penn.bloomberg;

/**
 * LeetCode 208: Need revisit!! Important data structure
 * Bai Ci zhan should be familiar with this!
 * Created by yuding on 2/13/18.
 * Application: autocomplete
 *              spell checker
 *              IP routing (longest prefix match
 *              T9 predictive text
 *              Solving word games
 * Trie is a rooted tree, and it's node has
 */

class TrieNode{
    private TrieNode[] links;
    private final int R = 26; // 26 chars
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put (char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * start from root, check char of the wort to insert
     * Two cases:
     *      1. A link exist, go to next child level
     *      2. A link does not exist, create a new node
     *          and link it with the parent's link matching
     *          the current key char
     *  Time  O(m)
     *  Space O(m), worst case that inserted key don't share prefix
     * */

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char curChar = word.charAt(i);
            if(!node.containsKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar); // go to next Node
        }
        node.setEnd();
    }

    /**
     * examine the current node for a link corresponding to the key
     *  A. if exist, move to next node and go on
     *  B. not exist. if there are no available key char left and cur
     *      node is marked as isEnd, then return true; Otherwise false
     *  Time : O(m), where m is the len of word
     *  space: O(1)
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if(!node.containsKey(curChar)) {
                return null;
            }
            node = node.get(curChar);
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix.
     *  Time : O(m), where m is the len of word
     *  space: O(1)
     * */

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}


