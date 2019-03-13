package Class_06_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 没思路， 参考了答案， 需要重做 Jan 2
 * 需要再多思考几遍！
 */
public class ValidParentheses {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        // the final string contains 2n char
        char[] cur = new char[n * 2];
        helper(cur, n, n, 0, result);
        return result;
    }

    // left: how many ( we sill have
    // right: how many ) we still have
    // index: the cur position we want to fill in with

    private void helper(char[] cur, int left, int right, int index
    , List<String> result){
        // the termination condition
        if(left ==0 && right == 0) {
            result.add(new String(cur));
            return;
        }

        // when we can add a ( ? whenever there is some ( we can still use!
        if(left > 0){
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }

        // when we can add a ) ? when there is more ( than ) used!
        if(right > left) {
           cur[index] = ')';
           helper(cur,left, right - 1, index + 1, result);
        }


        // why even there is no back tracking, the code is till working?
        /**
         * 1. we are setting the char at index and when back tracking, what we need
         * is just 1) remove the char at index and 2) add a different char at index
         * 2. only when we fill in all the position in cur, we have a complete solution
         *
         * The code itself actually already suffices the above two points and is already does
         * the correct removing operation when back tracked to the previous level
         */
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        List<String> res = vp.validParentheses(3);
        List<String> res1 = vp.generateParenthesis(3);
        System.out.println(res);
        System.out.println(res1);
    }

    // --- prac ---
    public List<String> generateParenthesis(int n) {
        List<String > res = new ArrayList<>();
        char[] sol = new char[2*n];
        helper2(sol, res, n, n, 0);
        return res;
    }
    private void helper2(char[] sol, List<String> res, int l, int r, int index) {
        // base case
        if(l == 0 && r == 0) {
            res.add(new String(sol));
        }

        if(l > 0) {
            sol[index] = '(';
            helper2(sol, res, l - 1, r, index + 1);
        }

        if(r > 0 && r > l) {
            sol[index] = ')';
            helper2(sol, res, l, r - 1, index + 1);
        }
    }
    //--------------------------------------------

}
