package ds.stack;

import ds.queue.QueueUsingArray;

public class StackUsingQueue {
	private QueueUsingArray q;
	private int top=-1;
	private Integer size;
	public StackUsingQueue(int length) {
		q = new QueueUsingArray(length);
	}

	public int peek(){
		if(isEmpty()){
			return -1;
		}
		return array[top];
	}

	public boolean isEmpty(){
		return top==-1;
	}

	public void push(int data){
		if(isStackFull()){
			System.out.println("stack full");
			return;
		}
		top++;
		array[top]= data;
	}

	public boolean isStackFull() {
		return top== array.length-1;
	}

	public void printStack(){
		if(isEmpty()){
			System.out.println("nothing to print");
		} else {
			int index = top;
			while(index>-1){
				System.out.print("\t" + array[index]);
				index = index-1;
			}
			System.out.println();
		}
	}

	public void printReverse() {
		for(int index=0; index<=top; index++){
			System.out.print("\t" + array[index]);
		}
	}

	public Integer pop(){
		if(isEmpty()){
			System.out.println("nothing to pop");
			return -1;
		} else{
			int data = array[top];
			top--;
			return data;
		}
	}

}
