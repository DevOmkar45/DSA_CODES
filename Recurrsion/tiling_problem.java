package Recurrsion;

public class tiling_problem {
	
	public static int tilingProblem(int n) {
		//base case if n == 1 and n == 2 then 1 2 way respectively 
		if(n == 1 || n == 2) {
			return n;
		}
		
		return tilingProblem(n-1) + tilingProblem(n-2);
	}

	public static void main(String[] args) {
		int breadth = 4;
		
		System.out.println(tilingProblem(breadth));
		
	}
}
