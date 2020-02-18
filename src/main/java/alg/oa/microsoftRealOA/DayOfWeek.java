package alg.oa.microsoftRealOA;

import java.util.HashMap;
import java.util.Map;

/*
given a String s representing the day of week and an integer K,
return day of the week that is K days after
 */
public class DayOfWeek {
  public String solution(String s, int k) {
    String[] week = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < 7; i++) {
      map.put(week[i], i);
    }
    return week[(map.get(s) + k) % 7];
  }
}
