package Class_07_String_HashTable;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

public class deDupIV {
    /**
     * My Sol with LaiOffer method
     * Using a stack
     */
    public String deDup(String input) {
        if(input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        stack.addFirst(array[i]);
        i++;

        while(i != array.length) {
            if(stack.isEmpty() || stack.peekFirst() != array[i]){
                stack.addFirst(array[i]);
                i++;
            } else {
                while(i != array.length &&
                        stack.peekFirst() == array[i]){
                    i++;
                }
                stack.pollFirst();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pollFirst());
//            sb.append(stack.pollFirst());
        }
//        sb.reverse();
        return sb.toString();
    }

    /**
     * LaiOffer Sol
     */
    public String deDup2(String input) {
        if(input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        int end = 0;
        for(int i = 1; i < array.length; i++) {
            if(end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                end--;
                while(i + 1 < array.length && array[i] == array[i + 1]){
                    i++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }

    public static void main(String[] args) {
        deDupIV dd = new deDupIV();
        String input = "abbbaaccz";
        String res = dd.deDup3(input);
        System.out.println(res);
    }

    // --- prac ---
    // 2 ptr version
    public String deDup3(String input) {
        if(input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int f = 1;
        int s = 0;
        while( f < array.length) {
            if(s == -1 || array[s] != array[f]){
                s++;
                array[s] =array[f];
            } else {
                s--;
                while(f + 1 < array.length && array[f] == array[f + 1]){
                    f++;
                }
            }
            f++;
        }
        return new String (array, 0, s + 1);
    }
}
