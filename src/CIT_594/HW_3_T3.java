package CIT_594;

import java.util.*;

/**
 * Created by yuding on 3/25/18.
 */
public class HW_3_T3 {
    public List<String> getVals(HashMap<Integer, String> map) {
        List<String> res = new ArrayList<>();
        for(String str : map.values()) {
            res.add(str);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        HW_3_T3 h3 = new HW_3_T3();
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "a");
        map.put(3, "cae");
        map.put(4, "Base");
        map.put(5, "fafdsa");
        System.out.println(h3.getVals(map));

    }
}
