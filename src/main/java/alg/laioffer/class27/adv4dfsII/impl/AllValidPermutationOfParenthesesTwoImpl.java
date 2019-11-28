package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllValidPermutationsOfParenthesesTwo;

import java.util.*;

public class AllValidPermutationOfParenthesesTwoImpl implements AllValidPermutationsOfParenthesesTwo {
    @Override
    public List<String> validParentheses(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> countMap = getCountMap(l, m, n);
        Deque<Character> stack = new LinkedList<>();
        dfs(countMap, res, new StringBuilder(), stack, 2 * (l + m + n));
        return res;
    }

    private void dfs(Map<Character, Integer> countMap, List<String> res, StringBuilder curSol, Deque<Character> stack, int height) {
        if (curSol.length() == height) {
            res.add(curSol.toString());
            return;
        }
        int i = 0;
        Character prevChar = ' ';
        for (Character curChar : countMap.keySet()) {
            if (i % 2 == 0) {
                // add left parentheses
                if (countMap.get(curChar) > 0) {
                    curSol.append(curChar);
                    stack.offerFirst(curChar);
                    countMap.put(curChar, countMap.get(curChar) - 1);
                    dfs(countMap, res, curSol, stack, height);
                    curSol.deleteCharAt(curSol.length() - 1);
                    stack.pollFirst();
                    countMap.put(curChar, countMap.get(curChar) + 1);
                }
            } else {
                // add right parentheses
                if (!stack.isEmpty() && stack.peekFirst() == prevChar) {
                    curSol.append(curChar);
                    stack.pollFirst();
                    countMap.put(curChar, countMap.get(curChar) - 1);
                    dfs(countMap, res, curSol, stack, height);
                    curSol.deleteCharAt(curSol.length() - 1);
                    stack.offerFirst(prevChar);
                    countMap.put(curChar, countMap.get(curChar) + 1);
                }
            }
            prevChar = curChar;
            i++;
        }
    }

    private Map<Character, Integer> getCountMap(int l, int m, int n) {
        Map<Character, Integer> res = new LinkedHashMap<>();
        res.put('(', l);
        res.put(')', l);
        res.put('<', m);
        res.put('>', m);
        res.put('{', n);
        res.put('}', n);
        return res;
    }
}
