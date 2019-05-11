package alg.penn.baicizhan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TESTallPer {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if ( set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        helper(array, 0, res);

        return res;
    }

    private void helper(char[] array, int idx, List<String> result) {
        if(idx == array.length) {
            result.add(new String(array));
            return;
        }

        // all the possible char could be placed at idx are the char
        // in the subarray (idx, array.length - 1)
        for(int i = idx; i < array.length; i++) {
            swap(array, idx, i);
            helper(array, idx + 1, result);
            // swap back when track to previous level
            swap(array, idx, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        TESTallPer ap = new TESTallPer();

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            sb.append(sc.nextInt());
        }
        String input = sb.toString();
        List<String>res = ap.permutations(input);
        Collections.sort(res);
        for(String str: res) {
            System.out.println(str);
        }
    }
}
