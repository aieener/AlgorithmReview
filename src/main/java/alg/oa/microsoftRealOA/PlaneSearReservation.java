package alg.oa.microsoftRealOA;

import java.util.*;

/*
return the max four-person falimies can be seated
 */
public class PlaneSearReservation {
  public static void main(String[] args) {
    int n = 2;
    String s = "1A 2F 1C";
    System.out.println(solution(s, n));
  }

  private static int solution(String s, int n) {
    int res = 0;
    String[] reservedSeats = s.split(" ");
    Map<Integer, Set<Character>> reservedLkup = new HashMap<>();
    // fill reservedLkup
    for (int i = 1; i <= n; i++) {
      reservedLkup.put(i, new HashSet<>());
    }
    for (String str : reservedSeats) {
      int rowNum = Integer.parseInt(str.substring(0, str.length() - 1));
      reservedLkup.get(rowNum).add(str.charAt(str.length() - 1));
    }

    // try to put 4 person family
    for (Map.Entry<Integer, Set<Character>> entry : reservedLkup.entrySet()) {
      Set<Character> set = entry.getValue();
      if (!set.contains('B') && !set.contains('C') && !set.contains('D') && !set.contains('E')) {
        res++;
        set.addAll(Arrays.asList('B', 'C', 'D', 'E'));
      }
      if (!set.contains('D') && !set.contains('E') && !set.contains('F') && !set.contains('G')) {
        res++;
        set.addAll(Arrays.asList('D', 'E', 'F', 'G'));
      }
      if (!set.contains('F') && !set.contains('G') && !set.contains('H') && !set.contains('J')) {
        res++;
        set.addAll(Arrays.asList('F', 'G', 'H', 'J'));
      }
    }
    return res;
  }
}
