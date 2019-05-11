package alg.penn.bloomberg;

/**
 * Created by yuding on 2/8/18.
 * Iterative BFS
 * LeetCode 117
 *
              1 -> NULL
            /  \
           2 -> 3 -> NULL
          / \    \
         4-> 5 -> 7 -> NULL
 *
 * No extra space
 * Need to revisit this one
 * it’s basicly a level BFS without using additional queue,
 * as the next link already serves the queue functionality
 */
class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x){
        val = x;
    }
}


public class PopulatingNextRightPtrInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        TreeLinkNode head = root; // left most node in lower level: ListHead
        TreeLinkNode prev = null; // prev node in the lower level
        TreeLinkNode cur = null; // cur Node in the UPPER level

        while(head != null) {
            cur = head;
            prev = null;    // Both prev ptr and head plays a very important role
                            // for the case that there is a 'dead' level
            head = null;
            /**
             * Cases for each cur:
             *      A: has both left and right children
             *               r ->  ..
             *              / \
             *             4-> 5 -> ..
             *
             *      B: has only left child
             *            (cur)r ->  ..
             *              /
             *       (pre/head)4-> ..
             *      C: has only right child
             *               r ->  ..
             *                \
             *       (pre/head)5 -> ..
             *      D: don't have any child
             */
            while(cur != null) {
                // left child
                if(cur.left != null) {
                    if(prev != null) {
                        prev.next = cur.left;
                        prev = prev.next; // move prev
                    } else {
                        // prev == null
                        // this a brand new level
                        head = cur.left;
                        prev = head;  // move prev
                    }
                }

                // right child
                if(cur.right != null) {
                    if(prev != null) {
                        prev.next = cur.right;
                        prev = prev.next; // move prev
                    } else {
                        // prev == null
                        // this a brand new level
                        head = cur.right;
                        prev = head;  // move prev
                    }
                }
                // move to next node
                cur = cur.next;
            }
        }
    }


    public void connect2(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode head = root;
        TreeLinkNode cur = null;
        TreeLinkNode prev= null;

        while(head != null) {
            cur = head;   // move cur down to next level
            head = null;  // reset head
            prev = null;  // reset prev
            while (cur != null) {
                // left child
                if(cur.left != null) {
                    if(prev != null) {
                        prev.next = cur.left;
                        prev = prev.next;
                    } else {
                        head = cur.left;
                        prev = head;
                    }
                }
                if(cur.right != null) {
                    if(prev != null) {
                        prev.next = cur.right;
                        prev = prev.next;
                    } else {
                        head = cur.right;
                        prev = head;
                    }
                }
                // right child
                cur = cur.next;
            }
        }
    }

    //----- prac -----------

}
