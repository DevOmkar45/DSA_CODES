package Stack;
import java.util.Stack;

public class StockSpanProbb {

	public static void stockSpan(int stock[], int span[]) {
		
		//first form stack 
		Stack<Integer> s1 = new Stack<>();
		s1.push(0);
		span[0] = 1;
		
		for(int i=1; i<stock.length; i++) {
			
			//we are storing curval to compare
			int currVal = stock[i];
			while(!s1.isEmpty() && currVal >= stock[s1.peek()]) {
				s1.pop();
			}
			
			if(s1.isEmpty()) {
				span[i] = i+1;
			} else {
				int prevVal = s1.peek();
				span[i] = i - prevVal;
			}
			
			//every time push the curr price for the next one's
			s1.push(i);
		}
	}
	
	public static void main(String[] args) {
		int stock[] = {100, 80, 60, 70, 60, 85, 100};
		int span[] = new int[stock.length];
		
		stockSpan(stock, span);
		
		for(int i=0; i<span.length; i++) {
			System.out.print(span[i]+" ");
		}
	}
}
