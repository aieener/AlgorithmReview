package Class_07_String_HashTable;

import java.util.HashMap;

/**
 * My bad HashMap sol
 */
public class deDup {
    public  String deDup(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        char [] chararray = input.toCharArray();
        for(Character cur : chararray){
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        StringBuilder res = new StringBuilder();
        for(Character cur : chararray){
            if(map.containsKey(cur) && map.get(cur) > 1){
                map.put(cur, map.get(cur) - 1);
            } else {
                res.append(cur);
            }
        }
        return res.toString();
    }

    /**
     * LaiOffer two pointer Sol
     */

    public String deDupLaiOffer(String input) {
        if(input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for(int i = 0; i < array.length ; i++) {
            if(i == 0 || array[i] != array[end - 1]){
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);

    }

    public static void main(String[] args) {
        deDup rr = new deDup();
        String input = "aaaabbbc";
        String res = rr.deDup(input);
        String res2 = rr.deDup2(input);
        System.out.println(res);
        System.out.println(res2);
    }


    /**
     * I think my two Pointer sol is easier to understand
     */
    public  String deDup2(String input) {
        if(input == null || input.length() == 0) {
            return input;
        }
        char [] chararray = input.toCharArray();
        int right = 0;
        int left = 0;
        while(right != chararray.length) {
            if(chararray[left] == chararray[right]) {
                right++;
            } else {
                left++;
                chararray[left] = chararray[right];
            }
        }
        return new String(chararray, 0, left + 1);
    }

    //----- prac ----
}
