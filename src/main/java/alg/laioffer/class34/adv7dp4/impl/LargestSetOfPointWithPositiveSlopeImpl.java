package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.LargestSetOfPointWithPositiveSlope;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPointWithPositiveSlopeImpl implements LargestSetOfPointWithPositiveSlope {
    // we want something like <1,3> <1,2> <2,4> <2,9> <3,5> ...
    static class MyComparator implements Comparator<Point> { //sort by x first, them reversely by y
        @Override
        public int compare(Point base, Point other) {
            if (base.x < other.x) {
                return -1;
            } else if (base.x > other.x) {
                return 1;
            } else if (base.y < other.y) {
                return 1;
            } else if (base.y > other.y) {
                return -1;
            }
            return 0;
        }
    }
    @Override
    public int largest(Point[] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new MyComparator());
        Point[] refine = new Point[points.length + 1];
        // base case
        refine[1] = points[0];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            int biggestSmallerLen = binSearch(refine, points[i], res);
            if (biggestSmallerLen == res) {
                res++;
                refine[biggestSmallerLen + 1] = points[i];
            } else {
                refine[biggestSmallerLen + 1] = points[i];
            }
        }
        return res == 1 ? 0 : res;
    }

    private int binSearch(Point[] refine, Point target, int end) {
        Comparator<Point> myComparator = new MyComparator();
        int start = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (refine[mid].y < target.y && refine[mid].x < target.x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Point[] input = new Point[]{
                new Point(0, 1),
                new Point(2, 3),
                new Point(2, 2),
                new Point(3, 3),
                new Point(3, 3),
                new Point(3, 1),
                new Point(4, 2),
                new Point(5, 5),
                new Point(6, 9)
        };
        System.out.println(new LargestSetOfPointWithPositiveSlopeImpl().largest(input));
    }
}
