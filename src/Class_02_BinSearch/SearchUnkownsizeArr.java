package Class_02_BinSearch;

/**
 * Created by yuding on 12/18/17.
 * Need to redo this one!
 */
interface Dictionary{
    public Integer get(int index);
}

public class SearchUnkownsizeArr {
    public int search(Dictionary dict, int target){
        if(dict == null){
            return -1;
        }
        int start = 0;
        int end = 1;
        while(dict.get(end) != null && dict.get(end) < target){
            start = end;
            end = 2 * end;
        }


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

        while(start + 1 < end){
            int mid = start + (end - start)/ 2;
            if(dict.get(mid) == null || target < dict.get(mid)){
                end = mid;
            }else if (target > dict.get(mid)){
                start = mid;
            } else {
                return mid;
            }
        }
        if(dict.get(start) != null && dict.get(start) == target){
            return start;
        } else if (dict.get(end) != null && dict.get(end) == target){
            return end;
        }
        return -1;
    }
}
