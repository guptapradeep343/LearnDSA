package ds.stack;

public class StackTest {
	public static void main(String[] args) {
		StackUsingLL st = new StackUsingLL();
		//StackUsingArray st  = new StackUsingArray(5);
		st.printStack();
		System.out.println(st.peek());
		st.printStack();
		st.pop();
		st.printStack();
		st.push(1);
		st.printStack();
		System.out.println(st.peek());
		st.printStack();
		st.pop();
		st.push(2);
		st.printStack();
		System.out.println(st.peek());
		st.printStack();
		st.pop();
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.printStack();
		System.out.println(st.peek());
		st.printStack();
		System.out.println("popped number="+st.pop());
		System.out.println("popped number="+st.pop());
		st.printStack();
		st.push(5);
		st.push(6);
		st.push(7);
		st.printStack();
		st.push(8);
		st.printStack();
		st.push(9);
		st.printStack();
		st.push(10);
		st.printStack();
	}

	private static void print(int i) {
		System.out.println(" "+i);
		if(i<100){
			print(i+1);
		}
	}

}
