package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.WordSearchTwo;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTwoCharImpl implements WordSearchTwo {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // ascii table has 128 chars: <key = ch - 'a'; value = TrieNode>
        boolean isWord = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0) return res;

        int rowLen = board.length;
        int colLen = board[0].length;

        TrieNode trieDictHead = loadDictionary(words);
        for(int row = 0; row < rowLen; row++) {
            for(int col = 0; col < colLen; col++) {
                dfs(board, trieDictHead, row, col, res, new StringBuilder() );
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode trieNode, int row, int col, List<String> res, StringBuilder sb) {
        if(invalid(board, row, col) || board[row][col] == '#') return ;
        char curVal = board[row][col];
        TrieNode nextTrieNode = trieNode.children[curVal - 'a'];
        if(nextTrieNode == null) return;

        // recursive rule
        sb.append(curVal);
        if(nextTrieNode.isWord) {
            res.add(sb.toString());
            nextTrieNode.isWord = false;
        }
        board[row][col] = '#';
        // 4 branch
        dfs(board, nextTrieNode, row + 1, col, res, sb);
        dfs(board, nextTrieNode, row - 1, col, res, sb);
        dfs(board, nextTrieNode, row, col + 1, res, sb);
        dfs(board, nextTrieNode, row, col - 1, res, sb);

        sb.deleteCharAt(sb.length() - 1);
        board[row][col]= curVal;

    }

    private boolean invalid(char[][]board, int row, int col) {
        int rowLen = board.length;
        int colLen = board[0].length;
        return row < 0 || row >= rowLen || col < 0 || col >= colLen;
    }

    private TrieNode loadDictionary(String[] words) {
        TrieNode root = new TrieNode();
        for(String str : words) {
            loadToTrie(root, str);
        }
        return root;
    }

    private void loadToTrie(TrieNode root, String word) {
        TrieNode curNode = root;
        for(char ch : word.toCharArray()) {
            int curCharIdx = ch - 'a';
            if(curNode.children[curCharIdx] == null) {
                curNode.children[curCharIdx] = new TrieNode();
            }
            curNode = curNode.children[curCharIdx];
        }
        curNode.isWord = true;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };
        char[][] input2 = new char[][]{{'a'}};

//        new WordSearchTwoCharImpl().findWords(input, new String[]{"oath", "pea", "eat", "rain"});

//        new WordSearchTwoCharImpl().findWords(input2, new String[]{"a"});

        System.out.println(new WordSearchTwoCharImpl().parseEmail("test.email+alex@leetcode.com"));
    }

    public String parseEmail(String email) {
        char PLUS = '+';
        char DOT = '.';
        char[] input = email.toCharArray();
        // [0,.. slow) = result
        // [slow ... fast) = buffer zone;
        // [fast .. end) = unexplored
        int slow = 0;
        int fast = 0;
        for(; fast < input.length && input[fast] != '@'; fast++) {
            if(input[fast] == PLUS) {
                while(input[fast] != '@') {
                    fast++;
                }
            } else if (input[fast] != DOT) {
                input[slow++] = input[fast];
            }
        }
        // cpy domain name
        for(; fast < input.length; fast++) {
            input[slow++] = input[fast];
        }
        return new String(input, 0, slow);
    }
}
