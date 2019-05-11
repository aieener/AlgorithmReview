package alg.penn.bloomberg;

import java.util.Arrays;

/**
 * LeetCode 443
 */
public class StringCompression {
    /**
     * Two pointer
     * l: to the left of l is done
     * r: to the right of r is unexplored
     * a 3 b 3 c b c c c
     *         l
     *                   r
     *             s
     * a b b b b b b b b b b
     * l
     *   r
     * s
     */
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        } else if(chars.length == 1) {
            return 1;
        }
        int l = 0;
        int r = 0;
        int start = r;
        while( r < chars.length) {
            if(chars[r] == chars[start]) {
                r++;
            } else {
                // convert counter to char and fill it in
                l = fillChar(l, start, r, chars);
                chars[l] = chars[r];
                start = r;

            }
        }
        // post processing
        if(chars[start] == chars[r - 1]) {
            l = fillChar(l, start, r, chars);
        }
        return l;
    }

    private int fillChar(int l, int start, int r, char[] chars) {
        int counter = r - start;
        if(counter == 1) {
            l++;
            return l;
        }
        int curDig;
        l++;
        int lStart = l;
        while(counter / 10 != 0)  {
            curDig = '0' + counter % 10;
            chars[l] = (char) curDig;
            l++;
            counter = counter / 10;
        }
        curDig = '0' + counter %10;
        chars[l] = (char) curDig;
        int lEnd = l;
        while(lStart < lEnd) {
            swap(chars, lStart, lEnd);
            lStart++;
            lEnd--;
        }

        l++;
        return l;
    }

    private void swap(char[] chars, int l ,int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    /**
     * LeetCode Sol
     * use ("" + int).toCharArray() ...
     */
    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for(int read = 0; read < chars.length; read++) {
            if(read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if(read > anchor) {
                    for(char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] input = new char[] {'a','a','a','b','b','b','c','c', 'c'};
        char[] input2 = new char[] {'a','b','b','b','b','b','b','b', 'b','b','b','b','b','b','b','b'};
//        System.out.println(sc.compress(input));
//        System.out.println(Arrays.toString(input));
        System.out.println(sc.compress(input2));
        System.out.println(Arrays.toString(input2));
    }
}
