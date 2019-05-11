package alg.penn.blackstone;


/**
 * Created by yuding on 2/7/18.
 */
public class StringToInteger {
    /** NineChapt Sol
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }

        char [] charArray = str.toCharArray();
        int index = 0;
        int sign = 1;
        if(charArray[index] == '+') {
            index++;
        } else if (charArray[index] == '-') {
            index++;
            sign = -1;
        }

        long res = 0;
        while(index < charArray.length) {
            if(charArray[index] < '0' || charArray[index] >'9') {
                break;
            }
            res = res * 10 + (charArray[index] - '0');
            if(res > Integer.MAX_VALUE) {
                break;
            }
            System.out.println(res);
            index++;
        }

        if(res * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(res * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        StringToInteger st = new StringToInteger();
        System.out.print(st.myAtoi("123"));
    }

    //------------ prac --------------
    public int atoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int idx = 0;
        if(str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (str.charAt(idx) == '+') {
            idx++;
        }

        long res = 0;
        while(idx < str.length()) {
            if(str.charAt(idx) <'0' || str.charAt(idx) >'9') {
                break;
            }
            res = 10* res + str.charAt(idx) - '0';
            if(res >= Integer.MAX_VALUE) {
                break;
            }
            idx++;
        }

        if(res * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(res * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res * sign;

    }

}
