package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.WordSearchOne;

public class WordSearchOneImpl implements WordSearchOne {
    @Override
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (dfs(board, 0, word, row, col)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int idxToMatch, String word, int row, int col) {
        // base case
        if (invalid(row, col, board) || board[row][col] == '#') return false;
        if (idxToMatch == word.length() - 1) {
            return board[row][col] == word.charAt(idxToMatch);
        }

        char curChar = board[row][col];
        if (word.charAt(idxToMatch) == curChar) {
            // search
            board[row][col] = '#';
            if (dfs(board, idxToMatch + 1, word, row + 1, col)) return true;
            if (dfs(board, idxToMatch + 1, word, row - 1, col)) return true;
            if (dfs(board, idxToMatch + 1, word, row, col + 1)) return true;
            if (dfs(board, idxToMatch + 1, word, row, col - 1)) return true;
            board[row][col] = curChar;
        }
        return false;
    }

    private boolean invalid(int row, int col, char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        if (row < 0 || row >= rowLen || col < 0 || col >= colLen) return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'a', 'a'}};
        System.out.println(new WordSearchOneImpl().exist(input, "aaa"));
    }
}
