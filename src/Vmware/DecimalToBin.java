package Vmware;

/**
 * Created by yuding on 1/21/18.
 */
public class DecimalToBin {
    static int decimalToBinary(int input) {
        if(input == 0) {
            return 0;
        }
        int half = input / 2;
        int dig = input % 2;
        return dig + 10 * decimalToBinary(half);
    }

    public static void main(String[] args) {
        int input = 14;
        int res =  decimalToBinary(input);
        System.out.print(res);
    }

}
