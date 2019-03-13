package Class_03_LL;

public class InsertinSLL {
    // Cation the trap!
    // 操作任何数据结构， 一定注意一头一尾corner case！

    // Notice, in java is do void, we are losing the HEAD!
    // This is no like C++!!!
    public ListNode insert(ListNode head, int value){
        if(head == null){
            return new ListNode(value);
        }
        if(value < head.value){
            // corner case: head will be changed
            ListNode newNode = new ListNode(value);
            newNode.next= head;
            return newNode;
        }

        // find the inserting spot
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode != null && curNode.value <= value){
            preNode = curNode;
            curNode = curNode.next;
        }
        // now curNode > value
        // after insert it should look like   preNode->newNode->curNode
        ListNode newNode = new ListNode(value);
        newNode.next = curNode;
        preNode.next = newNode;

        return head;
    }


    public ListNode insertInClassVersion(ListNode head, int target){
        ListNode newNode = new ListNode(target);

        if(head == null || head.value >= target) {
            // >= is better than >, since it can stop earlier
            newNode.next = head;
            return newNode;
        }

        ListNode curr = head;

        while(curr != null) {
            // reach tail when curr.next == null
            if( curr.next == null || target <= curr.next.value) {
                break;
            }
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        InsertinSLL il = new InsertinSLL();
        ListNode head = new ListNode(1);
        il.insert(head,3);
        head.printList();
    }
    //---- prac ----
}
