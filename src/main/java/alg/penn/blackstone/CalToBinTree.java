package alg.penn.blackstone;

import java.util.Deque;
import java.util.LinkedList;

/**
 * For this Tree, Root will have the lightest weight
 * LintCode 367
 */
public class CalToBinTree {
    class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = null;
            this.right = null;
        }
    }

    class TreeNode {
        int val;  // weight
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s) {
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }

    public ExpressionTreeNode build(String[] expression) {
        if(expression == null || expression.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        int base = 0;
        int val = 0;

        // 2 * 6 - (23 + 7) / (1 + 2)

        // ( serve as base raiser, ) serve as base resumer
        for(int i = 0; i < expression.length; i++) {
            if(expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if(expression[i].equals(")")) {
                base -= 10;
                continue;
            }

            val = getWeight(base,expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);

            // the last node on the stack is root
            while(!stack.isEmpty() && node.val <= stack.peekFirst().val) {
                // this is when node has less or equal weight
                // so let it's left child to be the one in the stack
                node.eNode.left = stack.pollFirst().eNode;
            }

            if(!stack.isEmpty()) {
                // this is when node has more weight (A catch)
                // so let it be the right kid of the one on the stack
                // Noticed that we never poll from this condition, so root stays there
                stack.peekFirst().eNode.right = node.eNode;
            }
            stack.push(node);
        }

        if(stack.isEmpty()) {
            // if stack isEmpty, there is No root! Error must happened!
            return null;
        }
        TreeNode rst = stack.pollFirst();
        while(!stack.isEmpty()) {
            rst = stack.pollFirst();
        }
        return rst.eNode;

    }

    public int getWeight(int base, String s) {
        if(s.equals("+") || s.equals("-")) {
            return base + 1;
        }

        if(s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        CalToBinTree cb = new CalToBinTree();
        String [] input = new String[] {"2","*", "6" , "-" , "(" ,"23", "+"
        , "7" ,")", "/", "(", "1","+" , "2" , ")"};

        cb.build(input);
    }

    //----- Prac ----------------------------------
    class TreeNode2{
        int weight;
        ExpressionTreeNode eNode;
        TreeNode2(int weight, String symbol) {
            this.weight =  weight;
            this.eNode = new ExpressionTreeNode(symbol);
        }
    }

    public ExpressionTreeNode build2(String[] expression) {
        if(expression == null || expression.length == 0) {
            return null;
        }

        int base = 0;
        int curWeight = 0;
        Deque<TreeNode2> stack = new LinkedList<>();
        for(int i = 0; i < expression.length; i++) {
            if(expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if(expression[i].equals(")")) {
                base-= 10;
                continue;
            }
            curWeight = calWeight(base, expression[i]);
            TreeNode2 newNode = new TreeNode2(curWeight, expression[i]);
            while(!stack.isEmpty() && curWeight < stack.peekFirst().weight) {
                // if its lighter, pop the stack
                TreeNode2 topNode = stack.pollFirst();
                newNode.eNode.left = topNode.eNode;
            }

            if(!stack.isEmpty()) {
                stack.peekFirst().eNode.right = newNode.eNode;
            }
            stack.offerFirst(newNode);
        }
        if(stack.isEmpty()) {
            return null;
        }
        TreeNode2 root = stack.pollFirst();
        while(!stack.isEmpty()) {
            root = stack.pollFirst();
        }
        return root.eNode;

    }

    private int calWeight (int base, String sym) {
        if(sym.equals("+") || sym.equals("-")) {
            return base + 1;
        }
        if(sym.equals("*") || sym.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }



}
