package ds.dynamicprogramming;

public class MaxContSum {
	int[] metadata;
	int maxSum;
	int index;

	public static void main(String[] args) {
		int[] a = { 5, -3, -1, -6, 11, -4, 13, -5, 2 };
		MaxContSum mcs = new MaxContSum(a);
		mcs.getMaxSum(a);
	}

	public MaxContSum(int[] a) {
		metadata = new int[a.length];
		maxSum = 0;
	}

	int getMaxSum(int[] a) {
		 //populateMetadataRec(a, a.length - 1);
		//populateMetadataRec2(a, 0);
		populateMetadata(a);
		System.out.println(maxSum);
		printIndeces(a);
		return maxSum;
	}

	private void printIndeces(int[] a) {
		int sum=maxSum;
		int startingIndex=index;
		System.out.println("values are : ");
		do{
			System.out.print(a[startingIndex] + "\t");
			sum=sum-a[startingIndex];
			startingIndex = startingIndex-1;//startingIndex-1 when preparing matadata from backside
		}while(sum>0);

	}

	private void populateMetadataRec(int[] a, int n) {
		if (n >= 0) {
			if (n == a.length - 1 && a[n] > 0) {
				metadata[n] = a[n];
				populateMetadataRec(a, n - 1);
				return;
			} else if (n == a.length - 1) {
				metadata[n] = 0;
				populateMetadataRec(a, n - 1);
				return;
			}
			if (metadata[n + 1] + a[n] > 0) {
				metadata[n] = metadata[n + 1] + a[n];
			} else {
				metadata[n] = 0;
			}
			if (maxSum < metadata[n]){
				maxSum = metadata[n];
				index=n;
			}
			populateMetadataRec(a, n - 1);
		}

	}

	private void populateMetadataRec2(int[] a, int n) {
		if (n < a.length) {
			if (n == 0 && a[n] > 0) {
				metadata[n] = a[n];
				populateMetadataRec2(a, n + 1);
				return;
			} else if (n == a.length - 1) {
				metadata[n] = 0;
				populateMetadataRec2(a, n + 1);
				return;
			}
			if (metadata[n - 1] + a[n] > 0) {
				metadata[n] = metadata[n - 1] + a[n];
			} else {
				metadata[n] = 0;
			}
			if (maxSum < metadata[n]){
				maxSum = metadata[n];
				index=n;
			}
			populateMetadataRec2(a, n + 1);
		}

	}

	private void populateMetadata(int[] a) {
		if (a[0] > 0) {
			metadata[0] = a[0];
		} else {
			metadata[0] = 0;
		}
		for (int i = 1; i < a.length; i++) {
			if (metadata[i - 1] + a[i] > 0) {
				metadata[i] = metadata[i - 1] + a[i];
			} else {
				metadata[i] = 0;
			}
			if (maxSum < metadata[i]){
				maxSum = metadata[i];
				index=i;
			}
		}

	}
}
