package Class_01;

/**
 * Need to practice more for this problem!!
 * Focus on the mid pointer K
 */
// left side of i is -1
// right side of j is 1
// parts between i and k are 0
// between k and j are unexplored
public class RainbowI {
    public int[] rainbowSort(int[] array){
        if(array.length == 0){
            return array;
        }

        int i = 0;
        int j = array.length - 1;
        int k = 0;
        while(k <= j){
            if(array[k] == -1){
                // swap i, k;
                // when swapping i and k the elem at i
                // has to be 0, thus k will ++
                swap(array, i, k);
                i++;
                k++; // [i,k) not including k are 0
            } else if (array[k] == 0){
                k++;
            } else {
                // swap k, j
                swap(array, j, k);
                j--;
            }
        }
        return array;
    }

    private void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //--- prac ---
    public int[] rainbowSort2(int[] array) {
        if(array == null || array.length == 0) {
            return array;
        }
        // 3 pointer semantics:
        // s: to the left of s: [0, s) are -1
        // f: to the right of f: [f, end] are 1
        // m: between m and s: [s, m) are 0
        // between m and f are unexplored
        // 1 0 1 -1 0
        // -1 0 0 1 1
        //    s
        //        m
        //      f
        int s = 0;
        int m = 0;
        int f = array.length - 1;
        while(m <= f){
            if(array[m] == -1) {
                swap2(array,s,m);
                s++;
                m++;
            } else if(array[m] == 1){
                swap2(array,f,m);
                f--;
            } else {
                m++;
            }
        }
        return array;
    }

    private void swap2(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
