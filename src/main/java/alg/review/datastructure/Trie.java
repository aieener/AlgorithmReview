package alg.review.datastructure;

import java.util.HashMap;

/**
 * Classical trie with HashMap version
 */
class TrieNode_Hash {
    char c;
    HashMap<Character, TrieNode_Hash> children;
    boolean hasWord;

    public TrieNode_Hash(){
        children = new HashMap<>();
    }

    public TrieNode_Hash(char c){
        children = new HashMap<>();
        this.c = c;
    }
}

public class Trie {
    private TrieNode_Hash root;

    public Trie(){
        root = new TrieNode_Hash();
    }

    // insert word into trie
    public void insert(String word){
        TrieNode_Hash cur = root;
        HashMap<Character, TrieNode_Hash> curChildren = root.children;
        // !!! convert String toCharArray
        char [] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            char wc = wordArray[i]; // current word
            if(curChildren.containsKey(wc)){
                // get the cur triNode;
                cur = curChildren.get(wc);
            } else {
                TrieNode_Hash newNode = new TrieNode_Hash(wc);
                curChildren.put(wc, newNode);
                cur = newNode;
            }
            // proceed curChildren to the next one
            curChildren = cur.children;
            if(i == wordArray.length - 1){
                // the last one
                // will be finish, so let cur hasWord
                cur.hasWord = true;
            }
        }
    }

    // return if word is in the trie
    public boolean search(String word){
        if(searchWordNodePos(word) == null){
            return false;
        } else if (searchWordNodePos(word).hasWord){
            return true;
        } else {
            return false;
        }
    }

    // Return if there is any word in the trie
    // that starts with the given prefix
    public boolean startsWith(String prefix){
        if(searchWordNodePos(prefix) == null){
            return false;
        }
        return true;
    }

    public TrieNode_Hash searchWordNodePos(String s) {
        HashMap<Character, TrieNode_Hash> children = root.children;
        TrieNode_Hash cur = null;
        char [] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}
