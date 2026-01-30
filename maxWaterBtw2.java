package ArrayList;
import java.util.ArrayList;

public class maxWaterBtw2 {
	
	//function to find max water between two building 
	public static int maxWaterTrap(ArrayList<Integer> list) {
		int lp = 0;
		int rp = list.size()-1;
		
		int maxWater = Integer.MIN_VALUE;
		
		while(lp < rp) {
			int height = Math.min(list.get(lp), list.get(rp));
			int width = rp - lp;
			int currWater = height*width;
			
			maxWater = Math.max(maxWater, currWater);
			
			if(list.get(lp) < list.get(rp)) {
				lp++;
			} else {
				rp--;
			}
		}
		
		return maxWater;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(8);
		list.add(6);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(8);
		list.add(3);
		list.add(7);
		
		System.out.println(maxWaterTrap(list));
	}

}
