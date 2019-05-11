package alg.penn.bloomberg;


import java.util.*;

/**
 * LeetCode 386
 * Created by yuding on 2/14/18.
 * 13 --> [1, 10, 11, 12, 13,2,3,4,5,6,7,8,9]
 * Radix Sort?
 */
public class LexicalOrder {
    public List<Integer> lexicalOrderFailed(int n ) {
        // first generate the number list
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // figure out the maximun dig len
        int len = 0;
        while(n / 10 != 0) {
            len++;
            n = n / 10;
        }

        // sort arr using radix sort
        return radixSort(arr, len);
    }
    private List<Integer> radixSort(int [] arr, int len) {
        int digNum = 0;
        while(digNum <= len) {
            arr = countSort(arr, len - digNum);
            digNum++;
        }
        List<Integer> res = new ArrayList<>();
        for(int cur : arr) {
            res.add(cur);
        }
        return res;
    }

    private int[] countSort(int [] arr, int digNum) {
        // ignore 0!!Less take from 0 to 9
        int [] Less = new int [10];
        int [] Count = new int [10];

        // fill count
        for(int i = 0; i < arr.length; i++) {
            int curDig = getIdxDig(arr[i], digNum);
            System.out.println(curDig);
            Count[curDig]++;
        }

        System.out.println("============");
        // fill less
        for(int j = 1; j < 10; j++) {
            for(int i = j - 1; i >= 0; i--) {
                Less[j] += Count[i];
            }
        }

        // form sorted arr
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int curDig = getIdxDig(arr[i], digNum);
            res[Less[curDig]] = arr[i];
            Less[curDig]++;
        }

        System.out.println(Arrays.toString(res));
        return res;
    }

    private int getIdxDig(int num, int digNum) {
        // 0 ge
        // 1 shi
        // 2 bai
        int res = num;
        int temp = num;
        int resLen = 0;
        //pading
        while(temp/10!= 0) {
            temp = temp/10;
            resLen++;
        }
        if(resLen == digNum){
            while( digNum != 0) {
                res = res/10;
                digNum--;
            }
            return res % 10;
        }
        return 0;

    }

    /**
     * DFS the correct sol
     */

    public List<Integer> lexicalOrder(int n ) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            dfs(res, n, i);
        }
        return res;
    }

    private void dfs(List<Integer> res, int n, int startDig) {
        if(startDig > n) {
            return;
        }
        res.add(startDig);
        for(int i = 0; i < 10; i++) {
            int genNum = startDig * 10 + i;
            if(genNum > n) {
                return;
            }
            dfs(res, n, genNum);
        }
        return;
    }

    public static void main(String[] args) {
        LexicalOrder lo = new LexicalOrder();
//        System.out.print(lo.lexicalOrderFailed(13));
        System.out.print(lo.lexicalOrder(13));
    }

    //---------- prac -------------
    /**
     *      1   2    3    4  ....  9
     *  10 11 12..
     * 110 111
     * ...
     */
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            dfs2(res, n, i);
        }
        return res;
    }

    private void dfs2(List<Integer> res, int n, int startDig) {
        // base case
        if(startDig > n) {
            return;
        }
        res.add(startDig);
        for(int i = 0; i < 10; i++) {
            int curDig = startDig*10 + i;
            dfs(res,n,curDig);
        }
        return;
    }


}
