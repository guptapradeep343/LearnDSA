package ds.queue;

import ds.stack.StackUsingArray;

public class QueueUsingStack {
	StackUsingArray st1= new StackUsingArray(10);
	StackUsingArray st2 = new StackUsingArray(10);

	public boolean isEmpty() {
		return st1.isEmpty() && st2.isEmpty();
	}

	public void enQueue(int data) {
		st1.push(data);
	}

	public void printQueue() {
		if(isEmpty()){
			System.out.println("nothing to print");
		}
		if(!st2.isEmpty()){
			st2.printStack();

		}
		if(!st1.isEmpty()){
			st1.printReverse();
		}
		System.out.println();
	}

	public Integer deQueue() {
		if(isEmpty()){
			System.out.println("queue is empty");
			return -1;
		}
		if(st2.isEmpty()){
			while(!st1.isEmpty()){
				st2.push(st1.pop());
			}
		}
		return st2.pop();
	}

}
