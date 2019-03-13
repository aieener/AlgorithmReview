package BlackStone;

/**
 * Created by yuding on 2/7/18.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        while(idx1 >= 0 && idx2 >= 0) {
            int dig1 = num1.charAt(idx1) - '0';
            int dig2 = num2.charAt(idx2) - '0';
            int cur = (dig1 + carry + dig2) % 10;
            carry = (dig1 + carry + dig2) / 10;
            sb.append(cur);
            idx1--;
            idx2--;
        }

        while(idx1 >=0 ) {
            int dig1 = num1.charAt(idx1) - '0';
            int cur = (dig1 + carry) %10;
            carry = (dig1 + carry) / 10;
            sb.append(cur );
            idx1--;
        }

        while(idx2 >=0 ) {
            int dig2 = num2.charAt(idx2) - '0';
            int cur = (dig2 + carry) %10;
            carry = (dig2 + carry) / 10;
            sb.append(cur );
            idx2--;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings ad = new AddStrings();
        String s1 = "123";
        String s2 = "423";
        System.out.println(ad.addStrings(s1,s2));
        System.out.println(ad.addStrings2(s1,s2));
    }

    //------ prac --------
    public String addStrings2(String num1, String num2) {
        if(num1 == null && num2 == null) {
            return null;
        } else if(num1 == null) {
            return num2;
        } else if(num2 == null) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        int pt1 = num1.length() - 1;
        int pt2 = num2.length() - 1;

        int carray = 0;

        while(pt1 >= 0 && pt2 >= 0) {
            int Dig1 = num1.charAt(pt1) - '0';
            int Dig2 = num2.charAt(pt2) - '0';
            int curDig = (carray + Dig1 + Dig2) % 10;
            carray = (carray + Dig1 + Dig2) / 10;
            sb.append(curDig);
            pt1--;
            pt2--;
        }

        while( pt1 >= 0) {
            int Dig1 = num1.charAt(pt1) - '0';
            int curDig = (carray + Dig1) % 10;
            carray = (carray + Dig1 ) / 10;
            sb.append(curDig);
            pt1--;
        }

        while( pt2 >= 0) {
            int Dig2 = num1.charAt(pt2) - '0';
            int curDig = (carray + Dig2) % 10;
            carray = (carray + Dig2 ) / 10;
            sb.append(curDig);
            pt2--;
        }

        if(carray != 0) {
            sb.append(carray);
        }
        sb.reverse();
        return sb.toString();
    }
}
