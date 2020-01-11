package alg.oa.hired;

public class LevelOrderTreeAsArrFindLeftSumAndRightSumImpl {
    public String solution(long[] arr) {
        if(arr == null || arr.length <= 1) return "";
        long leftSum[] = new long[1];
        long rightSum[] = new long[1];
        findSum(leftSum, rightSum, arr,1, 2);
        if(leftSum[0] > rightSum[0]) {
            return "Left";
        } else if (leftSum[0] < rightSum[0]) {
            return "Right";
        }
        return "";
    }

    private void findSum(long[] leftSum, long[] rightSum, long[] arr, int start, int end) {
        // base case
        if (start >= arr.length) return;

        int chunkLen = (end - start + 1);
        int curEnd = Math.min(end, arr.length - 1);
        for(int cur = start; cur<= curEnd; cur++) {
            if(cur < start + chunkLen / 2 ) {
                if(arr[cur] != -1){
                    leftSum[0] += arr[cur];
                }
            } else {
                if(arr[cur] != -1){
                    rightSum[0] += arr[cur];
                }
            }
        }
        int newLen = chunkLen * 2;
        findSum(leftSum, rightSum, arr, end + 1, end + newLen);
    }

    public static void main(String[] args) {
        LevelOrderTreeAsArrFindLeftSumAndRightSumImpl engine = new LevelOrderTreeAsArrFindLeftSumAndRightSumImpl();
        long[] input = new long[]{1,10,5,1,0,6};
        System.out.println(engine.solution(null));
    }
}
