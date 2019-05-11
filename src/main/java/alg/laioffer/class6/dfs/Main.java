package alg.laioffer.class6.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<String> permutationsLai(String set) {
        List<String> result = new ArrayList<>();
        if ( set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
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
        Main ap = new Main();

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            sb.append(sc.nextInt());
        }
        String input = sb.toString();
//        System.out.println(input);
        List<String>res = ap.permutationsLai(input);
        Collections.sort(res);
        for(String str: res) {
            System.out.println(str);
        }

    }
}
