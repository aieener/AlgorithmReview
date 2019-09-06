package alg.leetcode.amazon.graph;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.List;

/**
 * TreeMap: sort the map by key automatically!
 * https://stackoverflow.com/questions/13761871/why-and-when-to-use-treemap
 *
 * Let's say you want to implement a dictionary and print it in alphabetical order, you can use a combination of a TreeMap and a TreeSet:
 * public static void main(String args[]) {
 *     Map<String, Set<String>> dictionary = new TreeMap<>();
 *     Set<String> a = new TreeSet<>(Arrays.asList("Actual", "Arrival", "Actuary"));
 *     Set<String> b = new TreeSet<>(Arrays.asList("Bump", "Bravo", "Basic"));
 *
 *     dictionary.put("B", b);
 *     dictionary.put("A", a);
 *
 *     System.out.println(dictionary);
 * }
 * All the sorting is done automatically and it prints:
 *
 * {A=[Actual, Actuary, Arrival], B=[Basic, Bravo, Bump]}
 *
 * You could have sorted the structures manually too of course but using TreeMap/Set can be more efficient,
 * reduces the number of lines of code (= the number of bugs) and is more readable.
 *
 * TreeMap sort key, TreeSet sort array
 */
public interface BinTreeVerticalTraversal {
  List<List<Integer>> verticalOrder(TreeNode root);
}
