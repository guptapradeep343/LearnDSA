package ds.sort;

public class Sorting {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		insertionSort(a);
		//mergeSort(a);
		// quickSort(a);
		// selectionSort(a);
		// binarySort(a);
	}

	private static int[] mergeSort(int[] a) {
		a = mergeSort(a, 0, a.length - 1);
		printArray(a);
		return a;
	}

	private static int[] mergeSort(int[] a, int low, int high) {
		if (low >= high)
			return a;
		//if (high - low == 1)
		//	return a;
		int mid = (low + high) >> 1;
		mergeSort(a, low, mid);
		mergeSort(a, mid + 1, high);
		merge(a, low, mid, high);
		return a;
	}

	private static void merge(int[] a, int low, int mid, int high) {
		int i = low, j = mid + 1;
		int k = 0;
		int temp[] = new int[high - low + 1];
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k] = a[i];
				i++;
			} else {
				temp[k] = a[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			temp[k] = a[i];
			i++;
			k++;
		}
		while (j <= high) {
			temp[k] = a[j];
			j++;
			k++;
		}
		k = 0;
		for (i = low; i <= high; i++) {
			a[i] = temp[k];
			k++;
		}
	}

	private static int[] quickSort(int[] a) {
		a = quickSort(a, 0, a.length - 1);
		printArray(a);
		return a;
	}

	private static int[] quickSort(int[] a, int low, int high) {
		if (low <= high) {
			int partition = partition(a, low, high);
			a = quickSort(a, low, partition - 1);
			a = quickSort(a, partition + 1, high);
		}
		return a;
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		int temp = low;
		while (high > low) {
			while (low <= high && pivot >= a[low]) {
				low++;
			}
			while (pivot < a[high]) {
				high--;
			}
			if (high > low) {
				swap(high, low, a);
			}
		}
		if (temp != high)
			swap(temp, high, a);
		return high;
	}

	private static int[] insertionSort(int[] a) {
		int key= a[0];
		for(int i=1; i<a.length; i++){
			if(key>a[i]){
				int temp = a[i];
				for(int j=i; j>=1; j--){
					if(temp<a[j-1]){
						a[j]=a[j-1];
					}else{
						a[j]=temp;
						break;
					}
				}
			}
			key=a[i];
		}
		printArray(a);
		return a;
	}

	private static int[] binarySort(int[] a) {
		int length = a.length;
		boolean swap = true;
		for (int i = 0; i < length && swap; i++) {
			swap = false;
			for (int j = 0; j < length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					a = swap(j, j + 1, a);
					swap = true;
				}
			}
		}
		printArray(a);
		return a;
	}

	private static int[] selectionSort(int[] a) {
		int length = a.length;
		for (int pos = 0; pos < length - 1; pos++) {
			int min = pos;
			for (int j = pos + 1; j < length; j++) {
				if (a[j] < a[min]) {
					min = j;
					a = swap(min, pos, a);
				}
			}
		}
		printArray(a);
		return a;
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
