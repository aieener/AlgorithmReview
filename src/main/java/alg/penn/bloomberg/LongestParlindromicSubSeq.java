package alg.penn.bloomberg;

public class LongestParlindromicSubSeq {
    /**
     * j - 1 ---> 左
     * i + 1 ---> 下
     */

    public int longestPalindromeSubseq(String s) {
        int LPS [][] = new int[s.length()][s.length()];

        int space, i, j;
        for(i = 0; i < s.length(); i++) {
            LPS[i][i] = 1;
        }

        for(space = 1; space <= s.length() ; space++) {
            for(i = 0, j = space; j < s.length(); j++, i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    LPS[i][j] = LPS[i+1][j-1] + 2;
                } else {
                    LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);
                }
            }
        }

        return LPS[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestParlindromicSubSeq lp = new LongestParlindromicSubSeq();
        int res = lp.longestPalindromeSubseq("fererer");
        System.out.println(res);

    }
}
