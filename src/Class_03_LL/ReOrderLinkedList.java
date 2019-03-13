package Class_03_LL;

public class ReOrderLinkedList {
    public ListNode ReOrderLinkedList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode mid = findMedian(head);
        ListNode SecondHalf = mid.next;
        SecondHalf = reverse(SecondHalf);
        mid.next = null;
        ListNode FirstHalf = head;

        return mergeTwoList(FirstHalf, SecondHalf);
    }

    private ListNode findMedian(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // stop at n3 instead of n4
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode currNode = head;
        ListNode preNode = null;
        ListNode nextNode;
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        //------
        // my bad version
//        ListNode dummyNode = list1;
//        ListNode tail = dummyNode;
//        list1 = list1.next;
//        boolean l1 = false;
//
//        while(list1 != null && list2 != null){
//            if(l1){
//                tail.next = list1;
//                list1 = list1.next;
//                l1 = false;
//            } else {
//                tail.next = list2;
//                list2 = list2.next;
//                l1 = true;
//            }
//            tail = tail.next;
//        }

        // laiOffer Sol
        while (list1 != null && list2 != null) {
            tail.next = list1;
            list1 = list1.next;
            tail.next.next = list2;
            list2 = list2.next;
            tail = tail.next.next;
        }

        if(list1 != null){
            tail.next =list1;
        } else {
            tail.next =list2;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ReOrderLinkedList rll = new ReOrderLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = rll.ReOrderLinkedList(head);
        res.printList();
    }

    //--- prac ---

}
