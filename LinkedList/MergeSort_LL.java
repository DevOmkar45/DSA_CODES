package LinkedList;

public class MergeSort_LL {

	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node mergeSort(Node head) {
		//base case
		if(head.next == null || head == null) {
			return head;
		}
		
		//find mid node
		Node mid = findMid(head);
		Node rightHead = mid.next;
		mid.next = null;
		
		//calling mergesort for both right and left side
		Node left = mergeSort(head);
		Node right = mergeSort(rightHead);
		
		//after sorting from mid now merge both part
		return merge(left, right);
	}
	
	public static Node findMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static Node merge(Node head1, Node head2) {
		Node mergeLL = new Node(-1);
		Node temp = mergeLL;
		
		while(head1 != null && head2 != null) {
			//check both heads 
			if(head1.data > head2.data) {
				temp.next = head2;
				head2 = head2.next;
			} else {
				temp.next = head1;
				head1 = head1.next;
			}
			temp = temp.next;
		}
		
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return mergeLL.next;
	}
	
	//function to print linkedlist
	public static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(9);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(8);
		
		print(head);
		Node newHead = mergeSort(head);
		print(newHead);
		
	}
}
