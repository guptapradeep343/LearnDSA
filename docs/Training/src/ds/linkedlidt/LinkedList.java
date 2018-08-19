package ds.linkedlidt;

import ds.stack.StackUsingLL;

public class LinkedList {
	private Node head;
	private Integer size;
	private StackUsingLL stack = new StackUsingLL();

	public void add(int data) {
		if (isEmpty()) {
			head = new Node(data);
			size = 1;
		} else {
			Node lastNode = getLastNode();
			lastNode.setNext(new Node(data));
			size++;
		}
	}

	private Node getLastNode() {
		Node lastNode = head;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		return lastNode;
	}

	private boolean isEmpty() {
		return head == null;
	}

	public void printList() {
		if (head == null) {
			System.out.println("Nothing to print!!!");
		} else {
			Node temp = head;
			System.out.println("The elements in the list are:");
			while (temp != null) {
				System.out.print("\t" + temp.getData());
				temp = temp.getNext();
			}
			System.out.println();
		}
	}

	public void insertAtIndex(int index, int data) {
		if (index==0 || index > size + 1) {
			System.out.println("invalid index");
			return;
		}
		Node n = new Node(data);
		if (index == 1) {
			insertAtTheStart(data, n);
		} else {
			Node node = getNodeAtIndex(index);
			n.setNext(node.getNext());
			node.setNext(n);
		}
		size++;
	}

	private Node getNodeAtIndex(int index) {
		Node temp = head;
		for (int i = 2; i <= index - 1; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	private void insertAtTheStart(int data, Node n) {
		if (isEmpty()) {
			head = n;
			return;
		} else {
			Node temp = head;
			head = n;
			head.setNext(temp);
		}
	}

	public void insertAtLast(int data){
		insertAtIndex(size+1, data);
	}

	public void delete(int data){
		/*if(isHeadEmpty()){
			System.out.println("empty list!!!");
			return;
		}
		Node temp=head;
		if(head.getData()==data){
			head=head.getNext();
			temp.setNext(null);
			size--;
			return;
		}
		Node prev=temp;
		temp=temp.getNext();
		while(temp!=null){
			if(temp.getData()==data){
				prev.setNext(temp.getNext());
				temp.setNext(null);
				size--;
				return;
			}
			prev=temp;
			temp=temp.getNext();
		}
		System.out.println("data not found!!!");*/

		Node prev=null, next=null,temp=head;
		if(isEmpty()) System.out.println("empty list!!!");
		while(temp!=null){
			next=temp.getNext();
			if(temp.getData()==data){
				if(prev==null){
					head=next;
				} else{
					prev.setNext(next);
				}
				temp.setNext(null);
				size--;
				return;
			}
			prev=temp;
			temp=next;
		}
		System.out.println("data not found");
	}

	public void printReverseBT() {
		printReverseBT(head);
	}

	private void printReverseBT(Node node) {
		if(node!=null){
			System.out.println(node.getData());
			printReverseBT(node.getNext());
		}
	}

	public void reverseList() {
		if(size==null || size==1) return;
		Node temp=head, prev=null, next=null;
		while(temp!=null){
			next=temp.getNext();
			if(prev==null){
				temp.setNext(null);
			}else{
				temp.setNext(prev);
			}
			if(next==null){
				head=temp;
			}
			prev=temp;
			temp=next;
		}

	}

	public void reverseListBT(){
		reverseListBT(null, head);
	}

	private void reverseListBT(Node prev, Node curr) {
		/*if(curr!=null){
			Node next=curr.getNext();
			if(prev==null){
				curr.setNext(null);
			}else{
				curr.setNext(prev);
			}
			if(next==null){
				head=curr;
			}
			prev=curr;
			curr=next;
			reverseListBT(prev, curr);
		}*/

		if(curr==null){
			head=prev;
		} else {
			/*Node next=curr.getNext();
			curr.setNext(prev);
			reverseListBT(curr, next);*/
			Node next=curr.getNext();
			reverseListBT(curr, next);
			curr.setNext(prev);
		}
	}

	public Node getMiddleNode() {
		if(isEmpty()){
			return null;
		}
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.getNext()!=null){
			fast=fast.getNext().getNext();
			stack.push(slow.getData());
			slow=slow.getNext();
		}
		if(fast!=null){
			stack.push(slow.getData());
		}
		return slow;

	}

	public Boolean checkPalindrom() {
		stack = new StackUsingLL();
		Node middle=getMiddleNode();
		if(middle==null){
			return false;
		}
		while(middle!=null){
			if(middle.getData()!=stack.pop()){
				return false;
			}
			middle = middle.getNext();
		}
		return true;
	}

}
