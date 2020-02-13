package alg.oa.amazon2020OA.freq0;

import java.util.Arrays;
import java.util.Comparator;

/*
leetcode 937
Jan 30
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        int end = moveDigitToTheEnd(logs);
        Arrays.sort(logs, 0, end + 1, new LogComparator());
        // qSort(logs, 0, end);
        return logs;
    }

    static class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            int log1StartIdx = getStartIdx(log1);
            int log2StartIdx = getStartIdx(log2);
            int contentCompareRes = log1.substring(log1StartIdx).compareTo(log2.substring(log2StartIdx));
            if (contentCompareRes == 0) {
                return log1.substring(0, log1StartIdx - 1).compareTo(log2.substring(0, log2StartIdx - 1));
            }
            return contentCompareRes;
        }

        private int getStartIdx(String log) {
            for (int i = 0; i < log.length(); i++) {
                if (log.charAt(i) == ' ') {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    private void qSort(String[] array, int start, int end) {
        Comparator<String> comparator = new LogComparator();
        // base case
        if (start >= end) {
            return;
        }
        int pivotIdx = (int) (Math.random() * ((end - start) + 1)) + start;
        String pivot = array[pivotIdx];

        // swap pivot to the end
        swap(array, pivotIdx, end);
        // move
        int l = start;
        int r = end - 1;
        while (l <= r) {
            if (comparator.compare(array[l], pivot) < 0) {
                l++;
            } else if (comparator.compare(array[r], pivot) >= 0) {
                r--;
            } else {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        //swap back
        swap(array, l, end);
        qSort(array, start, l - 1);
        qSort(array, l + 1, end);

    }


    private int moveDigitToTheEnd(String[] logs) {
        // [0, left] unexplored
        int left = logs.length - 1;  // (left, right] are charLogs
        int right = logs.length - 1; // (right, end] are digit logs
        for (; left >= 0; left--) {
            if (isDigitLog(logs[left])) {
                swap(logs, left, right);
                right--;
            }
        }
        return right; // return the index of charLog
    }

    private void swap(String[] logs, int l, int r) {
        String temp = logs[l];
        logs[l] = logs[r];
        logs[r] = temp;
    }

    private boolean isDigitLog(String log) {
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == ' ') {
                char firstCharContent = log.charAt(i + 1);
                return isDigit(firstCharContent);
            }
        }
        return false;
    }

    private boolean isDigit(char val) {
        return val >= '0' && val <= '9';
    }
}
