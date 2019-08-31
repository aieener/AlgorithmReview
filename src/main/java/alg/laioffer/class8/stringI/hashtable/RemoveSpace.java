package alg.laioffer.class8.stringI.hashtable;

/**
 * Created by yuding on 1/16/18.
 */
public class RemoveSpace {
  public String removeSpaces(String input) {
    int slow = 0;
    int fast = 0;
    char[] inputArr = input.toCharArray();
    for (; fast < inputArr.length; fast++) {
      if(inputArr[fast] != ' ' && slow != 0) {
        inputArr[slow++] = ' ';
      }
      while(fast < inputArr.length && inputArr[fast] != ' ') {
        inputArr[slow++] = inputArr[fast++];
      }
    }
    return new String(inputArr, 0, slow);
  }
}
