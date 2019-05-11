package alg.penn.bloomberg;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Feb 20
 * LeetCode 105
 * preorder gives the root
 * find that root in inorder gives parition of the subtree
 * do it recursively
 *
 * !!!!!!!!! Inorder is not Sorted!!!! Can just use Bin search!!!!!
 *
 * preorder = [3, 9, 20, 15, 7]
 * inorder =  [9, 3, 15, 20, 7]
 */
public class BuiltTreePreAndInorder {
    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = searchIdx(inorder, instart, inend, preorder[prestart]);

        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private int searchIdx(int [] arr, int target, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(arr[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        BuiltTreePreAndInorder bt = new BuiltTreePreAndInorder();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};

        TreeNode root = bt.buildTree(preorder,inorder);
        System.out.println(root.key);
        System.out.println(root.left.key);
        System.out.println(root.right.key);
        System.out.println(root.right.left.key);
        System.out.println(root.right.right.key);

    }


    // ------------ prac ---------------
    public TreeNode buildTreeprein(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        } else if(preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> dict = formIdxDictforInorder(inorder);
        return helper2(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1, dict);
    }

    private Map<Integer, Integer> formIdxDictforInorder(int[] inorder) {
        // var --> index
        Map<Integer, Integer> dic = new HashMap<>();
        int idx = 0;
        for(Integer it : inorder){
            dic.put(it, idx);
            idx++;
        }
        return dic;
    }

    private TreeNode helper2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                             Map<Integer, Integer> dic) {
        // base case
        if(inStart > inEnd) {
            return null;
        }

        int target = preorder[preStart];
        TreeNode res = new TreeNode(target);
//        int inIdx = searchIdx(inorder, target, inStart, inEnd);
        int inIdx = dic.get(target);
        int lsubTreeLen = inIdx - inStart;
        res.left =  helper2(preorder, preStart + 1, preStart + lsubTreeLen, inorder, inStart, inIdx - 1, dic);
        res.right =  helper2(preorder, preStart + lsubTreeLen + 1, preEnd, inorder, inIdx + 1, inEnd, dic);
        return res;
    }

}
