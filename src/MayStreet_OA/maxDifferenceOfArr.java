package MayStreet_OA;

/**
 * Created by yuding on 2/11/18.
 * This is best time to buy and sell stock prob....
 */
public class maxDifferenceOfArr {
    /**
     * O(n^2)
     * @param arr
     * @return
     */
    public int maxDiff (int[] arr) {
        int res = -1;
        for(int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >=0; j--) {
                res = Math.max(res, arr[i] - arr[j]);
            }
        }
        return res;
    }

    /**
     * O(n)
     */
    public int maxDiffOp(int [] arr) {
        int maxProfit = 0;
        int min_elem = 0;
        for(int i = 1; i < arr.length; i++) {
            int profit = arr[i] - arr[min_elem];
            if(maxProfit < 0) {
                min_elem = i;
            } else {
                maxProfit = Math.max(maxProfit, profit );
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        maxDifferenceOfArr md = new maxDifferenceOfArr();
        int arr[] = {1,2,90,10,110};
        System.out.println(md.maxDiff(arr));
        System.out.println(md.maxDiffOp(arr));
    }
}
