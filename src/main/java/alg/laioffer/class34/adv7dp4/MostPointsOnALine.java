package alg.laioffer.class34.adv7dp4;

import alg.laioffer.class34.adv7dp4.impl.MostPointsOnALineImpl;

public interface MostPointsOnALine {
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int most(Point[] points);
}
