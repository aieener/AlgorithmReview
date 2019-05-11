package alg.laioffer.class8.stringII;

public class ReverseWords {

    /**
     * MySol
     * swap twice
     * step 1: reverse every single words
     * step 2: reverse the whole sentense
     */

    public String reverseWords(String input) {
        if(input == null || input.length()==0) {
            return input;
        }
        int s = 0;
        int f = 0;
        char[] array = input.toCharArray();
        // a[s:f] will be a word
        // reverse every single words
        while(f < array.length){
            if( array[f] != ' '){
                f++;
            } else{
                reverse(array,s,f - 1);
                while(f != array.length && array[f] == ' '){
                    f++;
                }
                s = f;
            }
        }
        // post processing
//        if(s != f){
            reverse(array,s,f - 1);
//        }

        // reverse the whole string
        reverse(array,0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] input, int start, int end){
        int i = start;
        int j = end;
        while(i <= j){
            swap(input, i++,j--);
        }
    }

    private void swap(char[] input, int l, int r){
        char temp = input[l];
        input[l] = input[r];
        input[r] = temp;
    }

    /**
     * LaiOffer Sol
     */
    public String reverseWordsLaiOffer(String input) {
        char[] array = input.toCharArray();
        // reverse the whole string first
        reverseLai(array,0, array.length - 1);
        int start = 0;
        // reverse each of the words
        for(int i = 0; i < array.length; i++) {
            // the start index of the word
            if(array[i] != ' ' && (i == 0 || array[i - 1] == ' ')){
                start = i;
            }
            // the end index of the word
            if(array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')){
                reverseLai(array,start, i);
            }
        }
        return new String(array);
    }

    private void reverseLai(char[] array, int left, int right) {
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String input = "I love Google";
        String output  = rw.reverseWords(input);
        System.out.println(output);
    }


}
