package ds.queue;

public class QueueUsingArray {
	private int[] array;
	private int front = -1;
	private int rear = -1;

	public QueueUsingArray(int length) {
		array = new int[length];
		// TODO Auto-generated constructor stub
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	public void enQueue(int data) {
		if (isQueueFull()) {
			System.out.println("queue full");
			return;
		}
		if (isEmpty()) {
			front = 1;
			rear = 1;
		} else {
			rear = (rear + 1) % array.length;
		}
		array[rear] = data;
	}

	private boolean isQueueFull() {
		if (rear>front){
			return rear - front ==array.length-1;
		}else{
			return front-rear==1;
		}
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("nothing to print");
		} else {
			int index = front;
			while (index < array.length) {
				System.out.print("\t" + array[index]);
				index = index + 1;
				if (index == rear+1) {
					break;
				} else if (index == array.length && index > rear) {
					index = 0;
				}
			}
			System.out.println();
		}
	}

	public Integer deQueue() {
		if (isEmpty()) {
			System.out.println("nothing to deQueue");
			return -1;
		} else {
			int data = array[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % array.length;
			}
			return data;
		}
	}

}
