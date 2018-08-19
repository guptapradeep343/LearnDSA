package ds.linkedlidt;

public class DLinkedListTest {
	public static void main(String[] args) {
		DLinkedList ll1 = new DLinkedList();
		ll1.printList();
		ll1.printReverse();
		ll1.delete(7);
		ll1.printList();
		ll1.printReverse();
		ll1.add(5);
		ll1.printList();
		ll1.printReverse();
		ll1.add(6);
		ll1.printList();
		ll1.printReverse();
		ll1.printList();
		ll1.add(5);
		ll1.printReverse();
		ll1.printList();
		ll1.insertAtIndex(0, 15);
		ll1.printList();
		ll1.insertAtIndex(1, 20);
		ll1.printList();
		ll1.insertAtIndex(3, 25);
		ll1.printList();
		ll1.insertAtIndex(5, 30);
		ll1.printList();
		ll1.insertAtIndex(7, 35);
		ll1.printList();
		ll1.insertAtIndex(8, 40);
		ll1.printList();
		ll1.insertAtLast(45);
		ll1.printReverse();
		ll1.printList();
		ll1.delete(20);
		ll1.printList();
		ll1.delete(6);
		ll1.printList();
		ll1.delete(45);
		ll1.printList();
		ll1.printReverse();
		ll1.printList();
	}

	private static void print(int i) {
		System.out.println(" "+i);
		if(i<100){
			print(i+1);
		}
	}

}
