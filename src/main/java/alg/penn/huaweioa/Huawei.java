package alg.penn.huaweioa;

/**
 * Created by yuding on 1/16/18.
 */
import java.util.Scanner;
public class Huawei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

//    APIs
//    sc.hasNextLine();
//    sc.hasNextInt();
//    sc.hasNextFLoat();
//
//    sc.nextInt(); (int)
//    sc.nextLine(); (String)
//    sc.nextLong(); (long)
//    sc.nextFloat(); (float)
//    sc.nextDouble(); (double)
//    sc.next(); (String)
}

