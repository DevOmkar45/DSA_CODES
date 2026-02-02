package LinkedList;

public class FindNthfrom_last {

	public static void deleteNthLast(createLL.Node head, int n) {
		if(createLL.size == n) {
			head = head.next;
			return;
		}
		
		int i=1;
		int tofind = createLL.size - n;
		createLL.Node prev = head;
		while(i < tofind) {
			prev = prev.next;
			i++;
		}
		
		prev.next = prev.next.next;
		return;
	}
	
	public static void main(String[] args) {
		createLL.addLast(1);
		createLL.addLast(2);
		createLL.addLast(3);
		createLL.addLast(4);
		
		createLL.print();
		
		deleteNthLast(createLL.head, 2);
		
		createLL.print();
	}
}
