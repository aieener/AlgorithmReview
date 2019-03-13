package CIT_594;
import java.util.LinkedList;

/**
 * Implementation of stack of strings using java's built-in linked list
 */
public class StackImpl {
	
	LinkedList<String> list;
	
	public StackImpl() {
		list = new LinkedList<>();
		
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * @param value
	 */
	public void push(String value) {
		list.offerFirst(value);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return value
	 */
	public String peek() {
		return list.peekFirst() ;
	}


	/**
	 * Removes the value at the top of this stack and returns it.
	 * @return value
	 */
	public String pop() {
		return list.pollFirst();
	}

	/**
	 * Tests if this stack is empty.
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * Returns the number of elements in the stack
	 * @return number of elements
	 */
	public Integer size() {
		return list.size();
	}
	
	/**
	 * Returns a string representation of the contents of the stack. (any format that shows the elements and order as a string)
	 */
	@Override
	public String toString() {
	    StringBuilder bs = new StringBuilder();
        for(String str : list) {
        	bs.append(str);
		}

		return bs.toString();
	}
	
}
