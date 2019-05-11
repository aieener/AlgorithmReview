package alg.laioffer.class8.stringII;

public class RightShiftString {
  /**
   * updated April 13 2019
   */
  public String rightShift(String input, int n) {
    if (input == null || input.length() == 0) return input;
    // step 1 find index
    int posToSwap = findIdx(input.length(), n);
    // step 2 I love Yahoo
    char[] inputArray = input.toCharArray();
    swapString(inputArray, posToSwap);

    return new String(inputArray);
  }

  private void swapString(char[] input, int posToSwap) {
    System.out.println(posToSwap);
    reverse(input, 0, posToSwap - 1);
    reverse(input, posToSwap, input.length - 1);
    reverse(input, 0, input.length - 1);
  }

  private void reverse(char[] input, int start, int end) {
    while (end < input.length && start < end) {
      swap(input, start++, end--);
    }
  }

  private void swap(char[] input, int left, int right) {
    char buf = input[left];
    input[left] = input[right];
    input[right] = buf;
  }

  private int findIdx(int inputLen, int n) {
    return ((inputLen - n) % inputLen + inputLen) % inputLen;
  }

  public static void main(String[] args) {
    RightShiftString engine = new RightShiftString();
    System.out.println(engine.rightShift("abcdefg", 39));
  }
}
