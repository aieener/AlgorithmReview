package CIT_596.HW_7;


import java.util.Arrays;

/**
 * Created by yuding on 3/26/18.
 *
 * AABCDEBAZ
 * AABCDEDCBAAZ
 *            i
 *  j
 * ABEBA
 *     k
 *
 *     ameena
 *
 *       i
 *       j
 *
 *     aeea
 *        k
 *
 *  GEEKSFORGROFSKEEKS
 *                  i
 *  j
 *
 *  EEGEE
 *      k
 *
 */
public class Q6_LPSeq {
    public String parlindromicInsersion(String input) {
        /**
         * first find the longest palindromic subsequence
         * then insert the chars that does not appear at
         * this palindromic subsequence at both sides
         */
        char[] strArray = input.toCharArray();
        char[] longestParSeq = findLongestParlindromicSubsequence(strArray);
        System.out.println(strArray);
//        System.out.println(strArray.length);
        System.out.println(longestParSeq);
//        System.out.println(longestParSeq.length);
        int lenOfFinalRes = strArray.length + strArray.length - longestParSeq.length;
        int midOfLength = longestParSeq.length / 2;

        StringBuilder ResArraysb = new StringBuilder(input);
        int curLen = ResArraysb.length();
        int k = midOfLength; // ptr operate on longestParSeq
        int i = 0 ; // ptr operate on ResArraysb
        int j = curLen - 1 ; // ptr operate on ResArraysb
        while(ResArraysb.charAt(i) != longestParSeq[k] &&
                ResArraysb.charAt(j) != longestParSeq[k]) {
            i++;
            j--;
        }
//        if(ResArraysb.charAt(i) == longestParSeq[k]) {
//            j = i;
//        } else {
//            i = j;
//        }
        // now both i and j are pointing the center char of longestParSeq
        if(lenOfFinalRes % 2 ==0) {
            // if lenOfFinalRes is even, i++
            i++;
        }


        boolean fin = false;

        System.out.println(k);
        System.out.println(i);
        System.out.println(j);
        while( !fin && i < lenOfFinalRes && j > 0) {
            if(ResArraysb.charAt(i) == ResArraysb.charAt(j)) {
                i++;
                j--;
                if(k < longestParSeq.length - 1){
                    k++;
                } else {
                    fin = true;
                }
            } else {
                if( ResArraysb.charAt(j) != longestParSeq[k]) {
                    // insert at i side
                    char charToInsert = ResArraysb.charAt(j);
                    ResArraysb.insert(i, charToInsert);
                    i++;
                    j--;
                } else {
                    // insert at j side
                    char charToInsert = ResArraysb.charAt(i);
                    ResArraysb.insert(j + 1, charToInsert);
                    i++;
                    i++;
                }
            }
        }
        /**
         * post processing
         */

        while(j > 0) {
            // insert at i side
            char charToInsert = ResArraysb.charAt(j);
            ResArraysb.insert(i, charToInsert);
            i++;
            j--;
        }
        j = 0;
        while( i < lenOfFinalRes - 1) {
            // insert at j side
            char charToInsert = ResArraysb.charAt(i);
            ResArraysb.insert(j, charToInsert);
            i++;
            if(i == lenOfFinalRes - 1) {
                break;
            } else {
                i++;
            }
        }

        return ResArraysb.toString();
    }

    public char[] findLongestParlindromicSubsequence(char[] input) {
        StringBuilder LPS[][] = new StringBuilder[input.length][input.length ];

        // base case: fill diagnol M[i][i] as input[i]
        for(int i = 0; i < input.length; i++) {
            LPS[i][i] = new StringBuilder();
            LPS[i][i].append(input[i]);
        }

        /**
         * induction rule:
         * only consider i > j cause its symmetric
         * if input[i] = input[j] and cl = 2 (center of parlindrome)
         *      LPS[i][j] = 2;
         * else if input[i] = input[j]: LPS[i][j] = LPS[i+1][j-1] + 2
         * else LPS[i][j] = max(LPS[i][j-1], LPS[i+1][j])
         */
        for(int cl = 2; cl < input.length + 1; cl++) {
            for(int i = 0; i < input.length - cl + 1 ; i++) {
                int j = i + cl - 1;
                if( cl == 2 && input[i] == input[j] ) {
                    LPS[i][j] = new StringBuilder();
                    LPS[i][j].append(input[j]);
                    LPS[i][j].append(input[j]);
                } else if(input[i] == input[j]) {
                    LPS[i][j] = new StringBuilder(LPS[i+1][j-1]);
                    LPS[i][j].insert(0,input[i]);
                    LPS[i][j].append(input[i]);
                } else {
                    if(LPS[i][j-1].length() > LPS[i+1][j].length()) {
                        LPS[i][j] = new StringBuilder(LPS[i][j-1]);
                    } else {
                        LPS[i][j] = new StringBuilder(LPS[i+1][j]);
                    }
                }
            }
        }

        for( StringBuilder [] sb : LPS) {
            System.out.println(Arrays.toString(sb));
        }

        return LPS[0][input.length-1].toString().toCharArray();
    }

    public static void main(String[] args) {
        Q6_LPSeq sol = new Q6_LPSeq();
//        String s1 = "AABCDEBAZ";
//        String s1 = "ameena";
//        String s1 = "GEEKSFORGEEKS";
        String s1 = "federer";
//        String s1 = "eee";
//        String s1 = "GEEKSFAORGEEKS";
        System.out.println(sol.parlindromicInsersion(s1));
//        System.out.println(sol.parlindromicInsersion(s1).length());
    }
}
