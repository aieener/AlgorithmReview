package alg.laioffer.class15.dp3;

public class LongestConsecutiveOne {
    public int longest(int[] array) {
        int globalMax = 0;
        int curMax = 0;
        for(int i = 0; i< array.length; i++) {
            if(array[i] == 1) {
                curMax++;
            } else {
                curMax = 0;
            }
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}
