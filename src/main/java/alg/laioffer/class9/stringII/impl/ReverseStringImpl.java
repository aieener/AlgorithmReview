package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.ReverseString;

public class ReverseStringImpl implements ReverseString {
    @Override
    public String reverse(String input) {
        if (input == null || input.length() <= 1) return input;
        char[] inputArr = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            swap(inputArr, start++, end--);
        }
        return new String(inputArr);
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
