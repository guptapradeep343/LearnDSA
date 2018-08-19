package ds.dynamicprogramming;


public class LongestPalindromeSequence {
	int [][]lsp;

	public LongestPalindromeSequence(String string) {
		lsp = new int [string.length()][string.length()];
		populateLSP(string);
		printPalindromSequence(string);
	}

	private void printPalindromSequence(String string) {
		int from=0;
		int to = lsp.length-1;
		StringBuffer sb = new StringBuffer();
		while(from<to){
			if(string.charAt(to)==string.charAt(from)){
				sb.append(string.charAt(from));
				from=from+1; to=to-1;
			} else {
				if (lsp[from + 1][to] > lsp[from][to - 1]) {
					from = from + 1;
				} else {
					to = to - 1;
				}
			}
		}
		
		StringBuffer reverse =  new StringBuffer(sb);
		reverse.reverse();
		if(from==to){
			sb.append(string.charAt(from));
		}
		System.out.println(sb.append(reverse).toString());
	}

	private void populateLSP(String string) {
		for(int dia=1; dia<=string.length(); dia++){
			for(int from=0; from<=string.length()-dia;from++){
				int to  = from+dia-1;
				if(from==to){
					lsp[from][to] = 1;
				}else if(to==from+1){
					if(string.charAt(to)==string.charAt(from)){
						lsp[from][to] = 2;
					}else{
						lsp[from][to] = 1;
					}
				}else{
					if(string.charAt(to)==string.charAt(from)){
						lsp[from][to] = lsp[from+1][to-1]+2;
					}else{
						lsp[from][to] = Math.max(lsp[from][to-1], lsp[from+1][to]);
					}
				}
			}
		}
		
		/*for(int dia=0; dia<string.length(); dia++){
			for(int from=0; from<string.length();from++){
				int to  = from+dia+1;
				if(to>=string.length()){
					break;
				}
				System.out.println(from +" and "+ to);
			}
		}*/
	}

	public static void main(String[] args) {
		String string = "awebrtcvgcuibfgahj";
		LongestPalindromeSequence sequence = new LongestPalindromeSequence(string);
	}

}
