package Bloomberg_71_leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 2/8/18.
 * LeetCode 20
 * This one has a similar one in LaiCode as well,
 * but instead of finding all possible outputs,
 * this one checks if one is valid
 *
 * Use Stack bingo xiao xiao le
 */

public class ValidParentheses {
    /**
     * the Key is that () [] {} has to be TOGETHER
     * ({[ is fine but (], (}, is NOT ALLOWED!!!
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char ch : s.toCharArray()) {
            if(ch =='(' || ch == '[' || ch =='{') {
                stack.offerFirst(ch);
            }

            if(ch == ')') {
                if(stack.isEmpty() || stack.pollFirst() != '(') {
                    return false;
                }
            }

            if(ch == ']') {
                if(stack.isEmpty() || stack.pollFirst() != '[') {
                    return false;
                }
            }

            if(ch == '}') {
                if(stack.isEmpty() || stack.pollFirst() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // ----------------- prac ------------------------
    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        char [] arr = s.toCharArray();
        for(Character ch : arr) {
            if(ch == '{' || ch == '(' || ch == '[') {
                stack.offerFirst(ch);
            } else {
                if(ch == ')') {
                    if(stack.isEmpty() || stack.pollFirst() != '(') {
                        return false;
                    }
                } else if (ch == '}') {
                    if(stack.isEmpty() || stack.pollFirst() != '{') {
                        return false;
                    }
                } else if (ch == ']') {
                    if(stack.isEmpty() || stack.pollFirst() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
