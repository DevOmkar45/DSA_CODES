package LinkedList;

public class ReverseLL {
	
	public static createLL.Node reverse(createLL.Node head) {
		
		createLL.Node prev = null;
		createLL.Node curr = head;
		createLL.Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		
		createLL.addLast(1);
		createLL.addLast(2);
		createLL.addLast(3);
		
		createLL.print();
		
		createLL.head = reverse(createLL.head);
		
		createLL.print();
		
		//this are dirrect method
//		LinkedList<Integer> list = new LinkedList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		System.out.println(list);
//		
//		Collections.sort(list, Collections.reverseOrder());
//		System.out.println(list);
		
	}

}
