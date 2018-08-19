package ds.BitManipulation;

public class AdditionSubstraction {

	public static void main(String[] args) {
		System.out.println(additionRec(-23, -111));
		System.out.println(substrct(-23, -111));
	}
	private static int substrct(int a, int b){
		return addition(a, ~b);
	}

	private static int addition(int a, int b) {
		while (b != 0) {
			int c = a ^ b;// XOR different bit results 1
			int d = (a & b) << 1;
			a = c;
			b = d;
		}
		return a;
	}

	private static int additionRec(int a, int b) {
		if (b == 0)
			return a;

		int c = a ^ b;// XOR different bit results 1
		int d = (a & b) << 1;
		a = c;
		b = d;
		return additionRec(a, b);
	}

}
