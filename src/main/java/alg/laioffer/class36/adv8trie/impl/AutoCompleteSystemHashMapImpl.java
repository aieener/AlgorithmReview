package alg.laioffer.class36.adv8trie.impl;

import alg.laioffer.class36.adv8trie.AutoCompleteSystem;

import java.util.*;

public class AutoCompleteSystemHashMapImpl implements AutoCompleteSystem {
    private static class MyComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair base, Pair other) {
            if (base.freq > other.freq) return 1;
            else if (base.freq < other.freq) return -1;
            else return other.value.compareTo(base.value);
        }
    }

    private final char POUND = '#';
    private int outputSize = 3;
    private StringBuilder sb;
    private TrieNode root;

    private static class TrieNode {
        Map<Character, TrieNode> children;
        Integer count; // store num of different words under/including this node
        Integer freq; // if freq > 0, then isWord

        TrieNode() {
            this.children = new HashMap<>();
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


    public AutoCompleteSystemHashMapImpl(String[] sentences, int[] times) {
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
            if (curNode.children.get(ch) == null) {
                curNode.children.put(ch, new TrieNode());
            }
            TrieNode next = curNode.children.get(ch);
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
            if (curNode.children.get(ch) == null) return res;
            curNode = curNode.children.get(ch);
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

        for (Map.Entry<Character, TrieNode> entry : curNode.children.entrySet()) {
            sb.append(entry.getKey());
            dfs(res, entry.getValue(), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private Queue<Pair> search(String input) {
        // getAll Result
        List<Pair> allPrefix = findAllWithPrefix(input);
        Comparator<Pair> myComparator = new MyComparator();
        // load top 3 to Queue
        Queue<Pair> minHeap = new PriorityQueue<Pair>(myComparator);

        for (Pair word : allPrefix) {
            if (minHeap.size() < outputSize) {
                minHeap.offer(word);
            } else {
                if (myComparator.compare(minHeap.peek(),word) < 0) {
                    minHeap.poll();
                    minHeap.offer(word);
                }
            }
        }
        return minHeap;
    }

    public List<String> input(char c) {
        Queue<Pair> res;
        if (c != POUND) {
            sb.append(c);
            res = search(sb.toString());
        } else {
            String newStr = sb.toString();
            addToTrie(newStr);
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
}
