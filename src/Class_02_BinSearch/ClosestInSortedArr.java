package Class_02_BinSearch;

// 中心开花
public class ClosestInSortedArr {
    public int closest(int [] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }

        // first find the idx of target
        int start = 0;
        int end = array.length - 1;

        int tarIdx = 0;
        while(start + 1 < end){
            int mid = start  + (end - start) / 2;
            if(target == array[mid]){
                return mid;
            } else if (target > array[mid]){
                start = mid;
            } else {
                end = mid;
            }
        }

        int stdif = Math.abs(array[start] - target);
        int eddif = Math.abs(array[end] - target);
        if(stdif > eddif){
            return end;
        } else {
            return start;
        }
    }

    // --- prac ---
    public int closest2(int [] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start ) / 2;
            if(array[mid] > target) {
                end = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
        }

        int startLen = Math.abs(array[start] - target);
        int endLen = Math.abs(array[end] - target);
        return startLen > endLen? start : end;
    }
}
