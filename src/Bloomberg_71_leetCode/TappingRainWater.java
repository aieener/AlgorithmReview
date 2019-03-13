package Bloomberg_71_leetCode;


/**
 * Feb 20
 * Created by yuding on 2/11/18.
 * LeetCode 42
 */
public class TappingRainWater {
    /**
     * My Sol:
     * 0 1 0 2 1 0 1 3 2 1 2 1
     * I tried hard on finding a two ptr that scans in same direction
     * I failed so My Sol won't work. Keep it here to remind myself that
     * this method won't work.... We need to use two ptr that scans from
     * opposite direction
     */
    public int trapWrong(int[] height) {
        if(height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        /**
         * Semantics
         * between l and r, all are less than l and less than r
         * 'catch V spot'
         */
        int l = 0;
        int r = 1;
        int res = 0;
        if(height[r] > height[l] ) {
            l = r;
        }

        while(r + 1 < height.length) {
//            System.out.println(r);
//            System.out.println(l);
//            System.out.println(res);
//            System.out.println("=========");
            if(height[r] > height[r + 1] ) {
                // drop
                // look at prev to see if it was raise
                if(r != l && height[r] > height[r - 1] && height[l] > height[r - 1]){
                    // collect water
                    int bound = Math.min(height[l], height[r]);
                    r++;
                    while(l < r) {
                        res += Math.max(0, bound - height[l]);
                        l++;
                    }
                } else {
                    r++;
                }
            } else if(height[r] < height[r + 1]) {
                // raise
                if(height[r + 1] >= height[l]) {
                    // check if beyond left bound
                    // collect water
                    r++;
                    int bound = Math.min(height[l], height[r]);
                    while(l < r) {
                        res += Math.max(0, bound - height[l]);
                        l++;
                    }
                } else {
                    r++;
                }
            } else {
                // hold
                r++;
            }
        }

        // post processing
        if(l != r) {
            int bound = Math.min(height[l], height[r]);
            while(l < r) {
                res += Math.max(0, bound - height[l]);
                l++;
            }
        }

        return res;
    }

    /**
     * NinChapt's solution
     * This one is very elegant and beautiful!
     */

    public int trap(int [] heights) {

        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        if(left >= right) {
            // len = 0
            return res;
        }

        int leftHeight = heights[left];
        int rightHeight = heights[right];
        // all waters that traps will be lower than both leftHeight and rightHeight
        while(left < right ) {
            if(leftHeight < rightHeight) {
                left++;
                if(leftHeight > heights[left]){
                    res += leftHeight - heights[left];
                } else {
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if(rightHeight > heights[right]) {
                    res += rightHeight - heights[right];
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TappingRainWater tw = new TappingRainWater();
        int [] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(tw.trapWrong(height));
    }

    //----------- prac ------------
    public int trap3(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int res = 0;
        if(left >= right) {
            return res;
        }

        while(left < right) {
            if(leftHeight < rightHeight) {
                left++;
                if(leftHeight > height[left]) {
                    res += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if(rightHeight > height[right]) {
                    res += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return res;
    }
}
