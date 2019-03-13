package Class_07_String_HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MissingNum {
    /**
     * Many Sols!
     * Sol 1: HashSet
     */
    public int missing(int[] array) {
        Set<Integer> set = new HashSet<>();
        int n = array.length + 1;

        for(int num : array){
            set.add(num);
        }
        for(int i = 1; i < n; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n;
    }

    /**
     * Sol 2: use sum
     */

    public int missingII(int[] array) {
        int n = array.length + 1;
        long targetSum = (n + 0L) * (n + 1) / 2;
        long actualSum = 0L;
        for(int num : array) {
            actualSum += num;
        }
        return (int) (targetSum - actualSum);
    }

    /**
     * Sol 3: bit operation
     */
    public int missingIII(int [] array) {
        int n = array.length + 1;
        int xor = 0;
        for(int i = 1; i <= n; i++) {
            xor ^= i;
        }
        // after this operation, all num from 1 to n
        // are pair xor'ed except for the missing number
        // since x^x = 0, the remaining num is the result
        for(int num : array) {
            xor ^= num;
        }
        return xor;
    }

    // ---- prac ---
    public int missing2(int [] array) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++ ) {
            set.add(array[i]);
        }
        for(int i = 1; i < array.length + 1; i++ ){
            if(!set.contains(i)){
                return i;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args) {
        System.out.println("lalal");
    }
}
