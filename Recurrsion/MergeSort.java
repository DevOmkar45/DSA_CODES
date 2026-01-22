package Recurrsion;

public class MergeSort {
	
	public static void mergeSort(int arr[], int sp, int ep) {
		
		//base case
		if(sp == ep) {
			return;
		}
		
		//find mid
		int mid = sp + (ep - sp)/2;
		
		//left part
		mergeSort(arr, sp, mid);
		//right part
		mergeSort(arr, mid+1, ep);
		
		//now this time to merge both left and right part
		merge(arr, sp, mid, ep);
	}
	
	//merge function to merge both part
	public static void merge(int arr[], int sp, int mid, int ep) {
		int temp[] = new int[ep - sp + 1];
		int i = sp;
		int j = mid+1;
		int k = 0;
		
		//compare both left and right part
		while( i<=mid && j<=ep) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i];
				i++;
			} else {
				temp[k++] = arr[j];
				j++;
			}
		}
		
		//if left part ke element bach gye but right part j index ktm then
		while( i<=mid) {
			temp[k++] = arr[i];
			i++;
		}
		
		//if right part ke element bach gye after comparision
		while( j<=ep) {
			temp[k++] = arr[j];
			j++;
		}
		
		//now copying temp to real array
		for(int n=sp, m=0; n<=ep && m<=k; n++, m++) {
			arr[n] = temp[m];
		}
	}
	
	//function to print array
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {5, 9, 3, 1, 7, 6};
		mergeSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
}
