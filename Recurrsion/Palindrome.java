package LinkedList;

public class Palindrome {

	public static boolean palindrome(createLL.Node head) {
		int n = createLL.size;
		int mid = n/2;
		createLL.Node temp = head;
		
		for(int i=1; i<mid; i++) {
			temp = temp.next;
		}
		
		createLL.Node secondHead = temp.next;
		temp.next = null;
		
		//reversing second half
		createLL.Node prev = null;
		createLL.Node curr = secondHead;
		createLL.Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		secondHead = prev;
		
		//now half row got reversed now start checking 
		createLL.Node temp1 = head;
		createLL.Node temp2 = secondHead;
		
		while(temp1 != null) {
			if(temp1.data != temp2.data) {
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		createLL.addLast(1);
		createLL.addLast(2);
		createLL.addLast(3);
		createLL.addLast(2);
		createLL.addLast(1);
		createLL.addLast(2);
		
		//createLL.print();
		
		System.out.println(palindrome(createLL.head));
		
	}
}
