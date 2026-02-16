package Recurrsion;

public class QuickSort {
	
	//function for quick sort
	public static void quickSort(int arr[], int si, int ei) {
		//base condition
		if(si >= ei) {
			return;
		}
		
		int pvtIdx = partition(arr, si, ei);
		
		//base on pivot postion divide array
		quickSort(arr, si, pvtIdx-1);
		quickSort(arr, pvtIdx+1, ei);
	}
	
	//function for partition which divide smaller part in left and larger part in right and give pivot postion
	public static int partition(int arr[], int si, int ei) {
		int pivot = arr[ei];
		int i = si-1;
		
		for(int j=si; j<ei; j++) {
			if(arr[j] < pivot) {
				i++;
				//replace j and ith term
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		//now its time for pivot to take right position so all smaller number come in ith position next term of pivot to come in ith palce
		i++;
		arr[ei] = arr[i];
		arr[i] = pivot;
		return i;			//returning pivot idx
		
	}
	
	//function to print array
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 9, 2, 7, 4, 3, 8};
		quickSort(arr, 0, arr.length-1);
		printArr(arr);
	}
}
