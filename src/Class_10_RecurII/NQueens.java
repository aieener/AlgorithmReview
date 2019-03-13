package Class_10_RecurII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 2/2/18.
 * Recursion row by row | DFS: recur inside a for loop ---> 100% DFS
 * Base case: the last row is done, 0 row left
 * Recursion rule: iff position(i,j) valid -> go to next row :(i + 1)
 *
 * Time(n^n) -- > O(n!)
 */
public class NQueens {
    public List<List<Integer>> nqueens(int n) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        if(n == 1) {
            sol.add(0);
            res.add(sol);
            return res;
        }
        helper(res, sol,n);
        return res;
    }
    private void helper( List<List<Integer>> res, List<Integer> sol,  int n) {
        if(sol.size() == n) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for(int i = 0; i < n; i++) { // i: 当前层的colPos
            // at row rowNum and col try to insert queen
            if(check(sol, i)) {
                sol.add(i);
                helper(res, sol, n);
                sol.remove(sol.size() - 1);
            }
        }
    }

    private boolean check(List<Integer> sol, int col) {
        // it is garanteed that each row has only one Q, so we just check
        // if there is conflict on col and dig
        int row = sol.size();
        for(int i = 0; i < row; i++ ) {
            if(sol.get(i) == col || Math.abs(sol.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<Integer>> res = nq.nqueens(8);
        System.out.print(res);
    }

    //--------- prac --------------

    public List<List<Integer>> nqueens2(int n) {
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        helper2(res, sol, n);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> sol, int n) {
        // base case
        if(sol.size() == n) {
            // all layers has been filled
            res.add(new ArrayList<Integer>(sol));
        }

        // DFS
        for (int i = 0; i < n; i++) {
            if(check2(sol, i)) {
                sol.add(i);
                helper2(res, sol, n);
                sol.remove(sol.size() - 1);
            }
        }
        return;
    }

    private boolean check2(List<Integer> sol, int colPos) {
        int rowPos = sol.size();
        for(int i = 0; i < sol.size(); i++) {
            // sol.get(i) stands for pos(row:i; col:sol.get(i))
            if(colPos == sol.get(i) || Math.abs(i - rowPos) == Math.abs(sol.get(i) - colPos) ) {
                return false;
            }
        }
        return true;
    }
}
