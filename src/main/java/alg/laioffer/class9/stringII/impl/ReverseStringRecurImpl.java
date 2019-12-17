package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.ReverseString;

public class ReverseStringRecurImpl implements ReverseString {
    @Override
    public String reverse(String input) {
        char[] inputArr = input.toCharArray();
        recur(inputArr, 0);
        return new String(inputArr);
    }

    private void recur(char[] input, int level) {
        if (level == input.length / 2) {
            return;
        }
        swap(input, level, input.length - 1 - level);
        recur(input, level + 1);
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
