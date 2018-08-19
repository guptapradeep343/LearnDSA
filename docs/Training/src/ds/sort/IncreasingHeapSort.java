package ds.sort;

public class IncreasingHeapSort {

	public static void main(String[] args) {
		int[] a = {0, 11, 2, 5, 4, 7, 6, 9, 8, 0 };
		heapSort(a);
	}

	private static int[] heapSort(int[] a) {
		int length = a.length-1;
		//construct min heap
		for(int k=length/2; k>0;k--){
			sink(k, length, a);
		}
		//apply the sorting in increasing order
		while(length>1){
			swap(1, length, a);
			length--;
			sink(1, length, a);
		}
		printArray(a);
		return a;
	}

	private static void sink(int index, int length, int []a) {
		while(2*index<=length){
			int j= 2*index;
			if(j < length && a[j] < a[j+1]){//responsible for sorting order
				j++;
			}
			if((a[index]> a[j])) break;//responsible for sorting order
			swap(index, j, a);
			index = j;
		}
	}


	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
	}

	private static int[] swap(int i, int j, int[] a) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
		return a;
	}

}
