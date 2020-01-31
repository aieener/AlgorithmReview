package alg.audible.impl;

import alg.audible.ValidAnagram;

public class ValidAnagramImpl implements ValidAnagram {
    @Override
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        int charNum = 0;
        String longer = s.length() >= t.length() ? s : t;
        String shorter = s.length() < t.length() ? s : t;

        for(char sChar : longer.toCharArray()) {
            if(map[sChar - 'a'] == 0) {
                charNum++;
            }
            map[sChar - 'a']++;
        }
        for(char tChar : shorter.toCharArray()) {
            if(map[tChar - 'a'] >= 1) {
                if(map[tChar - 'a'] == 1) charNum--;
                map[tChar - 'a']--;
            }
        }
        return charNum == 0;
    }
}
