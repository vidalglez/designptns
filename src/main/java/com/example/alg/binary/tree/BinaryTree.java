package com.example.alg.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	TreeNode root;

	private static int answer = 0;
	

	protected void insert(int val) {
		TreeNode newNode = new TreeNode(val);
		if (root == null) {
			root = newNode;
		} else {
			TreeNode parent;
			TreeNode current = root;
			while (true) {
				parent = current;
				if (val < current.val) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public static void printLevelOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		int level = 0;

		List<List<TreeNode>> queue = new ArrayList<>();

		setLevelOrder(queue, node, level);

		System.out.println();
		for (List<TreeNode> item : queue) {
			System.out.println();
			for (TreeNode itemNode : item) {
				System.out.print(String.format(" %d ", itemNode.val));
			}
			System.out.println();
		}

	}

	public static void setLevelOrder(List<List<TreeNode>> queue, TreeNode node, int level) {
		if (node == null) {
			return;
		}

		List<TreeNode> intQueue;
		try {
			intQueue = queue.get(level);
		} catch (Exception ex) {
			intQueue = new ArrayList<>();
			queue.add(level, intQueue);
		}

		intQueue.add(node);

		level++;
		setLevelOrder(queue, node.left, level);
		setLevelOrder(queue, node.right, level);
	}

	public static void printPreOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(String.format(" %d ", node.val));
		printPreOrder(node.left);
		printPreOrder(node.right);

	}

	public static void printInOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		printInOrder(node.left);
		System.out.print(String.format(" %d ", node.val));
		printInOrder(node.right);
	}

	public static void printPostOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(String.format(" %d ", node.val));
	}

	public static void maxDepth(TreeNode node, int depth) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			answer = Integer.max(answer, depth);
		}
		maxDepth(node.left, depth + 1);
		maxDepth(node.right, depth + 1);
	}

	public static int getMaxDepth(TreeNode node) {
		answer = 0;
		maxDepth(node, answer + 1);
		return answer;
	}

	public static boolean hasPathSum(TreeNode node, int sum ) {
		
		return getSumRootLeaf(node, sum, 0);
	}
	
	public static boolean getSumRootLeaf(TreeNode node, int sum, int partialSum) {
		if(node == null) {
			return false;
		}
		partialSum += node.val;
		if(node.left == null && node.right == null) {
			return sum == partialSum;
		} 
		boolean res1 = getSumRootLeaf(node.left, sum, partialSum);
		boolean res2 = getSumRootLeaf(node.right, sum, partialSum);
		
		return res1 || res2;
	}
	
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		bt.insert(45);
		bt.insert(12);
		bt.insert(95);
		bt.insert(31);
		bt.insert(40);
		bt.insert(67);
		bt.insert(115);
		bt.insert(7);
		//bt.insert(42);

		BinaryTree.printPreOrder(bt.root);
		System.out.println();

		BinaryTree.printInOrder(bt.root);
		System.out.println();

		BinaryTree.printPostOrder(bt.root);
		System.out.println();

		BinaryTree.printLevelOrder(bt.root);

		System.out.println();
		System.out.println(String.format("Max Depth: %d", BinaryTree.getMaxDepth(bt.root)));
		
		System.out.println(String.format("Has path sum: %b", BinaryTree.hasPathSum(bt.root,88)));
		
		

	}
}
