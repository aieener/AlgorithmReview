package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class14.dp2.EditDistance;

public class EditDistanceImpl implements EditDistance {

    @Override
    public int editDistance(String one, String two) {
        int M[][] = new int[one.length() + 1][two.length() + 1];
        // base case
        for (int i = 0; i < one.length() + 1; i++) {
            M[i][0] = i;
        }
        for (int i = 0; i < two.length() + 1; i++) {
            M[0][i] = i;
        }

        for (int oneIdx = 1; oneIdx < one.length() + 1; oneIdx++) {
            for (int twoIdx = 1; twoIdx < two.length() + 1; twoIdx++) {
                if (one.charAt(oneIdx - 1) == two.charAt(twoIdx - 1)) {
                    M[oneIdx][twoIdx] = M[oneIdx - 1][twoIdx - 1];
                } else {
                    int delTwo = M[oneIdx][twoIdx - 1] + 1;
                    int delOne = M[oneIdx - 1][twoIdx] + 1;
                    int replace = M[oneIdx - 1][twoIdx - 1] + 1;
                    M[oneIdx][twoIdx] = Math.min(replace, Math.min(delTwo, delOne));
                }
            }
        }
        return M[one.length()][two.length()];
    }
}
