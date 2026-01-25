package Backtracking;

public class Permutation {

	public static void findPermutation(String str, String ans) {
		//base case
		if(str.length() == 0) {
			System.out.print(ans+" ");
			return;
		}
		
		//apply for loop from 0 to end and add every letter
		for(int i=0; i<str.length(); i++) {
			char currChar = str.charAt(i);
			
			String newStr = str.substring(0,i) + str.substring(i+1);
			
			findPermutation(newStr, ans+currChar);
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		findPermutation(str, "");
	}
	
}
