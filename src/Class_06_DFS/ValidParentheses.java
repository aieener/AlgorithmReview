package Class_06_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS EX 2
 * Last Review Mar 13 2019
 * subset 升级版， 加A不加A 加上了 validation
 * () () () find all valid permutation using the parenthesis provided
 * valid for any ), there must have one ( to match it
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * 6 levels, each level represents each position ---> base case controls this
 * 2. how many different states should we try to put on this level
 * 2 branches either use ( or ) ----> function body controls this
 *
 * If not container like array, maybe there is no need to back-track!
 * T = O(2^2n)
 * S = O(2n)
 * 没思路， 参考了答案， 需要重做 Jan 2
 * 需要再多思考几遍！
 */
public class ValidParentheses {
    // in class example n = 3 ,l ( r )
    private void DFS(int n, int l, int r, StringBuilder solPrefix) {
        // n == 3, l == 0, r == 0
        if (l + r == 2 * n) {
            // base case
            System.out.println(solPrefix);
            return;
        }

        if (l < n) {
            solPrefix.append("(");
            DFS(n, l + 1, r, solPrefix);
            solPrefix.deleteCharAt(solPrefix.length() - 1);
        }

        if (l > r) {
            solPrefix.append(")");
            DFS(n, l, r + 1, solPrefix);
            solPrefix.deleteCharAt(solPrefix.length() - 1);
        }
    }

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
            , List<String> result) {
        // the termination condition
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }

        // when we can add a ( ? whenever there is some ( we can still use!
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }

        // when we can add a ) ? when there is more ( than ) used!
        if (right > left) {
            cur[index] = ')';
            helper(cur, left, right - 1, index + 1, result);
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
        System.out.println(res);
    }

    // --- prac ---

    //--------------------------------------------

}
