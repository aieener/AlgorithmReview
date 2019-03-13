package Class_07_String_HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CommonNumof2Array {
    /**
     * My Sol
     */
    public List<Integer> common(List<Integer> A, List<Integer>B){
        HashMap<Integer, Integer> map = new HashMap(); //<val, freq>
        List<Integer> res = new ArrayList<>();
        for(Integer num : A) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(Integer num : B) {
            if(map.containsKey(num)){
                res.add(num);
                if(map.get(num) > 1){
                    map.put(num, map.get(num) - 1);
                } else {
                    map.remove(num);
                }
            }
        }
        return res;
    }

    /**
     * Sol 2: laiOffer
     * Two Pointer
     */
    public List<Integer> commonI(int[] a, int [] b) {
        List<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]){
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    //--- prac ---
    public List<Integer> common2 (List<Integer> A, List<Integer> B ) {
        // two pointer
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while( i < A.size() && j < B.size()){
            if(A.get(i) < B.get(j)){
                i++;
            } else if(A.get(i) > B.get(j)){
                j++;
            } else if (A.get(i) == B.get(j)){
                res.add(A.get(i));
                i++;
                j++;
            }
        }
        return res;
    }
}


