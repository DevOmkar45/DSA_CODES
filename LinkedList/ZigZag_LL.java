package LinkedList;

public class ZigZag_LL {

	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//function to make zig zag ll
	public static void zigZag( Node head ) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//reversing second half
		Node curr = slow.next;
		slow.next = null;
		Node prev = null;
		Node next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		//specify both head
		Node left = head;
		Node right = prev;
		Node nextL, nextR;
		
		while(left != null && right != null) {
			nextL = left.next;			//you have to store the refernce of next left
			left.next = right;
			nextR = right.next;			//same for right
			right.next = nextL;
			
			left = nextL;
			right = nextR;
		}
	}
	
	//functin to print ll
	public static void print(Node head) {
		Node temp = head;
		while(temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		print(head);
		zigZag(head);
		print(head);
	}
	
}
