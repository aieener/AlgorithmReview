package alg.laioffer.class26.adv3recursionIII;

import alg.laioffer.class5.bintree.TreeNode;

public class ReconstructBSTWithPostOrder {
  /**
   * reconstruct sequence
   * right, left, root
   * post order: left right root
   */
  public TreeNode reconstruct(int[] post) {
    int[] index = new int[] {post.length - 1};
    return helper(post, index, Integer.MIN_VALUE);
  }

  private TreeNode helper(int[] postorder, int[] index, int min) {
    if(index[0] < 0 || postorder[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[index[0]--]);
    System.out.println("idx of this right branch is :" + index[0] + " min is " + min);
    root.right = helper(postorder, index, root.key); // the order matters!
    System.out.println("idx of this left branch is :" + index[0] + " min is " + min);
    root.left = helper(postorder, index, min);
    System.out.println(root.key);
    System.out.println("right child " + (root.right != null ? root.right.key : "#"));
    System.out.println("left child " + (root.left != null ? root.left.key : "#"));
    return root;
  }

  public static void main(String[] args) {
    ReconstructBSTWithPostOrder rc = new ReconstructBSTWithPostOrder();
    int[] post = new int[] {1,4,3,11,8,5};
    rc.reconstruct(post);
  }

}
