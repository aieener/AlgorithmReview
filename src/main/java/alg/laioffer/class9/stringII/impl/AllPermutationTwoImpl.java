package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.AllPermutationTwo;

import java.util.*;

public class AllPermutationTwoImpl implements AllPermutationTwo {
    @Override
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if(input == null) return res;
        char[] inputArr = input.toCharArray();
        dfs(res, inputArr, 0);
        return res;
    }

    private void dfs(List<String> res, char[] input, int level) {
        if (level == input.length) {
            res.add(new String(input));
            return;
        }

        Set<Character> visited = new HashSet<>();
        for (int i = level; i < input.length; i++) {
            if (!visited.contains(input[i])) {
                visited.add(input[i]);
                swap(input, level, i);
                dfs(res, input, level + 1);
                swap(input, level, i);
            }
        }
    }

    private void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
