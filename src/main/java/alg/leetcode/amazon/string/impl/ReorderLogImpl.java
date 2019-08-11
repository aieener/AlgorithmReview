package alg.leetcode.amazon.string.impl;

import alg.leetcode.amazon.string.ReorderLogFiles;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogImpl implements ReorderLogFiles {
  @Override
  public String[] reorderLogFiles(String[] logs) {
    int letterLogEndIdx = moveLetterLogToHead(logs);
    sortLetterLog(logs, letterLogEndIdx);
    return logs;
  }

  /**
   * 1 2 0 0 0 0 3 4 5
   *     f
   *           s
   * on the right of s, not including s are all digit
   */
  private int moveLetterLogToHead(String[] logs) {
    int slow = logs.length - 1;
    int fast = logs.length - 1;
    while(fast >= 0) {
      if(!isDigitLog(logs[fast])){
        fast--;
      } else {
        swap(logs, fast--, slow--);
      }
    }
    return slow;
  }

  private void swap(String[] logs, int i, int j){
    String temp = logs[i];
    logs[i] = logs[j];
    logs[j] = temp;
  }

  private boolean isDigitLog(String log) {
    String logContent = trimIdentifier(log);
    if(logContent.charAt(0) >= '0' && logContent.charAt(0) <='9') return true;
    return false;
  }

  private String trimIdentifier(String log) {
    return log.substring(findFirstSpaceIdx(log) + 1);
  }

  private String getIdentifier(String log) {
    return log.substring(0, findFirstSpaceIdx(log));
  }

  private int findFirstSpaceIdx(String log) {
    int idx = 0;
    while(log.charAt(idx) != ' ') {
      idx++;
    }
    return idx;
  }

  private void sortLetterLog(String[] logs, int endIdx){
    Arrays.sort(logs, 0, endIdx + 1, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String o1Content = trimIdentifier(o1);
        String o2Content = trimIdentifier(o2);
        if (o1Content.compareTo(o2Content) == 0) {
          return getIdentifier(o1).compareTo(getIdentifier(o2));
        }
        return o1Content.compareTo(o2Content);
      }
    });
  }

  public static void main(String[] args) {
    String[] input = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    ReorderLogFiles reorder = new ReorderLogImpl();
    reorder.reorderLogFiles(input);
    System.out.println(Arrays.toString(input));
  }
}
