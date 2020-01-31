package alg.audible;

import java.util.List;

/*
return the minimum absolute difference between any two element
[6,2,4,10] ---> <2, [2,4] [4,6]>
 */
public interface ClosestNumber {
    List<int[]> closestNumber(int[] nums);
}
