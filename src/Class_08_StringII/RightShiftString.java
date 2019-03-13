package Class_08_StringII;

public class RightShiftString {
    /**
     * My Sol
     */
    // Yahoo --> 3 -->ooYah
    public String rightShift(String input, int n){
        if(input == null || input.length() == 0) {
            return input;
        }
        int offset = n % input.length();
        if(offset == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        for(int i = 0; i < offset; i++) {
            shiftToright(array);
        }
        return new String(array);
    }

    public String leftShift(String input, int n){
        if(input == null || input.length() == 0) {
            return input;
        }
        int offset = n % input.length();
        if(offset == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        for(int i = 0; i < offset; i++) {
            shiftToleft(array);
        }

        return new String(array);
    }

    private void shiftToright(char [] array) {
        // Yahoo --> oYaho
        char last = array[array.length - 1];
        int s = array.length - 1;
        int f = array.length - 2;
        while(f >=0){
            array[s--] =  array[f--];
        }
        array[0] = last;
    }

    private void shiftToleft(char[] array) {
        // Yahoo --> ahooY
        char first = array[0];
        int s = 0;
        int f = 1;
        while(f < array.length) {
            array[s++] = array[f++];
        }
        array[array.length - 1] = first;
    }


    //---------------------------

    /**
     * LaiOfferSol
     * reverse three times! 3 step reverse!
     */
    public String rightShift2(String input, int n) {
        if(input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int offset = n % array.length;

        reverse(array, array.length - offset, array.length - 1);
        reverse(array, 0, array.length - offset - 1);
        reverse(array, 0, array.length - 1);
        // shift to left
//        reverse(array, 0, offset - 1);
//        reverse(array, offset , array.length - 1);
//        reverse(array, 0, array.length - 1);
        return new String (array);
    }

    private void reverse(char [] array, int start, int end){
        int l = start;
        int r = end;
        while( l < r) {
            swap(array, l++, r--);
        }
    }

    private void swap (char [] array, int l, int r) {
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        RightShiftString rs = new RightShiftString();
        String input = "YahooGoogle";
        String out = rs.rightShift2(input,2);
        System.out.println(out);
    }
}
