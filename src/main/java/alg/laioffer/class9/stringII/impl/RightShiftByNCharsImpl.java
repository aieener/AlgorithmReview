package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.RightShiftByNChars;

public class RightShiftByNCharsImpl implements RightShiftByNChars {
    @Override
    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1) return input;

        int firstWordEnd = findNewPos(input.length(), n);
        char[] inputArr = input.toCharArray();
        reverseWord(inputArr, 0, firstWordEnd);
        reverseWord(inputArr, firstWordEnd + 1, input.length() - 1);
        reverseWord(inputArr, 0, input.length() - 1);
        return new String(inputArr);
    }

    // word = input[start, end], including end
    private void reverseWord(char[] input, int start, int end) {
        while (start < end) {
            swap(input, start++, end--);
        }
    }

    private void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    private int findNewPos(int len, int n) {
        /*
            abc 4 --> (3 - 4 - 1) mod len = -2 mod 3 = 1
            in java -2 % 3 = -2 instead of 1, so we do
            (-2 + len) % len = 1 % 3 = 1
         */
        return ((len - n - 1) % len + len) % len + 1;
    }
}
