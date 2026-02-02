package LinkedList;

public class Loops {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	
	public static boolean isCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	//function to remove cycle 
	public static void removeCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow = head;
		Node prev = fast;
		while( fast != slow) {
			slow = slow.next;
			prev = fast;
			fast = fast.next;
		}
		
		prev.next = null;
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = head.next.next;
		
		System.out.println(isCycle(head));
		removeCycle(head);
		System.out.println(isCycle(head));
	}

}
