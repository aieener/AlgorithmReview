package Bloomberg_71_leetCode;

import java.util.Arrays;

/**
 * CIT 596 HW7
 */
public class MinimumInsertParlindr {
    public int[][] generateMmatrix(String input) {
        /**
         * M[i][j] represent amount of insert need for substring
         * s[i:j]
         *
         * Base case: M[i][i] = 0
         * Induction rule:
         * if(input[i] == input[j])  :  M[i][j] = M[i+1][j-1]
         * else : M[i][j] = min(M[i+1][j], M[i][j-1]) ) + 1
         */

        int[][] M = new int[input.length()][input.length()];

        int space, i, j;
        for(space = 1; space <= input.length(); space++) {
            for(i = 0, j = space; j < input.length(); j++, i++) {
                if(input.charAt(i) == input.charAt(j)) {
                    M[i][j] = M[i+1][j-1];
                } else {
                    M[i][j] = Math.min(M[i+1][j], M[i][j-1]) + 1;
                }
            }
        }
        return M;
    }

    public String getParlindromString(int[][]M, String input ) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = input.length() - 1;
        // egksskge
        while(i <= j) {
            if(input.charAt(i) == input.charAt(j)) {
                sb.insert(0,input.charAt(i));
                sb.append(input.charAt(i));
                i++;
                j--;
            } else if (M[i+1][j] < M[i][j-1]) {
                // go down
                sb.insert(0, input.charAt(i));
                sb.append(input.charAt(i));
                i++;
            } else {
                // if they are the same go left
                // or if M[i+1][j] > M[i][j-1]
                sb.insert(0, input.charAt(j));
                sb.append(input.charAt(j));
                j--;
            }
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumInsertParlindr minInser = new MinimumInsertParlindr();
        int[][] res = minInser.generateMmatrix("geeks");
        for(int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println(minInser.getParlindromString(res, "geeks"));
    }
}
