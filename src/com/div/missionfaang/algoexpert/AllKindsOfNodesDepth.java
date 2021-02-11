package com.div.missionfaang.algoexpert;

public class AllKindsOfNodesDepth {
	public static int allKindsOfNodeDepths(BinaryTree root) {
		// Write your code here.
		if (root != null) {
			int leftDepth = allKindsOfNodeDepths(root.left);
			int rightDepth = allKindsOfNodeDepths(root.right);
			int depth = leftDepth + rightDepth + 1;
			return depth + leftDepth + rightDepth;
		}
		return 0;
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);
		root.left.left.left = new BinaryTree(8);
		root.left.left.right = new BinaryTree(9);
		System.out.println(allKindsOfNodeDepths(root));
	}
}
