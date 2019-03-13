
package CIT_594;

public class Tester {
	public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		
		String s1 = "Pennsylvania";
		String s2 = " of ";
		String s3 = "University";
		
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		
		System.out.println(stack.toString());
		
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		
		System.out.println(stack.toString());

		QueueImpl queue = new QueueImpl();
		int first = 2;
		int second = 0;
		int third = 1;
		int fourth = 8;
		
		queue.enqueue(first);
		queue.enqueue(second);
		queue.enqueue(third);
		queue.enqueue(fourth);
		
		System.out.println(queue.toString());
		
		System.out.print(queue.dequeue());
		System.out.print(queue.dequeue());
		System.out.print(queue.dequeue());
		System.out.print(queue.dequeue());
		
		System.out.println(queue.toString());
	}
	
}
