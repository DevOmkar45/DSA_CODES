package Stack;
import java.util.Stack;

public class NextGretEle {
	
	public static void nextGreaterEle(int arr[], int ans[]) {
		
		//first made stack 
		Stack<Integer> s1 = new Stack<>();
		
		for(int i=arr.length-1; i>=0; i--) {
			int currVal = arr[i];
			
			while(!s1.isEmpty() && currVal >= s1.peek()) {
				s1.pop();
			}
			
			if(s1.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = s1.peek();
			}
			
			s1.push(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {6, 8, 0, 1, 3};
		int ans[] = new int[arr.length];
		
		nextGreaterEle(arr, ans);
		
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
