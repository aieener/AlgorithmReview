package CIT_596.HW_7;

/**
 * Time complexity: T(n) = O(n^2)
 * Since for this DP approach, we have to traverse
 * half of a n by  n matrix to fill the 2D table M[][]
 * Hence time cost would be O(n^2)
 */

public class Q6 {
    public String findMinInsertions(String input) {
        char[] charArray = input.toCharArray();
        int n = charArray.length;

        /**
         *
         * semantics of M[i][j]:
         * M[i][j] represents the optimal solution for a substring of input,
         * starting at index and ending at index j.
         *
         * Base Case: M[i][j] = 0 if i >= j
         *
         * Induction rule:
         * if charArray[i] = charArray[j]
         *      M[i][j] = M[i+1, j-1]
         * else
         *      M[i][j] = min (M[i+1,j],c[i, j-1]) + 1
         */
        StringBuilder res = new StringBuilder();
        int M[][] = new int [n][n];
        int i, j, space;
        // here space is the window size ,
        // for example: if input is abcd:
        //   space = 1: a, b, c, d
        //   space = 2: ab, bc, cd
        //   space = 3: abc, bcd
        //   space = 4: abcd

        for (space = 1; space < n; space++) {
            for (i = 0, j = space; j < n; i++, j++) {
                if (charArray[i] == charArray[j]) {
                    M[i][j] = M[i+1][j-1];
                } else {
                    if(M[i+1][j] < M[i][j-1]) {
                        M[i][j] = M[i+1][j] + 1;
                    } else {
                        M[i][j] = M[i][j-1] + 1;
                    }
                }
            }
        }

        // Now using this Matrix M, we can trace back
        // to form the parlindrome String

        i = 0;
        j = charArray.length - 1;
        while(i <= j) {
            if(charArray[i] == charArray[j]) {
                res.append(charArray[i]);
                res.insert(0,charArray[i]);
                i++;
                j--;
            } else if (M[i+1][j] < M[i][j-1]) {
                res.append(charArray[i]);
                res.insert(0,charArray[i]);
                i++;
            } else {
                res.append(charArray[j]);
                res.insert(0,charArray[j]);
                j--;
            }
        }
        return res.toString();
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Q6 sol = new Q6();
//        String str= "geaks";  // sgkeekgs
//        String str= "geas";  // sgkeekgs
        String str= "fererer";  // sgkeekgs
//        String str= "abcde";  // sgkeekgs
//        String str= "geeksforgeeks";
//        String str= "appleple";
//        String str = "GEEKSFAORGEEKS";
        System.out.println(sol.findMinInsertions(str));
    }
}
