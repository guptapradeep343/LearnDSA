package ds.sort;

public class Merge {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		mergeSort(a);
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

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
	}
}
