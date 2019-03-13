package Class_MidtermII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 2/9/18.
 */
public class printIfStatement {
    /**
     * My incorrect version
     * @param n
     * @return
     */
    public List<List<String>> printIfStatement(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        StringBuilder padding = new StringBuilder();
        helper(sol, res, n, n, padding);

        return res;
    }

    private void helper(List<String> sol , List<List<String>> res, int l, int r, StringBuilder padding) {
        // base case
        if(l == 0 && r == 0){
            for(String str : sol) {
                System.out.print(str);
            }
            System.out.println("\n================\n");

            res.add(new ArrayList<>(sol));
        }

        if(l > 0){
            sol.add(padding.toString() + "if {\n");
            // increment padding
            padding.append("  ");
            helper(sol, res, l -1, r, padding);
            sol.remove(sol.size() - 1);
        }

        if(r > 0 && r > l){
            sol.add(padding.toString() + "}\n");
            // decrement padding
            if(padding.length() >=2){
                // Assume my padding is 2 spaces
                padding.deleteCharAt(padding.length() - 1);
                padding.deleteCharAt(padding.length() - 1);
            }

            helper(sol, res, l, r - 1,padding);
            sol.remove(sol.size() - 1);
        }
    }

    /**
     * LaiOffer's Sol
     */
    public void printBlocks(int n) {
        char[] array = new char[n * 2];
        helper2(array, n, n, 0);
    }

    private void helper2 ( char[] array, int left, int right, int pos) {
        if(left == 0 && right == 0) {
            printSolution(array); // format it
            return;
        }

        if(left > 0) {
            array[pos] = '{';
            helper2(array,left - 1, right, pos + 1);
        }

        if(right > left) {
            array[pos] = '}';
            helper2(array, left, right - 1, pos + 1);
        }
    }

    private void printSolution(char[] array) {
        int heading = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == '{') {
                printSpace(heading);
                System.out.println("if {");
                heading += 2;
            } else {
                heading -= 2;
                printSpace(heading);
                System.out.println("}");
            }
        }
    }

    private void printSpace(int heading ) {
        for(int i = 0; i < heading; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        printIfStatement pi = new printIfStatement();
        pi.printBlocks(3);
    }
}
