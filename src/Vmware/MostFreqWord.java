package Vmware;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuding on 1/20/18.
 */
public class MostFreqWord {
    public String mosFrq(String[] in) {
        if(in == null || in.length == 0) {
            return null;
        }
        Map<String, Integer> map = countWords(in);
        String res = null;
        int maxFreq = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
    private Map<String, Integer> countWords(String[] in) {
        Map<String, Integer> res  =new HashMap<>();
        for(String cur: in) {
            if(res.containsKey(cur)){
                res.put(cur, res.get(cur) + 1);
            } else {
                res.put(cur, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String []in = new String[]{"A",  "A","BB" , "BB", "CC"};
        MostFreqWord mw = new MostFreqWord();
        String res = mw.mosFrq(in);
        System.out.print(res);
    }

}
