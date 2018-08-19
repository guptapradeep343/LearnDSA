package ds.binaryTree;

public class BinarySearchTree extends BinaryTree {

	public void insertIterative(int data) {
		Node node = new Node(data);
		if (isEmpty(this.root)) {
			this.root = node;
			return;
		}
		Node temp = this.root;
		while (true) {
			if (temp.getData() > data) {
				if (isEmpty(temp.getLeft())) {
					temp.setLeft(node);
					return;
				} else {
					temp = temp.getLeft();
				}
			} else {
				if (isEmpty(temp.getRight())) {
					temp.setRight(node);
					return;
				} else {
					temp = temp.getRight();
				}
			}
		}
	}

	public void insertRecursive(int data) {
		this.root = insertIterative(this.root, data);
	}

	private Node insertIterative(Node node, int data) {
		if (isEmpty(node)) {
			return new Node(data);
		}
		if (node.getData() > data) {
			Node left = insertIterative(node.getLeft(), data);
			node.setLeft(left);
			return node;
		}
		Node right = insertIterative(node.getRight(), data);
		node.setRight(right);
		return node;
	}

	@Override
	public void findNode(int data) {
		Node node = findNode(this.root, data);
		System.out.println("Data found: " + !isEmpty(node));
	}

	private Node findNode(Node node, int data) {
		if (isEmpty(node))
			return null;
		if (node.getData() == data) {
			return node;
		} else if (node.getData() > data) {
			return findNode(node.getLeft(), data);
		} else {
			return findNode(node.getRight(), data);
		}
	}

	public void findMaxIterative() {
		Node temp = this.root;
		if (isEmpty(temp)) {
			System.out.println("Tree is empty");
			return;
		}
		while (temp != null) {
			if (isEmpty(temp.getRight())) {
				System.out.println("Maximum of the tree is: " + temp.getData());
				return;
			}
			temp = temp.getRight();
		}
	}

	public void findMaxRecursive() {
		Node max = findMaxRecursive(this.root);
		System.out.println(isEmpty(max) ? "The tree is empty" : "Maximum of the tree is: " + max.getData());
	}

	private Node findMaxRecursive(Node node) {
		if (isEmpty(node))
			return null;
		if (node.getRight() == null) {
			return node;
		}
		return findMaxRecursive(node.getRight());
	}
	private Node findMinRecursive(Node node) {
		if (isEmpty(node))
			return null;
		if (node.getLeft() == null) {
			return node;
		}
		return findMaxRecursive(node.getLeft());
	}

	public void delete(int data) {
		this.root = delete(this.root, data);
	}

	private Node delete(Node node, int data) {
		if (isEmpty(node))
			return null;
		if (node.getData() > data) {
			Node left = delete(node.getLeft(), data);
			node.setLeft(left);
			return node;
		} else if (data > node.getData()) {
			Node right = delete(node.getRight(), data);
			node.setRight(right);
			return node;
		} else {
			if (isLeaf(node)) {
				return null;
			} else if (!isEmpty(node.getLeft()) && isEmpty(node.getRight())) {
				return node.getLeft();
			} else if (isEmpty(node.getLeft()) && !isEmpty(node.getRight())) {
				return node.getRight();
			} else {
				Node max = findMaxRecursive(node.getLeft());
				node.setData(max.getData());
				node.setLeft(delete(node.getLeft(), max.getData()));
				return node;
			}
		}
	}
}
