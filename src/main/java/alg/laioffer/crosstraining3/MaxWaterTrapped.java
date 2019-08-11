package alg.laioffer.crosstraining3;

public class MaxWaterTrapped {
  public int maxTrapped(int[] array) {
    int left = 0;
    int right = array.length - 1;
    int lBound = array[0];
    int rBound = array[array.length - 1];
    int res = 0;
    while(left < right) {
      if(array[left] <= array[right]) {
        res += Math.max(0, lBound - array[left]);
        lBound = Math.max(lBound, array[left]);
        left++;
      } else {
        res += Math.max(0, rBound - array[right]);
        rBound = Math.max(rBound, array[right]);
        right--;
      }

    }
    return res;
  }
}
