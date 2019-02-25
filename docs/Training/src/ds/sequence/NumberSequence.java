package ds.sequence;

public class NumberSequence {

	/*
	 * 2,3
	 *
	 * 1  1
2  1
3  1
1  2
2  2
3  2
1  3
2  3
3  3


3, 2

1  1  1
2  1  1
1  2  1
2  2  1
1  1  2
2  1  2
1  2  2
2  2  2


	*/
	public static void main(String[] args) {
		//printBinarySequence(5);
		printNumberSequence(3,2);

	}

	private static void printNumberSequence(int j, int k) {
		int[] a=new int[j];
		for(int i=0;i<a.length;i++){
			a[i]=1;
		}
		printNumberSequence(j,k, a);

	}
//k^legth
	private static void printNumberSequence(int length, int k, int[] a) {
		if(length == 0) {
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+"  ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=k;i++){
			a[length-1]=i;
			printNumberSequence(length-1, k, a);
		}
	}

	private static void printBinarySequence(int i) {
		printBinarySequence(i, new int[i]);

	}
//2^length
	private static void printBinarySequence(int length, int[] a) {
		if(length == 0) {
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+"  ");
			}
			System.out.println();
			return;
		}
		a[length-1]=0;
		printBinarySequence(length-1, a);
		a[length-1]=1;
		printBinarySequence(length-1, a);
	}

}
