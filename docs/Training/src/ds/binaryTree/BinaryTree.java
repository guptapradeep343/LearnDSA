package ds.binaryTree;

import ds.queue.QueueUsingLL;

public class BinaryTree {
	protected Node root;
	private Integer size;

	public BinaryTree() {
		this.size = 0;
	}

	public BinaryTree(Node node) {
		this.root = node;
	}

	public void insert(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}
		QueueUsingLL<Node> q = new QueueUsingLL<Node>();
		q.enQueue(root);
		while (!q.isEmpty()) {
			Node n = q.deQueue();
			if (n.getLeft() == null) {
				n.setLeft(node);
				return;
			} else if (n.getRight() == null) {
				n.setRight(node);
				return;
			} else {
				q.enQueue(n.getLeft());
				q.enQueue(n.getRight());
			}

		}
	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}

	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getData() + "\t");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + "\t");
			inOrder(root.getRight());
		}
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + "\t");
		}
	}

	public void printLeft() {
		printLeft(this.root);
	}

	public void printRight() {
		printRight(this.root);
	}

	public void printLeaf() {
		printLeaf(this.root);
	}

	private void printLeft(Node node) {
		if (!isEmpty(node) && !isLeaf(node)) {
			System.out.print(node.getData() + "\t");
			if (node.getLeft() != null) {
				printLeft(node.getLeft());
			} else {
				printLeft(node.getRight());
			}
		}
	}

	private void printRight(Node node) {
		if (!isEmpty(node) && !isLeaf(node)) {
			if (node.getRight() != null) {
				printRight(node.getRight());
			} else {
				printRight(node.getLeft());
			}
			System.out.print(node.getData() + "\t");
		}
	}

	private void printLeaf(Node node) {
		if (!isEmpty(node)) {
			if (isLeaf(node)) {
				System.out.print(node.getData() + "\t");
				return;
			}
			printLeaf(node.getLeft());
			printLeaf(node.getRight());
		}
	}

	public void levelOrderPrint() {
		if (isEmpty(this.root)) {
			return;
		}
		QueueUsingLL<Node> q = new QueueUsingLL<Node>();
		q.enQueue(root);
		while (!q.isEmpty()) {
			Node n = q.deQueue();
			System.out.print(n.getData() + "\t");
			if (n.getLeft() != null) {
				q.enQueue(n.getLeft());
			}
			if (n.getRight() != null) {
				q.enQueue(n.getRight());
			}
		}
		System.out.println();
	}

	protected boolean isEmpty(Node node) {
		return node == null;
	}

	protected boolean isLeaf(Node node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public void printBoundry() {
		printLeft();
		printLeaf();
		printRight();
	}

	public void deleteTree() {
		deleteTree(this.root);
		this.root = null;
	}

	private void deleteTree(Node node) {
		if (!isEmpty(node)) {
			if (node.getLeft() != null) {
				deleteTree(node.getLeft());
				node.setLeft(null);
			}
			if (node.getRight() != null) {
				deleteTree(node.getRight());
				node.setRight(null);
			}
		}
	}

	public void findMax() {
		System.out.println(findMax(this.root));
	}

	private int findMax(Node node) {
		if (isEmpty(node)) {
			return -1;
		}
		int data = node.getData();
		int left = findMax(node.getLeft());
		int right = findMax(node.getRight());
		return maxOf(data, left, right);
	}

	private int maxOf(int data, int left, int right) {
		if (data < left) {
			data = left;
		}
		return data > right ? data : right;
	}

	public void height() {
		System.out.println(findHeight(root));
	}

	private int findHeight(Node node) {
		if (isEmpty(node) || isLeaf(node)) {
			return 0;
		}
		int left = findHeight(node.getLeft());
		int right = findHeight(node.getRight());
		int height = left > right ? left : right;
		return height + 1;
	}

	private int noOfNodes(Node node) {
		if (isEmpty(node)) {
			return 0;
		}
		return 1 + noOfNodes(node.getLeft()) + noOfNodes(node.getRight());
	}

	public void noOfNodes() {
		System.out.println(noOfNodes(root));
	}

	public void findNode(int data) {
		System.out.println("is node found " + (findNode(root, data) != null));
	}

	private Node findNode(Node node, int data) {
		if (isEmpty(node)) {
			return null;
		}
		if (node.getData() == data) {
			return node;
		}
		Node left = findNode(node.getLeft(), data);
		if (left != null) {
			return left;
		} else {
			return findNode(node.getRight(), data);
		}
	}

	public void isSame(BinaryTree bt1) {
		System.out.println("trees are same: " + isSame(this.root, bt1.root));
	}

	private boolean isSame(Node node1, Node node2) {
		if (!isEmpty(node1) && !isEmpty(node2)) {
			if (node1.getData() != node2.getData()) {
				return false;
			}
			boolean left = isSame(node1.getLeft(), node2.getLeft());
			if (!left) {
				return false;
			}
			return isSame(node1.getRight(), node2.getRight());
		} else if (isEmpty(node1) && isEmpty(node2)) {
			return true;
		} else {
			return false;
		}
	}

	public BinaryTree createCopy() {
		return new BinaryTree(createCopy(this.root));

	}

	private Node createCopy(Node node) {
		if (isEmpty(node)) {
			return null;
		}
		Node current = new Node(node.getData());
		Node left = createCopy(node.getLeft());
		Node right = createCopy(node.getRight());
		current.setLeft(left);
		current.setRight(right);
		return current;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		if (isEmpty(node)) {
			return;
		}
		mirror(node.getLeft());
		mirror(node.getRight());
		Node left = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(left);
	}

	public void isMirror(BinaryTree bt) {
		System.out.println("The trees are mirror: " + isMirror(this.root, bt.root));
	}

	private boolean isMirror(Node node1, Node node2) {
		if (!isEmpty(node1) && !isEmpty(node2)) {
			if (node1.getData() != node2.getData()) {
				return false;
			}
			boolean left = isMirror(node1.getLeft(), node2.getRight());
			if (!left) {
				return false;
			}
			return isMirror(node1.getRight(), node2.getLeft());
		} else if (isEmpty(node1) && isEmpty(node2)) {
			return true;
		} else {
			return false;
		}
	}

	public void printAncestors(int data) {
		if (!printAncestors(this.root, data)) {
			System.out.println("data not found");
		} else {
			System.out.println();
		}
	}

	private boolean printAncestors(Node node, int data) {
		if (isEmpty(node)) {
			return false;
		}
		if (node.getData() == data) {
			return true;
		}
		if (printAncestors(node.getLeft(), data)) {
			System.out.print("\t" + node.getData());
			return true;
		}
		Boolean right = printAncestors(node.getRight(), data);
		if (right) {
			System.out.print("\t" + node.getData());
		}
		return right;
	}

	public int findLevel(int data) {
		int findLevel = findLevel(this.root, data);
		System.out.println("the level is: " + findLevel);
		//System.out.println("the level is: " + findLevel(this.root, data, 0));
		return findLevel;

	}

	private int findLevel(Node node, int data, int level) {
		if (isEmpty(node)) {
			return -1;
		}
		if (node.getData() == data) {
			return level;
		}
		int left = findLevel(node.getLeft(), data, level + 1);
		if (left != -1) {
			return left;
		}
		int right = findLevel(node.getRight(), data, level + 1);
		return right;

	}

	private int findLevel(Node node, int data) {
		if (isEmpty(node)) {
			return -1;
		}
		if (node.getData() == data) {
			return 0;
		}
		int left = findLevel(node.getLeft(), data);
		if (left != -1) {
			return left + 1;
		}
		int right = findLevel(node.getRight(), data);
		if (right != -1) {
			return right + 1;
		}
		return right;
	}

	public boolean areSiblings(int data1, int data2) {
		 boolean areSiblings = areSiblings(this.root, data1, data2);
		System.out.println("The values are siblings: " + areSiblings);
		return areSiblings;
	}

	private boolean areSiblings(Node node, int data1, int data2) {
		if (isEmpty(node)) {
			return false;
		}
		if (isLeaf(node)) {
			return false;
		}
		if (node.getLeft() != null && (node.getLeft().getData() == data1 || node.getLeft().getData() == data2)
				&& node.getRight() != null
				&& (node.getRight().getData() == data1 || node.getRight().getData() == data2)){
			return true;
		}
			return (areSiblings(node.getLeft(), data1, data2) || areSiblings(node.getRight(), data1, data2));
	}

	public void areCousins(int data1, int data2) {
		boolean areCousins= false;
		if(findLevel(data1)==findLevel(data2) && !areSiblings(data1, data2)){
			areCousins = true;
		}
		System.out.println("They are cousins: " + areCousins);
	}

	public void printRootToLeaf() {
		printRootToLeaf(this.root, new int[10], 0);
	}

	private void printRootToLeaf(Node node, int[] array, int level) {
		if(isEmpty(node)){
			return;
		}
		array[level] = node.getData();
		if(isLeaf(node)){
			for(int i=0; i<=level; i++){
				System.out.print("\t" + array[i]);
			}
			System.out.println();
		}
		printRootToLeaf(node.getLeft(), array,level+1);
		printRootToLeaf(node.getRight(), array,level+1);
	}

	public void prntSumPathForANumber(int data) {
		boolean found = prntSumPathForANumber(this.root, new int[10], 0, data);
		System.out.println("path exist: " + found);
	}

	private boolean prntSumPathForANumber(Node node, int[] array, int level, int data) {
		if(isEmpty(node)){
			return false;
		}
		array[level] = node.getData();
		if(arraySum(array, level)==data){
			for(int i=0; i<=level; i++){
				System.out.print("\t" + array[i]);
			}
			System.out.println();
			return true;
		}
		if(prntSumPathForANumber(node.getLeft(), array,level+1, data)){
			return true;
		}
		return prntSumPathForANumber(node.getRight(), array,level+1, data);
	}

	private int arraySum(int[] array, int level) {
		int sum = 0;
		for(int i=0; i<=level; i++){
			sum = sum + array[i];
		}
		return sum;
	}

	public void diameter() {
		System.out.println("The diameter is: "+ diameter(this.root));

	}

	private int diameter(Node node) {
		if(isEmpty(node)){
			return -1;
		}
		int left = diameter(node.getLeft());
		int right = diameter(node.getRight());
		int current = 1+findHeight(node.getLeft()) + 1+ findHeight(node.getRight()) + 1;
		return maxOf(current, left, right);
	}

}
