package Class_02_BinSearch;

public class BinarySearch {
    public int binarySearch(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        //------------------------------------
        /**
         * classical binary search
         */
//        while(start <= end){
//            int mid = start + (end - start)/ 2;
//            if(dict.get(mid) == null || dict.get(mid) > target){
//                end = mid - 1;
//            } else if (dict.get(mid) < target){
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
        //-------------------------------------
        while( start + 1 < end){
            int mid = start + (end- start)/2;
            if(target == array[mid]){
                return mid;
            } else if( target < array[mid]){
                end = mid;
            } else {
                start = mid;
            }
        }

        if(array[start] == target){
            return start;
        } else if (array[end] == target){
            return end;
        }
        return -1;
    }

    public int binarySearch2( int [] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while( start + 1 < end) {
            int mid = start + (end - start ) / 2;
            if(array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(array[start] == target) {
            return start;
        } else if (array[end] == target) {
            return end;
        }
        return -1;
    }


}
