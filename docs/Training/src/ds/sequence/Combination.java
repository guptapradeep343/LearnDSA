package ds.sequence;

public class Combination {
	/*
	 *
	 *
a
ab
abc
ac
b
bc
c


	*/

	public static void main(String[] args) {
		printCombination("","abc");


	}

	private static void printCombination(String prefix, String string) {
			System.out.println(prefix);

		for(int i=0; i<string.length();i++){
			//prefix = prefix+string.charAt(i);
			//printPermutations(prefix, string.substring(0, i)+string.substring(i+1, string.length()));
			printCombination(prefix + string.charAt(i), string.substring(i+1, string.length()));
		}

	}

}
