package ArrayList;
import java.util.ArrayList;

public class TwoPairSum {
	
	public static boolean pairSum(ArrayList<Integer> list, int target) {
		//initailize this pointers
		int lp=0 , rp = 0;
		
		//find that break point
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i) > list.get(i+1)) {
				 rp = i;
				 lp = i+1;
				 break;
			}
		}
		
		//check weather lp and rp sum is equal to target or not
		while(lp != rp) {
			int sum = list.get(lp)+list.get(rp);
			if( sum == target) {
				return true;
			} else if( sum > target) {
				rp = (rp + list.size() - 1)% list.size();
			} else {
				lp = (lp + 1)%list.size();
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(15);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(10);
		System.out.println(pairSum(list, 22));
	}
}
