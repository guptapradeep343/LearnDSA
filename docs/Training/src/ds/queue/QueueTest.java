package ds.queue;

import ds.stack.StackUsingArray;

public class QueueTest {
	public static void main(String[] args) {
		QueueUsingLL<Integer> q = new QueueUsingLL<Integer>();
		//QueueUsingArray q = new QueueUsingArray(5);
		q.printQueue();
		//reverseQueue(q);
		q.deQueue();
		//reverseQueue(q);
		q.enQueue(1);
		//reverseQueue(q);
		q.printQueue();
		q.deQueue();
		q.enQueue(2);
		q.printQueue();
		q.enQueue(3);
		q.printQueue();
		q.enQueue(4);
		q.printQueue();
		//reverseQueue(q);
		q.enQueue(5);
		q.printQueue();
		q.enQueue(6);
		q.printQueue();
		q.deQueue();
		q.deQueue();
		q.enQueue(7);
		q.printQueue();
		q.enQueue(8);
		q.printQueue();
		//reverseQueue(q);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();

		QueueUsingStack qST = new QueueUsingStack();
		qST.printQueue();
		qST.deQueue();
		qST.printQueue();
		qST.enQueue(10);
		qST.printQueue();
		qST.deQueue();
		qST.printQueue();
		qST.enQueue(20);
		qST.enQueue(30);
		qST.printQueue();
		qST.enQueue(40);
		qST.enQueue(50);
		qST.enQueue(60);
		qST.enQueue(70);
		qST.enQueue(80);
		qST.enQueue(90);
		qST.printQueue();
		qST.enQueue(100);
		qST.enQueue(110);
		qST.enQueue(120);
		qST.enQueue(130);
		qST.printQueue();
		qST.deQueue();
		qST.printQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.deQueue();
		qST.printQueue();
		qST.enQueue(120);
		qST.enQueue(130);
		qST.printQueue();

	}

	private static void reverseQueue(QueueUsingArray q) {
		if(q.isEmpty()){
			System.out.println("Q is empty");
			return;
		}
		StackUsingArray st = new StackUsingArray(5);
		reverseQueue(q,st);
		q.printQueue();
	}

	private static void reverseQueue(QueueUsingArray q, StackUsingArray st) {
		if(!q.isEmpty()){
			st.push(q.deQueue());
			reverseQueue(q,st);
			q.enQueue(st.pop());
		}
	}
}
