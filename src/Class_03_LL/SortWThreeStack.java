package Class_03_LL;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 12/19/17.
 * 5 star question !!!
 * this is basically another version of merge sort!
 * talked about this method in Class 1
 */
public class SortWThreeStack {
    public void sort(LinkedList<Integer> s1){
        Deque<Integer> s2 = new LinkedList<>();
        Deque<Integer> s3 = new LinkedList<>();
        sort(s1,s2,s3,s1.size());
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2,
                      Deque<Integer> s3, int len){
        //base case
        if(len <= 1){
            return;
        }

        // half and the other half
        int mid = len /2;
        int mid2 = len - len /2;
        // put mid amount of elem from s1 to s2
        for(int i = 0; i< mid; i++){
            s2.offerFirst(s1.pollFirst());
        }

        sort(s2,s3,s1,mid);
        sort(s1,s3,s2,mid2);

        // s1 and s2 will be sorted
        // merge: who small, pick who
        int i = 0;
        int j = 0;
        while(i < mid && j < mid2){
            if(s2.peekFirst() < s1.peekFirst()){
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }

        while(i < mid){
            s3.offerFirst(s2.pollFirst());
            i++;
        }

        while( j < mid2){
            s3.offerFirst(s1.pollFirst());
            j++;
        }

        // now s3 contains the sorted data!
        // put it back to s1
        for(int idx = 0; idx < len; idx++){
            s1.offerFirst(s3.pollFirst());
        }
    }
}
