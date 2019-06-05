package alg.laioffer.crosstraining1;

public class MoveZeroII {
  public int[] moveZero(int[] array) {
    int slow = -1;
    for (int fast = 0; fast < array.length; fast++) {
      if(array[fast] != 0){
        array[++slow] = array[fast];
      }
    }
    slow++;
    for(; slow < array.length; slow++) {
      array[slow] = 0;
    }
    return array;
  }
}
