package Class_02_BinSearch;

//中心开花
// Worth to do again! Dec 18
public class kClosest {
    public int[] kClosest(int[] array, int target, int k){
        // first find the place near to the target
        if(k == 0){
            return new int[0];
        }
        int start = 0;
        int end = array.length - 1;

        while( start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target < array[mid]){
                end = mid;
            } else if (target > array[mid]){
                start = mid;
            } else {
                break;
            }
        }
        int tarIdx ;
        if(Math.abs(array[start] - target) < Math.abs(array[end] - target)){
            tarIdx = start;
        } else {
            tarIdx = end;
        }

        int [] res = new int[k];
        res[0] = array[tarIdx];
        //中心开花
        int left = tarIdx - 1;
        int right = tarIdx + 1;
        for(int i = 1; i < k; i++){
            if(left >=0 && right <= array.length - 1){
                if(Math.abs(array[left] - target) < Math.abs(array[right] - target)){
                    res[i] = array[left];
                    left--;
                } else {
                    res[i] = array[right];
                    right++;
                }
            } else if ( left >=0 ){
                res[i] = array[left];
                left--;
            } else {
                res[i] = array[right];
                right++;
            }

        }
        return res;
    }
}
