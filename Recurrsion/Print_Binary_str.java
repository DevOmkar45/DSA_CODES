package Recurrsion;

public class Print_Binary_str {

	public static void printBinary(int n, String str, int ld) {
		//base case
		if( n == 0) {
			System.out.println(str);
			return;
		}
		
		printBinary(n-1, str+"0", 0);
		if(ld == 0) {
			printBinary(n-1, str+"1", 1);
		}
	}
	
	public static void main(String[] args) {
		printBinary(4, "", 0);
	}
	
}
