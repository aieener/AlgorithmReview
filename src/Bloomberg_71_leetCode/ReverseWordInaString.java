package Bloomberg_71_leetCode;

/**
 * Created by yuding on 2/13/18.
 * Also in LaiOffer
 * In LaiOffer, this is reverse Words in A Sentence II
 * I Love Yahoo ---> Yahoo Love I
 * also truncate all heading/trailing/dup spaces
 * Method:
 * 1. reverse every single word
 * 2. then reverse the whole string!
 */
public class ReverseWordInaString {
    public String reverseWords(String s) {
        char [] str = s.toCharArray();
        int l;
        int r = 0;
        // reverse every single word
        while (r < str.length) {
            if(str[r] == ' ') {
                // skipping spaces
                r++;
            } else {
                l = r;
                while(r < str.length && str[r] != ' '){
                    r++;
                }
                if(r != l) {
                    reverse(str, l, r - 1);
                }
            }
        }
        reverse(str, 0, str.length - 1 );
        return new String(str);
    }


    private void reverse(char [] str, int start, int end){
        while(start < end) {
            swap(str, start, end);
            start++;
            end--;
        }
        return;
    }
    private void swap(char[] arr, int l, int r) {
        char temp =  arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return;
    }

    public String reverseWordsRemoveSpace (String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        String [] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; --i) {
            if(!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);

    }

    public static void main(String[] args) {
        ReverseWordInaString rs = new ReverseWordInaString();
        String in = "I Love Yahoo";
        String in2 = " ";
        System.out.println(rs.reverseWords(in));
        System.out.println("-" + rs.reverseWords(in2) + "-" );
    }

}
