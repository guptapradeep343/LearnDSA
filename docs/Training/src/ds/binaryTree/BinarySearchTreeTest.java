package ds.binaryTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.preOrder();
		bst.findMaxIterative();
		bst.insertRecursive(50);
		bst.findMaxIterative();
		bst.preOrder();
		bst.insertRecursive(25);
		bst.preOrder();
		bst.insertRecursive(75);
		bst.insertIterative(15);
		bst.insertRecursive(30);
		bst.insertRecursive(60);
		bst.insertRecursive(90);
		bst.insertRecursive(20);
		bst.insertRecursive(26);
		bst.insertRecursive(35);
		bst.insertRecursive(55);
		bst.insertRecursive(100);
		bst.insertRecursive(45);
		bst.preOrder();
		bst.findNode(3);
		bst.findMaxIterative();
		bst.findMaxRecursive();
		bst.delete(75);
		bst.preOrder();

	}
}
