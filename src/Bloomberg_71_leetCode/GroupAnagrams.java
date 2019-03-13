package Bloomberg_71_leetCode;

import java.util.*;

/**
 * Feb20
 * LeetCode 49
 * Silimar questoin : All anagrams in LaiOffer
 */
public class GroupAnagrams {
    /**
     * My Sol
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String> > map = new HashMap<>();
        // form map
        for(String curStr : strs) {
            char [] curArr = curStr.toCharArray();
            Arrays.sort(curArr);
            String curKey = new String(curArr);
            List<String> curList = map.getOrDefault(curKey, new ArrayList<String>());
            curList.add(curStr);
            map.put(curKey, curList);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * NineChapt Sol
     * Map.putIfAbsent!!!!!
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = String.valueOf(sc);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String [] input= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(input));
    }

    //----------- prac ------------
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String curStr : strs) {
            char [] arr = curStr.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(curStr);
        }
        return new ArrayList<>(map.values());
    }
}
