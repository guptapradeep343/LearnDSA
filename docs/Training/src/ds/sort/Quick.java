package ds.sort;

public class Quick {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		quickSort(a);
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
