package alg.penn.forusall;


class Pair{
    int idx, value;
    public Pair(int idx , int value) {
        this.idx = idx;
        this.value = value;
    }
}
/**
 * I did this one Wrong, this one is ask to count the Maxmum distance
 * of a exclusive pair in an unsorted array
 *
 *   int []array = new int[] {1,4,7,3,3,5}; should return 4 because (0,4)
 *   1,3,3,4,5,7
 *   is an exclusive pair and dis = 4 which is the maximum
 */
public class SecOne {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length == 0) {
            return -1;
        }
        Pair[] B = new Pair[A.length];
        for(int i = 0; i < A.length; i++) {
            B[i].idx = i;
            B[i].value = A[i];
        }
        Pair[] sortB = sort(B);

        int globalMax = -1;
        for(int i = 0, j = 1; j < B.length; i++, j++) {
//            int localMax =

        }
        return globalMax;
    }
    public Pair[] sort(Pair[] array) {
        if(array == null || array.length == 0) {
            return array;
        }

        for(int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i; j < array.length; j++) {
                if(array[j].value < array[minIdx].value){
                    minIdx = j;
                }
            }
            swap(array,i,minIdx);
        }
        return array;
    }

    private void swap(Pair[] array, int l ,int r) {
        Pair temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }


//        int counter[] = new int[1];
//        Set<List<Pair>> set = new HashSet<>();
//        mergeSort(A, counter, set);
//        int res = -1;
//        for(List<Pair> cur : set) {
//            int dis = Math.abs(cur.get(0).idx - cur.get(1).idx);
//            System.out.println(cur.get(0).idx + " idx " + cur.get(1).idx);
//            System.out.println(cur.get(0).value + " value " + cur.get(1).value);
//            System.out.println();
//            res = Math.max(dis,res);
//        }
////        return counter[0];
//        return res;
//    }
//
//    public int[] mergeSort(int[] array, int [] counter, Set<List<Pair>> set){
//        if(array== null || array.length == 0){
//            return array;
//        }
//
//        int start = 0;
//        int end = array.length - 1;
//        int[] temp = new int[array.length];
//        mSort(array, temp, start, end, counter,set);
//        return array;
//    }
//
//    private void mSort(int[] array, int[] temp, int start, int end, int [] counter, Set<List<Pair>> set){
//        if(start >= end){
//            return;
//        }
//        int mid = start + (end - start) / 2;
//        mSort(array, temp, start, mid,counter, set);
//        mSort(array, temp, mid + 1, end, counter, set);
//        merge(array, temp, start, mid, end, counter, set);
//    }
//
//    private void merge(int[] array, int[] temp, int start, int mid, int end, int []counter, Set<List<Pair>> set){
//        int i = start;
//        int j = mid + 1;
//        int k = start;
//        while( i <= mid && j <= end){
//            if(array[i] <= array[j]){
//                temp[k++] = array[i++];
//            } else {
//                List<Pair> bundle = new ArrayList<>();
//                bundle.add(new Pair(i,array[i]));
//                bundle.add(new Pair(j,array[j]));
//                if(set.contains(bundle)) {
//                    counter[0]--;
//                } else {
//                    set.add(bundle);
//                }
//                temp[k++] = array[j++];
//                counter[0] += mid - i + 1;
//            }
//        }
//        while( i <= mid){
//            temp[k++] = array[i++];
//        }
//        while( j <= end){
//            temp[k++] = array[j++];
//        }
//
//        for(int l = start; l <= end; l++){
//            array[l] = temp[l];
//        }
//    }

    public static void main(String[] args) {
        SecOne sec = new SecOne();
//        int []array = new int[] {0,3,3,7,5,3,11,1};
        int []array = new int[] {1,4,7,3,3,5};
        int res = sec.solution(array);
        System.out.println(res);
    }
}
