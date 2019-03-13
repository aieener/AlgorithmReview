package Class_08_StringII;

import java.util.ArrayList;
import java.util.List;

/**
 * This one is HARD
 * Need revisit!! Jan 19
 */
public class StringReplace {
    /**
     * LaiOfferSol
     */
    public String replace(String input, String s, String t) {
        if(s.length() > t.length()){
            return replaceSmall(input, s, t);
        } else {
            return replaceBig(input, s, t);
        }
    }

    private boolean isEqual(char[] input, int idx, String s){
        // this function checks from idx --> if there is a match
        for(int i = 0; i < s.length(); i++) {
            if(input[idx + i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private void copySubstring(char[] input, int idx, String t) {
        for(int i  =0; i < t.length(); i++) {
            input[idx + i] = t.charAt(i);
        }
        return;
    }

    private String replaceSmall(String input, String s, String t) {
        // apple --> cat
        // the original String become shorter
        int slow = 0;
        int fast = 0;
        char[] array = input.toCharArray();

        while(fast < array.length){
            if(fast <= array.length - s.length() && isEqual(array, fast, s)){
                // do the replace
                copySubstring(array,slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                array[slow++] = array[fast++];
            }
        }

        return new String(array, 0, slow);
    }

    private String replaceBig(String input, String s, String t) {
        // cat -- > apple
        // t.len > s.len
        // the original String become longer
        char[] array = input.toCharArray();
        List<Integer> matches = getAllMatches(array, s);
        int len = input.length() + matches.size() * (t.length() - s.length());

        char[] res = new char[len];
        int lastIdx = matches.size() - 1;
        // fast: the pos when traversing the old len
        // slow: the pos when traversing the new len
        int fast = array.length - 1;
        int slow = res.length - 1;

        while(fast >=0){
            if(lastIdx >= 0 && fast == matches.get(lastIdx)){
                copySubstring(res,slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIdx--;
            } else {
                res[slow--] = array[fast--];
            }
        }
        return new String(res);
    }

    private List<Integer> getAllMatches(char[] input, String s) {
        // record all matches of s end position in input
        List<Integer> matches = new ArrayList<>();
        int i = 0;
        while( i <= input.length - s.length()){
            if(isEqual(input, i, s)){
                // end position
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }

    /**
     * LaiOffer Sol2
     * StringBuilder
     */
    public String replce2(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        int matchIdx = input.indexOf(s, fromIndex);
        while(matchIdx != -1) {
            sb.append(input, fromIndex, matchIdx).append(t);
            fromIndex = matchIdx + s.length();
            matchIdx = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        StringReplace sr = new StringReplace();
        String input = "Student";
        String s = "den";
        String t = "xxxx";
        String out  = sr.replace(input, s, t);
        System.out.println(out);
    }
}
