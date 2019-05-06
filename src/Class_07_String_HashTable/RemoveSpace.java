package Class_07_String_HashTable;

/**
 * Created by yuding on 1/16/18.
 */
public class RemoveSpace {
  public String removeSpaces(String input) {
    int slow = 0;
    int fast = 0;
    char[] inputArr = input.toCharArray();
    boolean firstString = true;
    for (; fast < inputArr.length; fast++) {
      if(inputArr[fast] != ' ' && !firstString) {
        inputArr[slow++] = ' ';
      }
      while(fast < inputArr.length && inputArr[fast] != ' ') {
        inputArr[slow++] = inputArr[fast++];
        firstString = false;
      }
    }
    return new String(inputArr, 0, slow);
  }
}
