package ds.stack;

import ds.linkedlidt.Node;

public class StackUsingLL {
	private Node top;
	private Integer size;

	public int peek(){
		if(isEmpty()){
			return -1;
		}
		return top.getData();
	}

	public boolean isEmpty(){
		return top==null;
	}

	public void push(int data){
		Node node = new Node(data);
		node.setNext(top);
		top = node;
		if(size==null){
			size=1;
		}
		size++;
	}

	public void printStack(){
		if(isEmpty()){
			System.out.println("nothing to print");
		} else {
			Node temp = top;
			while(temp!=null){
				System.out.print("\t" + temp.getData());
				temp=temp.getNext();
			}
			System.out.println();
		}
	}

	public Integer pop(){
		if(isEmpty()){
			System.out.println("nothing to pop");
			return -1;
		} else{
			int data = top.getData();
			Node next = top;
			top = top.getNext();
			next.setNext(null);
			size--;
			return data;
		}
	}

}
