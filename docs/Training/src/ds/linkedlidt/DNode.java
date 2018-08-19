package ds.linkedlidt;

public class DNode {
	private DNode prev;
	private DNode next;
	private int data;

	public DNode(int data) {
		this.data = data;
	}
	public DNode getPrev() {
		return prev;
	}
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
