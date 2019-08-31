package alg.laioffer.class31.adv5.dp.rainwater;

public class LongestCommonSubsequence {
    class Pair{
        public int len;
        public StringBuilder sb;
        public Pair(int l, StringBuilder s) {
            len = l;
            sb = s;
        }
    }

    /**
     * return the String
     * @param s
     * @param t
     * @return
     */
    public String longestCommon(String s, String t) {
        /**
         * M[i][j] represent the longest in s[0:i] and t[0:j]
         * base case M[i][0] = 0
         * base case M[0][j] = 0
         * M[i][j] = M[i - 1][j - 1] + 1; if s[i] = t[j]
         *         = max (M[i-1][j], M[i][j-1])
         *     S t r i n g
         *     0 0 0 0 0 0
         * S 0 1 1 1 1 1 1
         * p 0 1 1 1 1 1 1
         * r 0
         * i 0
         * n 0
         * g 0
         */
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        Pair [][] M = new Pair [s.length() + 1][t.length() + 1];
        M[0][0] = new Pair(0,new StringBuilder());
        for(int i = 1; i < M.length; i++) {
            M[i][0] = new Pair(0,new StringBuilder());
        }
        for(int j = 1; j < M[0].length; j++) {
            M[0][j] = new Pair(0,new StringBuilder());
        }

        for(int i = 1; i < M.length; i++) {
            for(int j = 1; j < M[0].length; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    Pair curPair = M[i-1][j-1];
                    int newLen = curPair.len + 1;
                    StringBuilder newSb = new StringBuilder(curPair.sb);
                    newSb.append(s.charAt(i-1));
                    M[i][j] = new Pair(newLen, newSb);
                } else {
                    if(M[i-1][j].len > M[i][j-1].len) {
                        M[i][j] = M[i-1][j];
                    } else{
                        M[i][j] = M[i][j-1];
                    }
                }
            }
        }
        return M[M.length - 1][M[0].length - 1].sb.toString();
    }

    /**
     * return the len
     */
    public int longest(String s, String t) {

        if(s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int [][] M = new int [s.length() + 1][t.length() + 1];
        M[0][0] = 0;
        for(int i = 1; i < M.length; i++) {
            M[i][0] = 0;
        }
        for(int j = 1; j < M[0].length; j++) {
            M[0][j] = 0;
        }

        for(int i = 1; i < M.length; i++) {
            for(int j = 1; j < M[0].length; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    M[i][j] = M[i-1][j-1] + 1;
                } else {
                    if(M[i-1][j] > M[i][j-1]) {
                        M[i][j] = M[i-1][j];
                    } else{
                        M[i][j] = M[i][j-1];
                    }
                }
            }
        }
        return M[M.length - 1][M[0].length - 1];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence lc = new LongestCommonSubsequence();
        System.out.println(lc.longestCommon("aaaaaa", "bbaaba"));
        System.out.println(lc.longest("aaaaaa", "bbaaba"));
    }
}
