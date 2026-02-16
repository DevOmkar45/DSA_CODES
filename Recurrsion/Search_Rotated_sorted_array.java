package Recurrsion;

public class Search_Rotated_sorted_array {

	//function to search in rotated sorted array
	public static int search(int arr[], int si, int ei, int target) {
		//base case
		if(si > ei) {
			return -1;
		}
		
		//kaam
		int mid = (si+ei)/2;
		
		//if found in middle return it 
		if(arr[mid] == target) {
			return mid;
		}
		
		//line 1
		if(arr[si] <= arr[mid]) {
			if(arr[si] <= target && target <= arr[mid]) {
				return search(arr, si, mid-1, target);
			} else {
				return search(arr, mid+1, ei, target);
			}
		} else {   //mean line 2
			if(arr[mid] <= target && target <= arr[ei]) {
				return search(arr, mid+1, ei, target);
			} else {
				return search(arr, si, mid-1, target);
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {7, 8, 9, 0, 2, 4, 5};
		System.out.println(search(arr, 0, arr.length-1, 0));
	}
}
