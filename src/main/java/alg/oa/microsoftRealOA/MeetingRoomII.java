package alg.oa.microsoftRealOA;

import java.util.Arrays;

/*
leetcode 253
meetingRoomII
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 */
public class MeetingRoomII {
  public int minMeetingRooms(int[][] intervals) {
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int rooms = 0;
    int endsItr = 0;
    for (int i = 0; i < starts.length; i++) {
      if (starts[i] < ends[endsItr])
        rooms++;
      else
        endsItr++;
    }
    return rooms;
  }
}
