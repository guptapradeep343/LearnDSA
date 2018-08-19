package ds.dynamicprogramming;

public class MaxAppleCount {
	int[][] metadata;
	int maxSum;
	int index;

	public static void main(String[] args) {
		int[][] a = { { 1, 0, 2, 4 }, { 3, 7, 1, 6 }, { 5, 8, 11, 6 }, { 4, 12, 2, 1 } };
		MaxAppleCount maxAppleCount = new MaxAppleCount(a);
		maxAppleCount.getMaxAppleCount(a);
	}

	public MaxAppleCount(int[][] a) {
		metadata = new int[a.length][a[0].length];
		maxSum = 0;
	}

	int getMaxAppleCount(int[][] a) {
		populateMetadata(a);
		System.out.println(metadata[a.length - 1][a[0].length - 1]);
		printPath(metadata.length - 1, metadata[0].length - 1);
		return maxSum;
	}

	private void printPathRec(int i, int j) {
		if (i == 0 && j == 0) {
			return;
		} else if (i == 0) {
			printPathRec(i, j - 1);
			System.out.println(i + ", " + (j - 1));
			return;
		} else if (j == 0) {
			printPathRec(i - 1, j);
			System.out.println((i - 1) + ", " + j);
			return;
		} else if (metadata[i][j - 1] > metadata[i - 1][j]) {
			printPathRec(i, j - 1);
			System.out.println(i + ", " + (j - 1));
			return;
		} else {
			printPathRec(i - 1, j);
			System.out.println((i - 1) + ", " + j);
			return;
		}
	}

	private void printPath(int m, int n) {
		int i = 0;
		int j = 0;
		while (i <= m && j <= n) {
			System.out.println(i + ", " + j);

			if (metadata[i + 1][j] > metadata[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}
	}

	private void populateMetadata(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i == 0 && j == 0) {
					metadata[i][j] = a[i][j];
				} else if (i == 0) {
					metadata[i][j] = a[i][j] + metadata[i][j - 1];
				} else if (j == 0) {
					metadata[i][j] = a[i][j] + metadata[i - 1][j];
				} else {
					metadata[i][j] = a[i][j] + Math.max(metadata[i - 1][j], metadata[i][j - 1]);
				}
			}
		}

	}

}
