package Class_03_LL;

public class Merge2SortLL {
    public ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(one!= null && two!= null){
            if(one.value < two.value){
                tail.next = one;
                one = one.next;
            } else {
                tail.next = two;
                two = two.next;
            }
            tail = tail.next;
        }
        if(one!= null){
            tail.next = one;
        } else if (two!= null){
            tail.next= two;
        }
        return dummy.next;
    }

    // prac

}
