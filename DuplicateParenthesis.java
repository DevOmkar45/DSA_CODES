package Stack;
import java.util.Stack;

public class DuplicateParenthesis {
	
	public static boolean checkDup(String Str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<Str.length(); i++) {
			char ch = Str.charAt(i);
			int count = 0;
			
			if(ch != ')') {
				s.push(ch);
			} else {
				while(s.peek() != '(') {
					s.pop();
					count++;
				}
				
				if(count >= 1) {
					s.pop();
				} else {
					return false;
				}
			}
		}
		
		if(s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "(((a+b) + (c+d)))";
		
		System.out.println(checkDup(str));
	}
}
