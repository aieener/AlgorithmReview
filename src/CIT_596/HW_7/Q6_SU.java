package CIT_596.HW_7;

public class Q6_SU {
    public void minInsertion(String input) {
        if (input == null || input.length() == 0) {
            System.out.println("Invalid input");
        }

        if (input.length() == 1) {
            System.out.println(input);
        } else {
            int[][] palindromeTable = helper(input.toCharArray(), input.length());
            String res = buildPalindrome(palindromeTable, input.toCharArray());
            System.out.println(palindromeTable[0][input.length() - 1]);
            System.out.println("This is the length: " + res.length());
            System.out.println(res);
        }
    }


    private int[][] helper(char[] charArray, int length) {

        int dp[][] = new int[length][length];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < length; gap++) {
            for (l = 0, h = gap; h < length; l++, h++) {
                if (charArray[l] == charArray[h]) {
                    dp[l][h] = dp[l + 1][h - 1];
                } else {
                    dp[l][h] = Math.min(dp[l][h - 1], dp[l + 1][h]) + 1;
                }
            }
        }
        return dp;
    }

    private String buildPalindrome(int[][] palindromeTable, char[] input) {
        char[] result = new char[input.length + palindromeTable[0][input.length - 1]];
        int i = 0;
        int j = input.length - 1;
        int resultl = 0;
        int resultr = result.length - 1;
        while (i <= j) {
            if (input[i] == input[j]) {
                result[resultl] = input[i];
                result[resultr] = input[j];
                i++;
                j--;
            } else if (palindromeTable[i + 1][j] < palindromeTable[i][j - 1]) {
                result[resultl] = input[i];
                result[resultr] = input[i];
                i++;
            } else {
                result[resultl] = input[j];
                result[resultr] = input[j];
                j--;
            }
            resultl++;
            resultr--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            sb.append(result[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q6_SU solution = new Q6_SU();
        solution.minInsertion("ameena");
        solution.minInsertion("federer");
        solution.minInsertion("geeksforgeeks");
        solution.minInsertion("ab");
    }
}
