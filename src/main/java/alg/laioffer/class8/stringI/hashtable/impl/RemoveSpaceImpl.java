package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.RemoveSpace;

public class RemoveSpaceImpl implements RemoveSpace {
    @Override
    public String removeSpaces(String input) {
        boolean isFirstWord = true;
        int slow = 0;
        char[] inputArr = input.toCharArray();
        /*
            __I____Love__MTV__ --> I_Love_MTV
            s
            f
            [0, s) = res
            [s,f) = buffer zone
            [f,end] = unexplored
         */
        for (int fast = 0; fast < inputArr.length; fast++) {
            if (inputArr[fast] != ' ') {
                if (isFirstWord) {
                    isFirstWord = false;
                } else {
                    inputArr[slow++] = ' ';
                }
            }
            while (fast < inputArr.length && inputArr[fast] != ' ') {
                inputArr[slow++] = inputArr[fast++];
            }

        }
        return new String(inputArr, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveSpaceImpl().removeSpaces("    I       LOVE      YAHOO"));
    }
}
