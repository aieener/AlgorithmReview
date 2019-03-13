package HuaWeiOA;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ResultType {
    Integer ori;
    Integer mod;
    ResultType(Integer ori, Integer mod) {
        this.ori = ori;
        this.mod = mod;
    }
}

public class ThridOne {

    public List<ResultType> quickSort(List<ResultType> array){
        if(array == null || array.size() == 0 ){
            return array;
        }
        qSort(array, 0, array.size() - 1);
        return array;
    }

    // wrapper function
    public void qSort(List<ResultType> array, int start, int end){
        // base case
        if(start >= end){
            return;
        }

        int pivotPos = partition(array, start, end);
        // pivot is already sits at its position, when do the
        // recursive call, we don't include pivot in any of them
        qSort(array, start,pivotPos - 1);
        qSort(array, pivotPos + 1, end);
    }

    private int partition(List<ResultType> array, int start, int end){
        int pivotIndex = pivotIndex(start, end);
        int pivot = array.get(pivotIndex).mod;
        // swap the pivot with the right most elem first
        swap(array, pivotIndex, end);

        int l = start;
        int r = end - 1;
        while( l <= r){
            if(array.get(l).mod < pivot){
                l++;
            } else if (array.get(r).mod > pivot){
                r--;
            } else {
                swap(array, l++, r--);
            }
        }

        // swap back pivot elem
        // since pivot is at end
        // when cross l is to the right of r
        swap(array, l, end);

        return l;
    }

    private int pivotIndex(int left, int right){
        // Math.random() --> (0, 1)
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(List<ResultType> array, int left, int right){
        ResultType temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right,temp);
    }



    public List<ResultType> mergeSort(List<ResultType> array){
        if(array== null || array.size() == 0){
            return array;
        }

        int start = 0;
        int end = array.size() - 1;
        List<ResultType> temp = new ArrayList<>(array);
        mSort(array, temp, start, end);
        return array;
    }

    private void mSort(List<ResultType> array, List<ResultType> temp, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mSort(array, temp, start, mid);
        mSort(array, temp, mid + 1, end);
        merge(array, temp, start, mid, end);
    }

    private void merge(List<ResultType> array, List<ResultType> temp, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = start;
        while( i <= mid && j <= end){
            if(array.get(i).mod < array.get(j).mod){
                temp.set(k, array.get(i));
                k++;
                i++;
            } else {
                temp.set(k, array.get(j));
                k++;
                j++;
            }
        }
        while( i <= mid){
            temp.set(k, array.get(i));
            k++;
            i++;
        }
        while( j <= end){
            temp.set(k, array.get(j));
            k++;
            j++;
        }

        for(int l = start; l <= end; l++){
            array.set(l, temp.get(l));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        // load the input
        String numbers = sc.nextLine();
        String stringPos = sc.nextLine();
        Integer pos = Integer.valueOf(stringPos);

        char[] inputNum = numbers.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character cur : inputNum) {
            if(cur != ' '){
                sb.append(cur);
            } else {
                input.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
            }
        }
        input.add(Integer.valueOf(sb.toString()));

        // now we got the input ArrayList<Integer> and the target pos
        // Since we want to sort by the last three dig we do some work with the
        // input store the new input as newInput

        List<Integer> newInput = new ArrayList<>(input);
        List<ResultType> CompositeInput = new ArrayList<>();

        for(int i = 0; i < newInput.size(); i++) {
            if(newInput.get(i) >= 1000) {
                newInput.set(i, newInput.get(i)%1000);
            }
            CompositeInput.add(new ResultType(input.get(i), newInput.get(i)));
        }

        ThridOne qs = new ThridOne();
        // now sort the input
        List<ResultType> res = new ArrayList<>();
        res = qs.mergeSort(CompositeInput);
        System.out.println(res.get(pos - 1).ori);
    }


    //------------------------华为
    public void swapWithZero(int[] array, int len, int n) {
        int zidx = 0;
        for(Integer i : array) {
            if(i == 0) {
                break;
            }
            zidx++;
        }
        int nidx = 0;
        for(Integer i : array ){
            if(i == n) {
                break;
            }
            nidx++;
        }
//        swap(array, zidx, nidx);
    }

    public void sort(int[] array, int len) {
        // 完成这个函数
        if(array == null || len == 0) {
            return;
        }
        swapWithZero(array,len,array[0]);
        for(int i = 1; i < len; i++) {
            int minIdx = i;
            for(int j = i; j < len; j++) {
                if(array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swapWithZero(array,len,array[minIdx]);
            swapWithZero(array,len,array[i]);
            swapWithZero(array,len,array[0]);
        }
    }
}
