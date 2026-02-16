package Queue;
import java.util.Stack;

public class QueueUsing2Stack {

	static class Queue{
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		public boolean isEmpty() {
			return s1.isEmpty();
		}
		
		public void add(int data) {
			
			while(!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
			
			s1.push(data);
			
			while(!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
		}
		
		//function to remove element
		public int remove() {
			if(isEmpty()) {
				System.out.println("queue is Empty");
				return -1;
			}
			
			return s1.pop();
		}
		
		//function to find element
		public int peek() {
			if(isEmpty()) {
				System.out.println("queue is Empty");
				return -1;
			}
			
			return s1.peek();
		}
	}
	
	public static void main(String[] args) {
		Queue q1 = new Queue();
		q1.add(2);
		q1.add(3);
		
		System.out.println(q1.peek());
	}
}
