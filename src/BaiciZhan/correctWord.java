package BaiciZhan;

import java.util.*;

/**
 * Created by yuding on 3/24/18.
 */
public class correctWord {

    public List<String> correctWord(String input, String [] dict) {

        Map<Integer, List<String>> map = new HashMap<>();

        int minDis = Integer.MAX_VALUE;
        for(String str : dict) {
            int dis = editDistance(input, str);
            List<String> curList = map.getOrDefault(dis, new ArrayList<String>());
            curList.add(str);
            map.put(dis, curList);
            if(dis <= minDis){
                minDis = dis;
            }
        }

        System.out.println(map);
        System.out.println(minDis);
        List<String> res = map.get(minDis);
        return res;
    }

    private int editDistance(String input, String str) {
        int [][] M = new int[input.length() + 1][str.length() + 1];
        int m = M.length;
        int n = M[0].length;
        // base case init
        for(int i = 0; i < m; i++) {
            M[i][0] = i;
        }
        for(int j = 0; j < n; j++) {
            M[0][j] = j;
        }

        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j++) {
                if(input.charAt(i-1) == str.charAt(j-1)) {
                    M[i][j] = M[i - 1][j - 1];
                } else {
                    M[i][j] = Math.min(M[i-1][j], M[i][j-1]);
                    M[i][j] = Math.min(M[i][j], M[i-1][j-1]);
                    M[i][j] = M[i][j] + 1;
                }
            }
        }
        return M[m-1][n-1];
    }

    public static void main(String[] args) {
        correctWord cw = new correctWord();
        List<String> res = cw.correctWord("wod", new String[]{"kood","pod","apple", "wodd", "sod", "toood", "cake","bad", "awesome"});
        System.out.println(res);

    }
    /**
     * edit distance c++ version
     * replace cost y, insert/remove cost x
     * int edit(string s1, string s2, int x, int y) {
     *     int n = s2.length() + 1;
     *     int m = s1.length() + 1;
     *     int a[n+1][m+1];
     *
     *     // initialize everything to 0
     *     for(int i = 0; i < n + 1; ++i) {
     *         fill(a[i],a[i] + m + 1, 0);
     *     }
     *
     *     for(int j = 0; j <= m; ++j){
     *          a[0][j] = j * x;
     *     }
     *     for(int i = 0; i <= n; ++i){
     *          a[i][0] = i * x;
     *     }
     *
     *     for(int i = 1; i <=n; i++){
     *         for(int j = 1; j <=m; j++){
     *              int c1 = a[i-1][j-1];
     *              if(s1[i-1] == s2[j-1]){
     *                  c1 = c1 + y;
     *              }
     *              int c2 = a[i-1][j] + x;
     *              int c3 = a[i][j-1] + x;
     *              a[i][j] = min(min(c1,c2),c3);
     *         }
     *     }
     *     return a[n][m]
     * }
     */
}
