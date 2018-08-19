package ds.sort;

public class Insertion {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		insertionSort(a);
	}

	private static int[] insertionSort(int[] a) {
		for(int i=1; i<a.length; i++){
			int hole= a[i];
			int maxSortedIndex=i-1;
			while(maxSortedIndex>=0 && hole<a[maxSortedIndex]){
					a[maxSortedIndex+1]=a[maxSortedIndex];
					maxSortedIndex--;
			}
			a[maxSortedIndex+1] = hole;
		}
		printArray(a);
		return a;
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
	}

}
