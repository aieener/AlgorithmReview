package alg.laioffer.midterm2;

import java.util.Arrays;

/**
 * Created by yuding on 2/9/18.
 * LeetCode 132 Palindrome Partition II DP
 * right small chunk can't be partitioned -- > it must be parlindrom to be valid
 * left Big chunk is know
 *
 * M[i] represents from index 0 to index i, what is the minimum cut needed
 * to do palindrome partition
 * base case M[0] = 0;
 * induction rule: M[i] case 1: 0 if string[0, i] is palindrome
 *                      case 2: M[j] + 1 if string[j + 1, i] is palindrome
 *                      where 1 <= i < strlen
 *                            0 <= j < i
 * Linear Scan. 回头看,看全部
 * To pass leetCode, we need to optimize it to 2D DP
 */
public class cutPalindrome {
    public int minCut (String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }
        int len = input.length();
        int [] M = new int[len];
        for(int i = 1; i < len; i++) {
            if( isParlidrome(input, 0, i)){
                M[i] = 0;
                continue;
            }
            M[i] = i;
            for (int j = 0; j < i; j++) {
                // enumerate all possible right small section
                // we already know M[j],
                // want to find to the right so j + 1
                if(isParlidrome(input, j+1, i)) {
                    M[i] = Math.min(M[i], M[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(M));
        return M[len - 1];
    }

    private boolean isParlidrome(String input, int i, int j) {
        char[] array = input.toCharArray();
        while(i < j) {
            if(array[i] != array[j] ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        cutPalindrome cp = new cutPalindrome();
        String a = "raceecar";
        String input = "aaaaaabbabb";
        System.out.println(cp.minCut(input));
    }

    // ----- prac --------
    /**
     * 2D inPalin[i][j] represent whether substring(i, .., j) is a palindrome
     * 中心开花 , 切木棍, 沙子归并
     */
    // shift one spot
}
