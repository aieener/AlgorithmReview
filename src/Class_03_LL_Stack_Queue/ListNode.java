package Class_03_LL_Stack_Queue;

public class ListNode {
    // Note:
    // dummyNode, 生成 newHead , 不new 会NPE
    // in order to get rid of NPE, we new a dummyHead = new ListNode(0);
    // At the end, return dummyHead.next;
    //
    // When to declare dummyNode:
    //      When we want to construct a linkedlist from scratch, at this moment,
    //          we don't have a headNode yet, thus inorder to avoid NPE, (head.next = null)
    //      Use:
    //          - Merge two sorted LinkedList
    // When to declare a tailNode:
    //      When we want to operate/append at tail, otherwise it is expensive to append (more runtime efficient.)
    //
    public int value;
    public ListNode next;
    public ListNode(int value){
        this.value = value;
        next = null;
    }

    public void printList(){
        ListNode tail = this;
        if(tail == null) {
            System.out.print("NULL");
        }
        while(tail != null){
            System.out.print(String.valueOf(tail.value) + "->");
            tail = tail.next;
        }
        return;
    }
}
