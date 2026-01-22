package Recurrsion;

public class Friend_pairing_Pro {

	public static int totalPair(int n) {
		if(n == 1 || n == 2) {
			return n;
		}
		
		return totalPair(n-1) + totalPair(n-2)*(n-1);
	}
	
	public static void main(String[] args) {
		int friends = 4;
		System.out.println(totalPair(friends));
		
	}
}
