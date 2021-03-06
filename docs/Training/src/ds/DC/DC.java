package ds.DC;

public class DC {

	public static void main(String[] args) {
		int mult = multiply(2, 13);
		System.out.println(mult);
	}

	private static int multiply(int number, int times) {
		if(times==1) return number;

		int rem = times%2;
		times= times>>1;
		int result = multiply(number, times);
		if(rem==0){
			return result*result;
		}else{
			return number * result * result;
		}
	}

}
