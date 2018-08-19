package ds.linkedlidt;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.reverseListBT();
		ll1.printList();
		Node n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		System.out.println(ll1.checkPalindrom());
		ll1.delete(7);
		ll1.reverseListBT();
		ll1.printList();
		ll1.add(5);
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		System.out.println(ll1.checkPalindrom());
		ll1.reverseListBT();
		ll1.printList();
		ll1.add(6);
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		System.out.println(ll1.checkPalindrom());
		ll1.printList();
		ll1.reverseListBT();
		ll1.printList();
		ll1.add(5);
		ll1.add(6);
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		System.out.println(ll1.checkPalindrom());
		ll1.printList();
		ll1.insertAtIndex(0, 15);
		ll1.printList();
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		System.out.println(ll1.checkPalindrom());
		ll1.insertAtIndex(1, 20);
		ll1.printList();
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		ll1.insertAtIndex(3, 25);
		ll1.printList();
		ll1.insertAtIndex(5, 30);
		ll1.printList();
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		ll1.insertAtIndex(7, 35);
		ll1.printList();
		n = ll1.getMiddleNode();
		if(n==null){
			System.out.println("list empty");
		}else{
			System.out.println("middle node is = "+n.getData());
		}
		ll1.insertAtIndex(8, 40);
		ll1.printList();
		ll1.insertAtLast(45);
		ll1.reverseListBT();
		ll1.printList();
		ll1.delete(20);
		ll1.printList();
		ll1.delete(6);
		ll1.printList();
		ll1.delete(45);
		ll1.printList();
		//ll1.printReverseBT();
		ll1.reverseListBT();
		ll1.printList();
	}

	private static void print(int i) {
		System.out.println(" "+i);
		if(i<100){
			print(i+1);
		}
	}

}
