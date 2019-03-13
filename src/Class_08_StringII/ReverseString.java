package Class_08_StringII;

public class ReverseString {

    public String reverse(String input) {
        char[] array = input.toCharArray();
        int r = array.length - 1;
        int l = 0;
        while(l < r){
            swap(array, l++, r--);
        }
        return new String(array);
    }

    private void swap(char[] array, int l, int r) {
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
