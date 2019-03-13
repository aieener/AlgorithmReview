package Class_03_LL;

public class PartitionLL {
    // Amazon 常出 keep the origin relative order
    public ListNode partition (ListNode head, int target) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode curSmall = smallDummy;
        ListNode curLarge = largeDummy;

        while( head != null) {
            if(head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }

        // concat
        curSmall.next = largeDummy.next;
        // the next line is extremely important!!!
        // Because curLarge.next might points to other Nodes!
        // 1 -> 6 -> 3 -> 2a -> 5 -> 2b
        // ==> 1 -> 3 -> 2a -> 2b -> 6 -> 5 -> 2b -> ...
        // THERE IS A CYCLE!!!
        curLarge.next = null;
        return smallDummy.next;

    }



    public static void main(String[] args) {
        PartitionLL pll = new PartitionLL();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

//        ListNode res = pll.partition(head, 3);
        ListNode res = pll.partition2(head, 3);
        res.printList();
    }

    // --- prac ---
    public ListNode partition2(ListNode head, int target) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;

        while(head != null) {
            if(head.value < target) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightDummy.next;
        rightTail.next = null;
        return leftDummy.next;
    }
}
