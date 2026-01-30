package LinkedList;

public class createLL {

	//simple node class 
	public static class Node{
		int data;			//having some data
		Node next;			//and pointer to next node
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//linked list has head and tail
	public static Node head;
	public static Node tail;
	public static int size;
	
	//add first function to add element from starting 
	public static void addFirst(int data) {
		Node newNode = new Node(data);
		size++;
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	//add Last function to add element from last
	public static void addLast(int data) {
		Node newNode = new Node(data);
		size++;
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		//tail ka next newNode and tail newNode ko
		tail.next = newNode;
		tail = newNode;
	}
	
	//insert in between in particular index
	public static void insert(int idx, int data) {
		//create new node first
		Node newNode = new Node(data);
		size++;
		
		if(idx == 0) {
			addFirst(data);
			return;
		} 
		
		Node temp = head;
		int i = 0;
		while(i < idx-1) {
			temp = temp.next;
			i++;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	//function to remove node from start
	public static int removeFirst() {
		if(size == 0) {
			System.out.println("empty");
			return -1;
		}
		
		if(size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		//simple make head.next as head
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	//function to remove Node from last
	public static int removeLast() {
		if(size == 0) {
			System.out.println("empty");
			return -1;
		}
		
		if(size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		//go to tail ke prev node pr then make it tail
		Node temp = head;
		int i = 0;
		
		while(i< size - 2) {
			temp = temp.next;
			i++;
		}
		
		int val = temp.next.data;
		temp.next = null;
		tail = temp;
		size--;
		return val;
		
	}
	
	//function to print element in linkedlist
	public static void print() {
		if(size == 0) {
			System.out.println("empty");
			return;
		}
		
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		createLL newlist = new createLL();
		newlist.addFirst(2);
		newlist.addFirst(3);
		
		newlist.print();
	}

}
