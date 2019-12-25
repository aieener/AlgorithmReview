package alg.laioffer.class34.adv7dp4;

public interface LargestSetOfPointWithPositiveSlope {
    static class Point {
        public int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int largest(Point[] points);
}
