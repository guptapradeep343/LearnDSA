package ds.dynamicprogramming;

public class OptimalRopeCut {
	int[] metadata;
	int[] backtrack;
	int maxSum;
	int index;

	public static void main(String[] args) {
		int[] a = {0,1,5,8,9,10,17,17,20};
		OptimalRopeCut optCut = new OptimalRopeCut(a);
		optCut.populateMetadata(a);
		System.out.println(optCut.metadata);
		optCut.printCut(7);
	}

	private void printCut(int length) {
		while(length!=0){
			int cutPosition = backtrack[length];
			length = length-cutPosition;
			System.out.println("cutLength: "+ cutPosition + "cut price: "+metadata[cutPosition]);
		}
	}

	private void populateMetadata(int[] a) {
		metadata[0] = 0;
		for(int i=1; i<a.length;i++){
			for(int j=0;j<=i;j++){
				if((a[j] + metadata[i-j])>metadata[i]){
					metadata[i]=a[j] + metadata[i-j];
					backtrack[i]=j;
				}
			}
		}
	}

	public OptimalRopeCut(int[] a) {
		metadata = new int[a.length];
		backtrack = new int[a.length];
	}

}
