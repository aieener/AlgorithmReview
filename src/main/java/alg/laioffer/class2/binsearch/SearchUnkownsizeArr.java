package alg.laioffer.class2.binsearch;

/**
 * Created by yuding on 12/18/17.
 * Need to redo this one!
 */
interface Dictionary {
  public Integer get(int index);
}

public class SearchUnkownsizeArr {
  public int search(Dictionary dict, int target) {
    if (dict == null) {
      return -1;
    }
    int start = 0;
    int end = 1;
    while(dict.get(end) != null && dict.get(end) < target) {
      start = end;
      end = end * 2;
    }

    // then searach from start to end
    while(start <=  end) {
      int mid = start + (end - start ) /2;
      if ( dict.get(mid) != null &&  dict.get(mid) == target){
        return mid;
      } else if (dict.get(mid) == null || target < dict.get(mid)){
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }
}
