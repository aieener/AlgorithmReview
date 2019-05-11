package alg.penn.bloomberg;

/**
 * Created by yuding on 2/11/18.
 * BinSearch
 * This one is actually tricky...
 */
public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0 ) {
            return 0;
        }
        int left = 1;
        int right = x;
        int res = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }


    //--------prac--------------
    public int mySqrt2(int x) {
        if(x == 0) {
            return 0;
        }
        int l = 1;
        int r = x;
        while(l + 1 < r) {
            int mid = l + (r - l)/2;
            if(mid > x / mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if(l * l <= x) {
            return l;
        } else {
            return r;
        }
    }
}
