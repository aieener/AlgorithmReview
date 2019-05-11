package alg.laioffer.class7.stringI.hashtable;

import java.util.Deque;
import java.util.LinkedList;

public class DeDupIV {
	/**
	 * abbbaaccz f |z
	 *     f
	 */
	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		Deque<Character> stack = new LinkedList<>();
		char[] inputArr = input.toCharArray();
		stack.offerFirst(inputArr[0]);
		for (int i = 1; i < inputArr.length; i++) {
			if (stack.isEmpty() || stack.peekFirst() != inputArr[i]) {
				stack.offerFirst(inputArr[i]);
			} else {
				while (i < inputArr.length && stack.peekFirst() == inputArr[i]) {
					i++;
				}
				stack.pollFirst();
				i--; // this is important!
			}
		}
		return extractStringFromStack(stack);
	}

	private String extractStringFromStack(Deque<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DeDupIV dd = new DeDupIV();
		String input = "abbbaaccz";
		String res = dd.deDup(input);
		System.out.println(res);
	}
}
