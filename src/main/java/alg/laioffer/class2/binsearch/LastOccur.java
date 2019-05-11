package alg.laioffer.class2.binsearch;

public class LastOccur {
    public int lastOccur(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while( start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target == array[mid]){
                start = mid;
            } else if (target < array[mid]){
                end = mid;
            } else {
                start = mid;
            }
        }

        if(array[end] == target){
            return end;
        } else if (array[start] == target){
            return start;
        }

        return -1 ;
    }
}
