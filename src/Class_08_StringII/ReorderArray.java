package Class_08_StringII;

public class ReorderArray {
    /**
     * This one is HARD!!!
     * String Shuffling
     * 123456 --> 142536 (this one is the second direction
     */

    /**
     * Need to Revisit!!! very very good string hard problem!!!!
     * LaiOfferSol
     */
    public int [] reorder(int[] array) {
        if(array.length % 2 == 0){
            reorder(array,0,array.length - 1);
        } else {
            // if the array has odd len, we ignore the last one
            reorder(array,0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int  length = right - left + 1;
        // base case
        if(length <= 2){
            return;
        }
        // calc the mid point
        // 0 1 2 3 4 5 6 7
        // lm: 2, m: 4, rm :6
        // 0 1 2 3 4 5 6 7 8 9
        // lm: 2, m: 5, rm :7

        //step 1 divide the string into 4 almost equal chuncks
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;

        //step 2 swap the inner two chunks (chunck2, chunck3)
        //|..|lmid..|mid..|rmid..|
        reverse(array,lmid, mid - 1); // reverse chunck2
        reverse(array,mid, rmid - 1); // reverse chunck3
        reverse(array,lmid, rmid - 1); // reverse [chunck2,chunck3]
        // this is the I Love Yahoo trick 2 step reverse
        // CDE12 --> 12CDE

        //step 3 recursion(chunck1, chunck3), recursion(chunck2, chunck4)

        // 1   2   3   4
        // l   lm  m   rm  r
        // AB |CDE |12 |345

        // the res is now AB12 CDE345
        // recursively deal with
        // AB12
        reorder(array, left, left + (lmid - left) * 2 - 1);  // C1 + C3
        // CDE345
        reorder(array, left + (lmid - left) * 2, right); // C2 + C4
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    //--- prac ---
    public int[] reorder2(int[] array) {
        int len = array.length;
        if(len % 2 == 0) {
            //even
            reorder2(array, 0, len - 1);
        } else {
            //odd
            reorder2(array, 0, len - 2);
        }
        return array;
    }

    private void reorder2(int[] array, int start, int end){
        // divide the array into 4 chuncks
        // |l..|lm..|m..|rm..r|
        int len = end - start + 1;
        int mid = start + len / 2;
        int lmid = start + len / 4;
        int rmid = start + len * 3 / 4;

        // swap the inner two chunck chuck2 and chunck3
        // the I Love Yahoo trick
        reverse2(array, lmid, mid - 1);
        reverse2(array, mid, rmid - 1);
        reverse2(array, lmid, rmid - 1);

        // recursively call
        // C1 C3
        reorder(array, start, start + (lmid - start) * 2 - 1);
        reorder(array, start + (lmid - start) * 2 , end);
    }

    private void reverse2(int[] array, int start, int end) {
        int l = start;
        int r = end;
        while(l < r) {
            swap2(array,l,r);
            l++;
            r--;
        }
    }

    private void swap2(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
