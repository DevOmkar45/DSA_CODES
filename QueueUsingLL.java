package Queue;

public class QueueUsingLL {

	//first made node class
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//queue class
	static class Queue3{
		Node head = null;
		Node tail = null;
		
		//isEmpety function 
		public boolean isEmpty() {
			return head == null && tail == null;
		}
		
		//function to add element
		public void add(int data) {
			Node newNode = new Node(data);
			
			if(isEmpty()) {
				head = tail = newNode;
				return;
			}
			
			tail.next = newNode;
			tail = newNode;
		}
		
		//function to remove element
		public int remove() {
			if(isEmpty()) {
				System.out.println("queue is Emepty");
				return -1;
			}
			int front = head.data;
			
			if(tail == head) {
				head = tail = null;
			} else {
				head = head.next;
			}
			
			return front;
		}
		
		//function to find value
		public int peek() {
			if(isEmpty()) {
				System.out.println("queue is Empty");
				return -1;
			}
			
			return head.data;
		}
	}
	
	public static void main(String[] args) {
		Queue3 q = new Queue3();
		q.add(1);
		q.add(2);
		System.out.println(q.peek( ));
	}
}
