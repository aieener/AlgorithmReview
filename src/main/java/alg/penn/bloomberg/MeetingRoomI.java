package alg.penn.bloomberg;



import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 252
 * Created by yuding on 2/20/18.
 * deter if a person can attend all meetings
 */
public class MeetingRoomI {
    /**
     * My PQUEUE sol
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) {
            return true;
        }
        // sort the intervals by start time;
        PriorityQueue<Interval> minheap = new PriorityQueue<>(10, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return 0;
                }
                return i1.start < i2.start ? -1 : 1;
            }
        });
        for(Interval inter : intervals) {
            minheap.offer(inter);
        }
        int end = minheap.peek().end;
        while(!minheap.isEmpty()) {
            Interval cur = minheap.poll();
            if(!minheap.isEmpty()){
                Interval next = minheap.peek();
                if(end > next.start){
                    return false;
                }
                end = Math.max(end, next.end);
            }

        }
        return true;
    }

    /**
     * NinChap Sol
     */
    public boolean canAttendMeetings2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < end) {
                return false;
            }
            end = Math.max(end, intervals[i].end);
        }
        return true;
    }
}
