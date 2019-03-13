package BaiciZhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TESTcompressString {

    /**
     * Sliding Window
     */
    public List<String> compress(List<Integer> input) {
        Collections.sort(input);
        int s = 0;
        int f = 1;
        int prev;
        int cur;

        List<String> res = new ArrayList<>();
        /**
         * 1 2 4 6 7 8 10
         *     s
         *       f
         */
        while(f < input.size() ){
            cur = input.get(f);
            prev = input.get(f-1);
            while(f < input.size() - 1 && cur == prev + 1) {
                f++;
                cur = input.get(f);
                prev = input.get(f-1);
            }
            // check edge case
            if(f == input.size() - 1) {
                cur = input.get(f);
                prev = input.get(f -1);
                if(cur == prev + 1) {
                    f++;
                    break;
                }
            }

            if(f - s > 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(input.get(s));
                sb.append("-");
                sb.append(input.get(f - 1));
                res.add(sb.toString());
                s = f;
                f++;
            } else {
                res.add(new Integer(prev).toString());
                s++;
                f++;
            }
        }

        // post processing
        if(f - s > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(input.get(s));
            sb.append("-");
            sb.append(input.get(f - 1));
            res.add(sb.toString());
        } else {
            res.add(input.get(f-1).toString());
        }

        return res;
    }

    public static void main(String[] args) {
        TESTcompressString cs = new TESTcompressString();
        List<Integer> input = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            input.add(sc.nextInt());
        }
        System.out.println(input);

        List<String> res = cs.compress(input);
        int cont = 0;
        for(String str : res) {
            System.out.print(str);
            if (cont != res.size() - 1)  {
                System.out.print(",");
            }
            cont++;
        }
    }
}
