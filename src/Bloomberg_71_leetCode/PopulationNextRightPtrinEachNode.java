package Bloomberg_71_leetCode;

/**
 * Created by yuding on 2/8/18.
 * LeetCode 116, this one is a very good basic problem!!!
 */
public class PopulationNextRightPtrinEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        while(root != null && root.left != null) {
            TreeLinkNode cur = root;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                } else {
                    cur.right.next = null;
                }
                cur = cur.next;
            }
            root = root.left; // go down to next level
        }
    }


    //------- prac ---------
    public void connect2(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        while(root != null && root.left != null){
            TreeLinkNode cur = root;
            while(cur != null) {

                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                } else {
                    cur.right.next = null;
                }
                cur = cur.next; // go righ
            }
            root = root.left; // go down
        }
    }
}
