package Class_07_String_HashTable;

/**
 * Created by yuding on 1/16/18.
 */
public class RemoveSpace {
    public String removeSpaces(String input) {
        int l = 0;
        int r = 0;
        int word_count = 0;
        char[] carray = input.toCharArray();
        while(true) {
            while( r < carray.length && carray[r] == ' ') {
                r++;
            }
            if(r == carray.length) {
                break;
            }
            if(word_count > 0) {
                carray[l++] = ' '; // add extra ' '
            }

            while(r < carray.length && carray[r] != ' ') {
                carray[l++] = carray[r++];
            }
            word_count++;
        }
        return new String (carray, 0,l);
    }

    /**
     * LaiOfferSol
     */
    public String removeSpacesLaiOffer(String input) {
        if(input.isEmpty()){
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == ' ' && (i == 0 || array[i - 1] == ' ')){
                continue;
            }
            array[end++] = array[i];
        }
        // post-processing
        if(end > 0 && array[end - 1] == ' '){
            return new String (array, 0, end - 1);
        }
        return new String(array,0, end);
    }

    public static void main(String[] args) {
        RemoveSpace rs = new RemoveSpace();
//        String input = "    My    Name   is asdfasdf";
        String input = "I  Love Yahoo";
        String out = rs.removeSpaces2(input);
        System.out.println(out);
    }

    // --- prac ---

    /**
     * This version of mine is the easist one to understand!!
     * And it passed the test
     */
    public String removeSpaces2(String input) {
        if(input == null || input.length() == 0 ) {
            return input;
        }
        char[] array = input.toCharArray();
        int s = 0;
        int f = 0;
        boolean firstWord = true; // check if reach first word
        while(f < array.length){
            if(array[f] != ' '){
                firstWord = false;
                array[s++] = array[f++];
            } else {
                while(f < array.length && array[f] == ' '){
                    f++;
                }
                if(f == array.length) {
                    break;
                }
                if(!firstWord){
                    array[s++] = ' ';
                }
            }
        }

        return new String(array, 0, s);
    }
}
