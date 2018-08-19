package ds.binaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		BinaryTree bt1 = new BinaryTree();
		BinaryTree bt2 = bt.createCopy();
		bt.preOrder();
		bt2.preOrder();
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.diameter();
		bt.printRootToLeaf();
		bt.prntSumPathForANumber(6);
		bt2 = bt.createCopy();
		//bt2.insert(10);
		bt.preOrder();
		bt2.preOrder();
		bt2.mirror();
		bt2.preOrder();
		bt2.insert(10);
		bt2.isSame(bt2);
		bt.isMirror(bt2);
		bt1.insert(1);
		bt1.insert(2);
		bt1.insert(3);
		bt1.insert(4);
		bt1.insert(5);
		bt.printAncestors(1);

		bt.findLevel(2);
		bt.isSame(bt1);
		bt.insert(10);
		bt.areSiblings(10,5);
		bt.areCousins(10,4);
		bt.levelOrderPrint();
		bt.preOrder();
		bt.inOrder();
		bt.postOrder();
		bt.printLeft();
		bt.printLeaf();
		bt.printRight();
		System.out.println();
		bt.printBoundry();
		System.out.println();
		// bt.deleteTree();
		bt.preOrder();
		bt.findMax();
		bt.height();
		bt.noOfNodes();
		bt.findNode(5);
		bt1.insert(10);
		bt = new BinaryTree();
		bt.findMax();
		bt.height();
		bt.noOfNodes();
		bt.findNode(5);


	}
}
