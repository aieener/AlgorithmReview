package MayStreet_OA;

/**
 * Created by yuding on 2/11/18.
 */
public class powerOfTwo {
    public boolean isPowerofTwo(int number) {
        if(number <= 0) {
            return false;
        }
        while((number & 1) == 0) {
            // ignore all trailing 0s
            number >>>=1;
        }
        return number == 1;
    }
}
