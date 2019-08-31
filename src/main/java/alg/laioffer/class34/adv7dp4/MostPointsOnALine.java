package alg.laioffer.class34.adv7dp4;

import java.util.HashMap;
import java.util.Map;

public class MostPointsOnALine {
  /**
   * HashMap<key = <a,b>, value = HashSet<Point>>
   * return entry with largest set.size();
   */
  public int most(Point[] points) {
    int res = 0;
    for (int i = 0; i < points.length; i++) {
      Point seed = points[i];
      int same = 1;
      int sameX = 0;
      int most = 0;
      Map<Double, Integer> count = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        Point cur = points[j];
        if (cur.x == seed.x && cur.y == seed.y) {
          same++;
        } else if (cur.x == seed.x) {
          sameX++;
        } else {
          double slope = getSlope(cur, seed);
          if (!count.containsKey(slope)) {
            count.put(slope, 1);
          } else {
            count.put(slope, count.get(slope) + 1);
          }
          most = Math.max(most, count.get(slope));
        }
      }
      most = Math.max(most, sameX) + same;
      res = Math.max(res, most);
    }
    return res;
  }

  private double getSlope(Point p1, Point p2) {
    return (1.0 * (p1.y - p2.y)) / (1.0 * (p1.x - p2.x));
  }

  class Point {
    public int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
