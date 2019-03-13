package CIT_594;

import java.util.LinkedList;

/**
 * Implementation of queue of integers using java's built-in linked list
 */
public class QueueImpl {
	
	LinkedList<Integer> list;
	
	public QueueImpl() {
		list = new LinkedList<>();
	}
	
	/**
	 * Inserts the specified element into this queue
	 */
	public boolean enqueue(Integer value) {
	    return list.offerFirst(value);
	}
	
	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 */
	public Integer dequeue() {
	    return list.removeLast();
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 */
	public Integer peek() {
		return list.getFirst();
	}
	
	/**
	 * Returns the number of elements in the queue
	 * @return number of elements
	 */
	public Integer size() {
		return list.size();
	}
	
	/**
	 * Returns a string representation of the contents of the queue. (any format that shows the elements and order as a string)
	 */
	@Override
	public String toString() {
		StringBuilder bs = new StringBuilder();
        for(Integer str : this.list) {
        	bs.append(str);
		}
	    bs.reverse();

	    return bs.toString();
	}
}
