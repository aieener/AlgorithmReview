package alg.oracle.phone;

import java.util.*;

/*
leetcode 253
 */
public class MeetingRoomIIMergeIntervals {
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

  // sol 2
  class Point {
    int time;
    int flag;

    Point(int t, int s) {
      this.time = t;
      this.flag = s;
    }
  }

  // Sol 2 PQueue
  public int minMeetingRoomsPQueue(int[][] intervals) {
    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap, stores ending times
    PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();

    // Sort the intervals by start time
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return a[0] - b[0];
      }
    });

    // Add the first meeting
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= allocator.peek()) { // interval start time is greater than current end time
        allocator.poll(); // free up, so it don't consume additional rooms
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i][1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }
}
