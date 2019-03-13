package CIT_594;


public class ChallengeTester {
	public static void main(String[] args) {
		
		// Question 1: Complete isValidParenthesis function using the methods from your stack
		StackImpl stack = new StackImpl();
		String s1 = "()))"; // Invalid
		String s2 = "((()))"; // Valid
		String s3 = "()()"; // Valid
		String s4 = "(()"; // Invalid
		String s5 = "("; // Invalid
		boolean isValid = isValidParenthesis(s1); // --> False
		
		// Question 2: 
		QueueImpl queue = new QueueImpl();
		queue.enqueue(5);
		queue.enqueue(3);
		queue.enqueue(7);
		int sumOfElements = sumOfElementsOfQueue(queue);  // --> 15
	}
	
	/**
	 * Checks if a string of only '(' and ')' characters forms a valid parenthesis string, i.e., opens and closes all parenthesis correctly
	 */
	public static boolean isValidParenthesis(String s){
		return false;
	}
	
	/**
	 * Return the sum of all values in a queue
	 */
	public static Integer sumOfElementsOfQueue(QueueImpl queue){
		return null;
	}
	
}
