package alg.penn.blackstone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuding on 2/7/18.
 * find elems in A but not in B
 */
public class DeDupTwoArray {
    public List<Integer> uncommon(List<Integer> A, List<Integer>B){
        Set<Integer> aNum = new HashSet<>();

        for(Integer a : A) {
            aNum.add(a);
        }

        for(Integer b : B) {
            if(aNum.contains(b)) {
                aNum.remove(b);
            }
        }
        return new ArrayList<>(aNum);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        List<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(6);
        B.add(7);
        B.add(8);
        DeDupTwoArray dd = new DeDupTwoArray();

        System.out.print(dd.uncommon(A,B));
    }
}
