package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.RemoveAdjacentRepeatedCharFour;

/*


    bdcccdc -> bccdc -> bdc
      s
          f
 */
public class RemoveAdjacentRepeatedCharFourImpl implements RemoveAdjacentRepeatedCharFour {
    @Override
    public String deDup(String input) {
        if(input == null || input.length() < 1) return input;
        char[] inputArr = input.toCharArray();
        int slow = -1; // simulate a stack
        for(int fast = 0; fast < inputArr.length; fast++) {
            if(slow == -1 || inputArr[fast] != inputArr[slow]) {
                inputArr[++slow] = inputArr[fast];
            } else {
                while(fast+ 1 < inputArr.length && inputArr[fast + 1] == inputArr[slow]) {
                    fast++;
                }
                if(slow >= 0) {
                    slow--;
                }
            }
        }
        return new String(inputArr, 0, slow + 1);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAdjacentRepeatedCharFourImpl().deDup("aa"));
    }
}
