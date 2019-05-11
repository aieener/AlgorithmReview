package alg.penn.bloomberg;

import java.util.*;

/**
 * LeetCode 253
 * MeetingRoomII | merge interval
 * Created by yuding on 2/13/18.
 * MeetingRoom 面经题
 *
 * 中位数 第500 和 第501
 * Stream of incoming data, find median dynamically
 * Using two heap, maxHeap + minHeap,
 * -----
 * \   /
 *  \ /
 *   +
 *  / \
 * /   \
 * -----
 */
public class MeetingRoom {
    /**
     * NineChapt SOl
     */

    class Point {
        int time;
        int flag;
        Point(int t, int s) {
            this.time = t;
            this.flag = s;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        List<Point> list = new ArrayList<>(intervals.length * 2);
        for(Interval i : intervals) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.time == p2.time) {
                    return p1.flag - p2.flag;
                } else {
                    return p1.time - p2.time;
                }
            }
        });

        int count = 0, res = 0;
        for(Point p : list) {
            if(p.flag == 1) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res,count);
        }
        return res;
    }

    /**
     * LeetCode Sol
     */
    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }

    ///-------------- prac --------------

    public int minM(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        // sort it by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return 0;
                }
                return i1.start < i2.start? -1 : 1;
            }
        });

        PriorityQueue<Interval> endHeap = new PriorityQueue<>(10, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.end == i2.end) {
                    return 0;
                }
                return i1.end < i2.end ? -1 : 1;
            }
        });

        endHeap.offer(intervals[0]);
        for(int i  = 1; i < intervals.length; i++) {
            Interval curRoom = endHeap.poll();
            if(intervals[i].start >= curRoom.end)  {
                // no need for a new room, merge it back to queue
                curRoom.end = intervals[i].end;
            } else {
                // need a new room;
                endHeap.offer(intervals[i]);
            }
            endHeap.offer(curRoom); // because we modify the end, we reoffer it back to get sort
        }
        return endHeap.size();
    }

}
