package ds.queue;

import ds.linkedlidt.Node;

public class QueueUsingLL<T> {
	private Node<T> front, rear;
	private Integer size;

	public void enQueue(T data){
		Node<T> node  = new Node<T>(data);
		if(isEmpty()){
			front = node;
			rear = node;
			size = 1;
		} else {
			rear.setNext(node);
			rear=node;
			size++;
		}
	}

	public boolean isEmpty(){
		return front==rear && front==null && (size==null || size==0);
	}

	public T deQueue(){
		if(isEmpty()){
			System.out.println("Queue is empty!!!");
			return null;
		}else{
			Node<T> temp = front;
			size--;
			if(front==rear){
				rear=null;
				front= null;
				return temp.getData();
			}
			front = front.getNext();
			temp.setNext(null);
			return temp.getData();

		}
	}

	public void printQueue(){
		if(isEmpty()){
			System.out.println("nothing to print");
		} else {
			Node<T> temp = front;
			while(temp!=null){
				System.out.print("\t" + temp.getData());
				temp=temp.getNext();
			}
			System.out.println();
		}
	}

}
