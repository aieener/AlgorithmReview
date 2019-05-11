package alg.penn.bloomberg;

import java.util.*;

/**
 * LeetCode 56
 * Three ways to define a Comparator!
 *  a. anonymous
 *  b. class implements Comparator interface
 *  c. Comparator<Interval> newCom = new Comparator({}); // anonymous style
 *
 *  MeetingRoom Problem
 */

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class MergeIntervals {


    /**
     * My sol
     * Using minHeap
     */
    public List<Interval> merge(List<Interval> intervals) {
        // sort the List by start
        PriorityQueue<Interval> pq = new PriorityQueue<>(8, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start && o1.end == o2.end) {
                    return 0;
                } else if (o1.start == o2.start) {
                    return o1.end < o2.end? -1 : 1;
                } else {
                    return o1.start < o2.start ? -1 : 1;
                }
            }
        });

        for(Interval interval : intervals) {
            pq.offer(interval);
        }

        List<Interval> res = new ArrayList<>();
        // check each adj
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(pq.isEmpty()) {
                res.add(cur);
            } else {
                Interval top = pq.peek();
                if (cur.end >= top.start ) {
                    pq.poll();
                    cur.end = Math.max(cur.end, top.end);
                    pq.offer(cur);
                } else {
                    res.add(cur);
                }
            }
        }
        return res;
    }

    /**
     * NineChapt Sol
     */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if(a.start == b.start) {
                return 0;
            }
            return a.start < b.start ? -1 : 1;
        }
    }

    private Comparator<Interval> IntervalComparator2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            if(a.start == b.start) {
                return 0;
            }
            return a.start < b.start ? -1 : 1;
        }
    };
    public List<Interval> merge2(List<Interval>intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());

        List<Interval> res = new ArrayList<>();
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= last.end) {
                last.end = Math.max(last.end, cur.end);
            } else {
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(0,4));

        List<Interval> res = mi.merge(input);
        for(Interval re : res) {
            System.out.println("======");
            System.out.println(re.start);
            System.out.println(re.end);
        }
    }

    //---------------- prac -----------------
    public List<Interval> mergemm(List<Interval> intervals) {
        if(intervals == null) {
            return null;
        }
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> minheap = new PriorityQueue<>(10, new Comparator<Interval>() {
            @Override
            public int compare(Interval ia, Interval ib) {
                if(ia.start == ib.start) {
                    return 0;
                }
                return ia.start < ib.start ? -1 : 1;
            }
        });
        for(Interval i : intervals) {
            minheap.offer(i);
        }

        while(!minheap.isEmpty()) {
            Interval cur = minheap.poll();
            if(!minheap.isEmpty()) {
                Interval next = minheap.peek();
                if(cur.end <= next.start){
                    // merge it and put back to heap
                    next = minheap.poll();
                    cur.end = Math.max(cur.end, next.end);
                    minheap.offer(cur);
                } else {
                    res.add(cur);
                }
            } else {
                res.add(cur);
            }
        }
        return res;
    }
}
