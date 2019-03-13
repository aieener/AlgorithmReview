package Bloomberg_71_leetCode;

import java.util.Arrays;

public class reverseInt {
    public int reverse(int x) {
        char[] arr = ("" +  x).toCharArray();
        int l = 0;
        int r = arr.length - 1;
        int sign = 1;
        if(arr[l] == '-') {
            sign = -1;
            l++;
        } else if (arr[l] == '+') {
            l++;
        }
        int left = l;
        int right = r;
        while(l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
        long res = 0;
        while(left <= right) {
            res = 10 *res +  (arr[left] -'0');
            left++;
            if(res >= Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (sign * res);
    }


    private void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        reverseInt re = new reverseInt();
        int a = +432;
        System.out.println(re.reverse(a));
    }

    //--------- prac ---------
    public int reverse3(int x) {
        char[] arr = ("" + x).toCharArray();
        int l = 0;
        int r = arr.length - 1;
        int sign = 1;
        if(arr[l] == '-') {
            l++;
            sign = -1;
        } else if (arr[l] == '+') {
            l++;
        }
        int left= l;
        int right = r;
        while(l < r) {
            swap(arr, l++, r--);
        }

        long res = 0;
        while(left <= right) {
            res = 10 * res + (arr[left] - '0');
            left ++;
            if(res >= Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (sign * res);
    }
}
