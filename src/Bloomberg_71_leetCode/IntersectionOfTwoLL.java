package Bloomberg_71_leetCode;

import Class_03_LL_Stack_Queue.ListNode;

/**
 * LeetCode 160
 * Created by yuding on 2/12/18.
 * NC version of LCA
 */
public class IntersectionOfTwoLL {
    /**
     * Sol 1 reverse it
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = reverse(headA);
        ListNode B = reverse(headB);
        while(A != null && B != null) {
            if(A.value == B.value) {
                return A;
            }
            A = A.next;
            B = B.next;
        }

        return null;
    }

    public ListNode reverse (ListNode head) {
       if(head == null) {
           return head;
       }
       ListNode curr = head;
       ListNode prev = null;
       while(curr != null) {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
    }

    /**
     * Sol 2
     * My Sol
     */

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int aLen = getLen(headA);
        int bLen = getLen(headB);
        int diff = Math.abs(aLen - bLen);

        ListNode longList = aLen > bLen ? headA : headB;
        ListNode sortList = longList == headA ? headB : headA;

        int count = 0;
        while(count < diff) {
            longList = longList.next;
            count++;
        }

        while(longList != null && sortList != null) {
            if(longList.value == sortList.value ){
                return longList;
            }
            longList = longList.next;
            sortList = sortList.next;
        }

        return null;
    }
    private int getLen(ListNode head) {
        int res = 0;
        while(head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    /**
     * Sol 3 nineChapt, Using cycle!
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }

    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLL ll = new IntersectionOfTwoLL();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        b.next = new ListNode(3);
        System.out.print(ll.getIntersectionNode2(a,b).value);
    }

    //--------- prac -----------
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        int lenA = getLen2(headA);
        int lenB = getLen2(headB);
        int dif = Math.abs(lenA - lenB);
        if(lenA > lenB) {
            while(dif > 0) {
                headA = headA.next;
                dif--;
            }
        } else {
            while(dif > 0) {
                headB = headB.next;
                dif--;
            }
        }

        while(headA != headB && headA!= null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen2(ListNode head) {
        if(head == null) {
            return 0;
        }
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
