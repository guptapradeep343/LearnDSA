package ds.sort;

public class Bubble {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 7, 6, 9, 8, 0 };
		bubbleSort(a);
	}





	private static int[] bubbleSort(int[] a) {
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
