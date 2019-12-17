package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.RemoveAdjacentRepeatedCharFour;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentRepeatedCharFourStackImpl implements RemoveAdjacentRepeatedCharFour {
    @Override
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        stack.offerFirst(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (stack.isEmpty() || stack.peekFirst() != array[i]) {
                stack.offerFirst(array[i]);
            } else {
                while (i < array.length && stack.peekFirst() == array[i]) {
                    i++;
                }
                stack.pollFirst();
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pollFirst());
        }

        return sb.toString();
    }
}
