package Class_08_StringII;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This one is the Sliding window　硬弹簧
 */
public class AllAnagrams {
    /**
     * MySol Using LaiOffer HashMap method
     */
    public List<Integer> allAnagrams(String s, String l){
        List<Integer> res = new ArrayList<>();
        char[] array = l.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        loadTheMap(map, s);
        int slow = 0;
        int fast = s.length() ; // check[slow, fast)
        // 012345678
        // abcabcabc,  ab
        while(fast <= l.length()){
            Map<Character, Integer> curMap = new HashMap<>(map);
            // deep copy
            for(int i = slow; i < fast;i++) {
                if(curMap.containsKey(array[i])){
                    if(curMap.get(array[i]) == 1){
                        curMap.remove(array[i]);
                    } else {
                        curMap.put(array[i], curMap.get(array[i]) - 1);
                    }
                }
            }
            if(curMap.isEmpty()){
                res.add(slow);
            }
            slow++;
            fast++;
        }
        return res;
    }

    private void loadTheMap(Map<Character, Integer> map, String s){
        char[] array = s.toCharArray();
        for(Character cur : array){
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
    }

    /**
     * LaiOffer Sol
     */
    public List<Integer> allAnagrams2(String s, String l){
        List<Integer> res = new ArrayList<>();
        if(l.length() == 0) {
            return res;
        }

        Map<Character, Integer> map = countMap(s);
        int match = 0;
        for(int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if(count != null) {
                if(count == 1){
                    match++;
                }
                map.put(tmp,count -  1);
            }


            // handle the leftmost char at previous window
            if(i >= s.length()){
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if(count != null) {
                    map.put(tmp, count + 1);
                    if(count == 0) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> countMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            Integer count = map.get(ch);
            if(count == null) {
                map.put(ch,1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        AllAnagrams aa = new AllAnagrams();
        String l = "abcbac";
        String s = "ab";
        List<Integer> res = aa.allAnagrams(s,l);
        System.out.println(res);
    }

    //-------- prac ---------
    public List<Integer> allAnagrams3(String s, String l) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(l.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = cMap(s);
        int match = 0;
        for(int i = 0; i < l.length(); i++) {
            char curChar = l.charAt(i);
            Integer count = map.getOrDefault(curChar, null);
            if(count != null) {
                if(count == 1) {
                    match++;
                }
                map.put(curChar, count - 1);
            }

            /**
             * ab
             * abcabcab
             *       i
             *
             */
            // handle sliding window
            if(i >= s.length()) {
                char leftMostPrev = l.charAt( i - s.length());
                count = map.getOrDefault(leftMostPrev, null);
                if(count != null) {
                    if(count == 0) {
                        match--;
                    }
                    map.put(leftMostPrev, count + 1);
                }

            }
            if(match == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> cMap (String s)  {
        Map<Character, Integer> map  = new HashMap<>();
        for(char ch : s.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        return map;
    }
}
