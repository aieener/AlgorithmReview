package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.RemoveCertainChars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharsImpl implements RemoveCertainChars {
    @Override
    public String remove(String input, String t) {
        Set<Character> characterSet = new HashSet<>();
        for (Character ch : t.toCharArray()) {
            characterSet.add(ch);
        }
        int slow = 0;
        // [0, slow) will be the result, not including slow
        // [slow, fast) buffer zone
        // [fast, end] unexplored
        char[] inputArr = input.toCharArray();
        for (int fast = 0; fast < inputArr.length; fast++) {
            if (!characterSet.contains(input.charAt(fast))) {
                inputArr[slow++] = inputArr[fast];
            }
        }
        return new String(inputArr, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveCertainCharsImpl().remove("student", "un"));
    }
}
