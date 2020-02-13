package alg.oa.microsoftleetcodeMock;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        for (int offset = 0; offset < A.length(); offset++) {
            if (A.equals(rotate(B, offset))) return true;
        }
        return false;
    }

    private String rotate(String input, int offset) {
        char[] inputArr = input.toCharArray();
        reverse(inputArr, 0, offset);
        reverse(inputArr, offset + 1, inputArr.length - 1);
        reverse(inputArr, 0, inputArr.length - 1);
        return new String(inputArr);
    }

    private void reverse(char[] input, int startIdx, int endIdx) {
        while (startIdx <= endIdx) {
            swap(input, startIdx++, endIdx--);
        }
    }

    private void swap(char[] input, int l, int r) {
        char temp = input[l];
        input[l] = input[r];
        input[r] = temp;
    }
}
