package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.AutoCompleteSystem;
import alg.laioffer.class36.adv8trie.Trie;
import alg.laioffer.class4.linkedlist.PartitionLL;

import java.util.*;

public class AutoCompleteSystemImpl implements AutoCompleteSystem {
    private final char SPACE = ' ';
    private final char POUND = '#';
    private final char SPACE_IDX = 26;
    private int outputSize = 3;
    private StringBuilder sb;
    private TrieNode root;

    private static class TrieNode {
        TrieNode[] children;
        Integer count; // store num of different words under/including this node
        Integer freq; // if freq > 0, then isWord

        TrieNode() {
            this.children = new TrieNode[27]; // ' ' store and bucket idx = 26
            this.count = 0;
            this.freq = 0;
        }
    }

    private static class Pair {
        String value;
        Integer freq;

        Pair(String value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    private static class MyComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair base, Pair other) {
            if (base.freq > other.freq) return 1;
            else if (base.freq < other.freq) return -1;
            else return other.value.compareTo(base.value);
        }
    }


    public AutoCompleteSystemImpl(String[] sentences, int[] times) {
        this.sb = new StringBuilder();
        this.root = new TrieNode();
        initTrie(sentences, times);
    }

    private void initTrie(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            addToTire(sentences[i], times[i]);
        }
    }

    private void addToTire(String newInput, int freq) {
        TrieNode curNode = root;
        for (Character ch : newInput.toCharArray()) {
            int curChIdx = ch == SPACE ? SPACE_IDX : ch - 'a';
            if (curNode.children[curChIdx] == null) {
                curNode.children[curChIdx] = new TrieNode();
            }
            TrieNode next = curNode.children[curChIdx];
            curNode = next;
            next.count++;
        }
        curNode.freq += freq;
    }

    private void addToTrie(String newInput) {
        addToTire(newInput, 1);
    }

    private List<Pair> findAllWithPrefix(String prefix) {
        List<Pair> res = new ArrayList<>();
        TrieNode curNode = root;
        for (Character ch : prefix.toCharArray()) {
            int curChIdx = ch == SPACE ? SPACE_IDX : ch - 'a';
            if (curNode.children[curChIdx] == null) return res;
            curNode = curNode.children[curChIdx];
        }
        dfs(res, curNode, new StringBuilder(prefix));
        return res;
    }

    private void dfs(List<Pair> res, TrieNode curNode, StringBuilder sb) {
        // base case
        if (curNode.count == 0) {
            return;
        }
        if (curNode.freq > 0) {
            res.add(new Pair(sb.toString(), curNode.freq));
        }

        for (int i = 0; i < curNode.children.length; i++) {
            if (curNode.children[i] != null) {
                if (i == SPACE_IDX) sb.append(' ');
                else {
                    sb.append((char) ('a' + i));
                }
                dfs(res, curNode.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private Queue<Pair> search(String input) {
        // getAll Result
        List<Pair> allPrefix = findAllWithPrefix(input);
        // load top 3 to Queue
        Comparator<Pair> myComparator = new MyComparator();
        Queue<Pair> minHeap = new PriorityQueue<Pair>(myComparator);

        for (Pair word : allPrefix) {
            if (minHeap.size() < outputSize) {
                minHeap.offer(word);
            } else {
                if ( myComparator.compare(minHeap.peek(), word)< 0) {
                    minHeap.poll();
                    minHeap.offer(word);
                }
            }
        }
        return minHeap;
    }


    @Override
    public List<String> input(char c) {
        Queue<Pair> res;
        if (c != POUND) {
            sb.append(c);
            res = search(sb.toString());
        } else {
            addToTrie(sb.toString());
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        while (!res.isEmpty()) {
            output.add(res.poll().value);
        }
        Collections.reverse(output);

        return output;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"c c ccccc", "cc cc cc", "cc cc ccc", "cccc", "ccccc ccc cc ccc", "ccccc ccccc ccc cccc"};
//        String[] input = new String[]{"i love you", "island", "iroman", "i love leetcode"};

        int[] freq = new int[]{1, 1, 1, 1, 1, 1};
//        int[] freq = new int[]{5, 3, 2, 2};
        AutoCompleteSystem ac = new AutoCompleteSystemImpl(input, freq);
        ac.input('c');
    }
}
