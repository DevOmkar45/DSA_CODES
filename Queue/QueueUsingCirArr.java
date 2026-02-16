package Queue;

public class QueueUsingCirArr {
	
	static class Queue2{
		static int arr[];
		static int size;
		static int rear;
		static int front;
		
		public Queue2(int n) {
			arr = new int[n];
			size = n;
			rear = -1;
			front = -1;
		}
		
		//function to find isEmpty
		public boolean isEmpty() {
			return rear == -1 && front == -1;
		}
		
		//fucntion to find isFull
		public boolean isFull() {
			return (rear + 1)%size == front;
		}
		
		//function to add element
		public void add(int data) {
			if(isFull()) {
				System.out.println("queue is full");
				return;
			}
			
			if(front == -1) {
				front = 0;
			} 
			
			rear = (rear + 1)%size;
			arr[rear] = data;
 		}
		
		//function to remove element
		public int remove() {
			if(isEmpty()) {
				System.out.println("queue is Empty");
				return -1;
			}
			
			int val = arr[front];
			
			if(rear == front) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1)%size;
			}
			
			return val;
		}
		
		//function to find value 
		public int peek() {
			if(isEmpty()) {
				System.out.println("queue is Emepty");
				return -1;
			} 
			
			return arr[front];
		}
	}
	
	public static void main(String[] args) {
		Queue2 q = new Queue2(6);
		q.add(1);;
		q.add(2);
		System.out.println(q.peek());
	}

}
