package MayStreet_OA;

import java.util.Arrays;

/**
 * Created by yuding on 2/11/18.
 * hard sliding window
 * Greedy Alg
 * Time O(nlogn)
 * Space O(n)
 *
 * 7 3 | 10 100 300 200 1000 20 30
 * k = 3
 * return 20
 *
 *
 * 10 4 | 1 2 3 4 10 20 30 40 100 200
 * k = 4
 * return 3
 */
public class AngeryChildren {
    int minUnfairness (int k, int [] candies) {
        Arrays.sort(candies);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < candies.length - k + 1; i++) {
            res = Math.min(res, candies[i + k - 1] - candies[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] input = new int[] {10, 100, 300, 200, 1000, 20, 30};
        int [] input2 = new int[] {1,2,3,4,10,20,30,40,100,200};
        AngeryChildren ac = new AngeryChildren();
        System.out.println(ac.minUnfairness(3,input));
        System.out.println(ac.minUnfairness(4,input2));
    }
}
