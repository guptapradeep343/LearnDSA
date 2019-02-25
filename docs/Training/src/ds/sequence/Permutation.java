package ds.sequence;

public class Permutation {

	/*
	 *
abc
acb
bac
bca
cab
cba
	*/
	public static void main(String[] args) {
		printPermutations("","abc");

	}

	private static void printPermutations(String prefix, String string) {
		if(string.length()==0){
			System.out.println(prefix);
			return;
		}
		for(int i=0; i<string.length();i++){
			//prefix = prefix+string.charAt(i);
			//printPermutations(prefix, string.substring(0, i)+string.substring(i+1, string.length()));
			printPermutations(prefix+string.charAt(i), string.replace(string.charAt(i)+"", ""));
		}

	}

}
