package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class8.stringI.hashtable.Strstr;
import alg.laioffer.class9.stringII.StrReplace;

import java.util.HashSet;
import java.util.Set;

/**
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 * <p>
 * last review Dec 14
 */

public class StrReplaceImpl implements StrReplace {
    public static void main(String[] args) {
        String input = "greenlanduzbekistanaustraliadominicabrazil";
        String source = "brazil";
        String target = "slovenia";
        System.out.println(new StrReplaceImpl().replace(input, source, target));
    }

    @Override
    public String replace(String input, String source, String target) {
        if (input == null || input.length() == 0) return input;
        if (source.length() >= target.length()) return replaceSourceLonger(input, source, target);
        return replaceTargetLonger(input, source, target);
    }

    private String replaceTargetLonger(String input, String source, String target) {

        /*
            laicodelaicode --> laiofferlaioffer
             findSubstition end spot : 6, 13
             padding laicodedoglaicode__
                                       s
                                     f
             substitute laicodedoglaicoffer
                                   <-s
                                  <-f
         */
        char[] inputArr = input.toCharArray();
        // find substition end spot
        Set<Integer> subsSet = findSubstitutionEndIdx(inputArr, source);
        // make padding arr
        int padLen = subsSet.size() * (target.length() - source.length());
        char[] resArr = makePaddingCharArr(inputArr, padLen);
        // do substitution
        return reverseSubstitude(resArr, subsSet, target, source, padLen);
    }

    private String reverseSubstitude(char[] resArr, Set<Integer> subsSet, String target, String source, int padLen) {
        int slow = resArr.length - 1;
        int fast = resArr.length - 1 - padLen;
        for (; fast >= 0; fast--) {
            if (subsSet.contains(fast)) {
                substitude(resArr, slow - target.length() + 1, target);
                slow -= target.length();
                fast -= source.length() - 1;
            } else {
                resArr[slow--] = resArr[fast];
            }
        }
        return new String(resArr);
    }

    private char[] makePaddingCharArr(char[] oriInput, int padLen) {
        char[] res = new char[padLen + oriInput.length];
        for (int i = 0; i < oriInput.length; i++) {
            res[i] = oriInput[i];
        }
        return res;
    }

    private Set<Integer> findSubstitutionEndIdx(char[] input, String source) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <= input.length - source.length(); i++) {
            if (strstr(input, i, source)) res.add(i + source.length() - 1);
        }
        return res;
    }

    private String replaceSourceLonger(String input, String source, String target) {
        /*
            semantic: [0, s] result
                      (s,f) gabbage
                      [f, end] unexplored
         */
        char[] inputArr = input.toCharArray();
        int slow = 0;
        int fast = 0;
        for (; fast < input.length(); fast++) {
            if (strstr(inputArr, fast, source)) {
                substitude(inputArr, slow, target);
                slow += target.length();
                fast += source.length() - 1;
            } else {
                inputArr[slow++] = inputArr[fast];
            }
        }
        return new String(inputArr, 0, slow);
    }

    private void substitude(char[] input, int start, String target) {
        for (int i = 0; i < target.length(); i++) {
            input[start + i] = target.charAt(i);
        }
    }

    // test if input[start, start + other.length() - 1] == other
    private boolean strstr(char[] input, int start, String other) {
        if (start + other.length() > input.length) return false;
        for (int i = 0; i < other.length(); i++) {
            if (input[start + i] != other.charAt(i)) return false;
        }
        return true;
    }
}
