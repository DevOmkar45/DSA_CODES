package Backtracking;

public class subSet {
	
	public static void subSet1(String str, String ans, int idx) {
		
		//base case
		if(idx == str.length()) {
			System.out.print(ans+" ");
			return;
		}
		
		//kaam
		//phele ith wale ko lena hai 
		subSet1(str, ans+str.charAt(idx), idx+1);
		//then ith wale ko nahi lena
		subSet1(str, ans, idx+1);
	}

	public static void main(String[] args) {
		String str = "abc";
		subSet1(str, "", 0);
	}
}
