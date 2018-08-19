package ds.linkedlidt;

public class DLinkedList {
	private DNode head;
	private Integer size;

	public void add(int data) {
		DNode n= new DNode(data);
		if (isHeadEmpty()) {
			head = n;
			size = 1;
		} else {
			DNode lastNode = getLastNode();
			lastNode.setNext(n);
			n.setPrev(lastNode);
			size++;
		}
	}

	private DNode getLastNode() {
		if(isHeadEmpty()){
			return null;
		}
		DNode lastNode = head;
		while (lastNode.getNext()!= null) {
			lastNode = lastNode.getNext();
		}
		return lastNode;
	}

	private boolean isHeadEmpty() {
		return head == null;
	}

	public void printList() {
		if (head == null) {
			System.out.println("Nothing to print!!!");
		} else {
			DNode temp = head;
			System.out.println("The elements in the list are:");
			while (temp != null) {
				System.out.print("\t" + temp.getData());
				temp = temp.getNext();
			}
		}
		System.out.println();
	}

	public void insertAtIndex(int index, int data) {
		if (index==0 || index > size + 1) {
			System.out.println("invalid index");
			return;
		}
		DNode n = new DNode(data);
		if (index == 1) {
			insertAtTheStart(data, n);
		} else {
			DNode node = getNodeAtIndex(index);
			n.setNext(node.getNext());
			if(node.getNext()!=null){
				node.getNext().setPrev(n);
			}
			node.setNext(n);
			n.setPrev(node);
		}
		size++;
	}

	private DNode getNodeAtIndex(int index) {
		DNode temp = head;
		for (int i = 2; i <= index - 1; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	private void insertAtTheStart(int data, DNode n) {
		if (isHeadEmpty()) {
			head = n;
			return;
		} else {
			DNode temp = head;
			head = n;
			head.setNext(temp);
			temp.setPrev(head);
		}
	}

	public void insertAtLast(int data){
		insertAtIndex(size+1, data);
	}

	public void delete(int data){
		DNode node = getNode(data);
		if(node==null){
			System.out.println("data not found");
			return;
		}
		DNode prev = node.getPrev();
		DNode next = node.getNext();
		if(prev!=null){
			prev.setNext(next);
		}else{
			head=next;
		}
		if(next!=null){
			next.setPrev(prev);
		}
		node.setNext(null);
		node.setPrev(null);
	}

	private DNode getNode(int data) {
		DNode temp = head;
		while(temp!=null){
			if(temp.getData()==data){
				return temp;
			}
			temp=temp.getNext();
		}
		return null;
	}

	public void printReverse() {
		System.out.println("reverse print");
		DNode node = getLastNode();
		while(node!=null){
			System.out.print("\t" + node.getData());
			node = node.getPrev();
		}
		System.out.println();
	}

}
