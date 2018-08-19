package ds.sort;

public class Selection {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		selectionSort(a);
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
