package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.ILoveYahoo;

public class ILoveYahooImpl implements ILoveYahoo {
    /*
        I Love Yahoo
     */
    @Override
    public String reverseWords(String input) {
        if (input == null || input.length() <= 1) return input;
        int slow = 0;
        int fast = 0;
        char[] inputArr = input.toCharArray();
        for (; fast < input.length(); fast++) {
            if(inputArr[fast] == ' ') {
                reverseWord(inputArr, slow, fast - 1);
                slow = fast + 1;
            }
        }
        reverseWord(inputArr, slow, fast - 1); // don't forget reverse the last word
        reverseWord(inputArr, 0, input.length() - 1);
        return new String(inputArr);
    }

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
}
