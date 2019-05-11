package alg.penn.huaweioa;
import java.util.Scanner;

public class Firstone {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        Integer input = in.nextInt();
        String inputString = input.toString();
        char [] array = inputString.toCharArray();

        // print the number of dig of the integer
        if(array[0] == '-'){
            System.out.println(array.length - 1);
        } else {
            System.out.println(array.length);
        }

        // check if the num is pos or neg
        int len = array.length - 1;
        int startIdx = 0;
        if(array[0] =='-'){
            startIdx = 1;
            System.out.print(array[0]);
        }

        // print the number one by one separated by space
        for(int i = startIdx; i <= len ; i++) {
            if(i < len  ){
                System.out.print(array[i] + " ");
            } else {
                System.out.println(array[i]);
            }
        }

        // reverse the array and print it
        if(array[0] =='-'){
            // first print the -
            System.out.print(array[0]);
        }

        for(int i = len ; i >=startIdx ; i--) {
            System.out.print(array[i]);
        }
    }
}
