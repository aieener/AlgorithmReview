package alg.oa.microsoftRealOA;

/*
S = "eedaaad" --> "eedaad"
S = "xxxtxxx" --> "xxtxx"
S = "uuuuxaaaaxuuu" --> "uuxaaxuu"
 */
public class StringWithout3IdenticalConsecutiveLetters {
  public String dedupAtMost2Repeat(String input) {
    if (input == null || input.length() < 3) return input;
    char[] inputArr = input.toCharArray();
    int slow = 2; // on the left of slow, not including slow are valid
    int fast = 2;
    for (; fast < inputArr.length; fast++) {
      if (inputArr[fast] != inputArr[slow - 2] || inputArr[fast] != inputArr[slow - 1]) {
        inputArr[slow++] = inputArr[fast];
      }
    }
    return new String(inputArr, 0, slow);
  }

  public static void main(String[] args) {
    StringWithout3IdenticalConsecutiveLetters engine = new StringWithout3IdenticalConsecutiveLetters();
    System.out.println(engine.dedupAtMost2Repeat("eedaaad"));
    System.out.println(engine.dedupAtMost2Repeat("xxxtxxx"));
    System.out.println(engine.dedupAtMost2Repeat("uuuuxaaaaxuuu"));
  }
}
