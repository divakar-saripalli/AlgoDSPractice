package com.div.missionfaang.algoexpert;

import java.util.ArrayList;

public class FindNodesDistanceK {
	public static boolean IS_NODE_AT_LEFT = false;
	public static BinaryTree NODE = null;

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
		// Write your code here.
		int distanceFromRoot = findDistanceFromRoot(tree, target);

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (distanceFromRoot < k) {
			if (IS_NODE_AT_LEFT) {
				findAndAddNodesAtLevelK(tree.right, k, distanceFromRoot + 1, result);
			} else {
				findAndAddNodesAtLevelK(tree.left, k, distanceFromRoot + 1, result);
			}
		} else {
			findAndAddNodesAtLevelK(tree, k, distanceFromRoot + 1, result);
		}
		findAndAddNodesAtLevelK(NODE, k, 0, result);

		return result;
	}

	public static void findAndAddNodesAtLevelK(BinaryTree node, int k, int currentLevel, ArrayList<Integer> result) {
		if (node != null) {
			if (k == currentLevel) {
				result.add(node.value);
			}
			findAndAddNodesAtLevelK(node.left, k, currentLevel + 1, result);
			findAndAddNodesAtLevelK(node.right, k, currentLevel + 1, result);
		}
	}

	private static int findDistanceFromRoot(BinaryTree tree, int target) {
		// TODO Auto-generated method stub
		if (tree != null) {
			if (tree.value == target) {
				NODE = tree;
				return 1;
			}
			int leftDistance = findDistanceFromRoot(tree.left, target);
			if (-1 != leftDistance) {
				IS_NODE_AT_LEFT = true;
				return leftDistance++;
			}
			int rightDistance = findDistanceFromRoot(tree.right, target);
			if (-1 != rightDistance) {
				IS_NODE_AT_LEFT = false;
				return rightDistance++;
			}
		}
		return -1;
	}

//	private BinaryTree findNode(BinaryTree tree, int target) {
//		// TODO Auto-generated method stub
//		if (tree != null) {
//			if (tree.value == target) {
//				return tree;
//			}
//			BinaryTree leftNode = findNode(tree.left, target);
//			if (leftNode != null) {
//				return leftNode;
//			}
//			BinaryTree rightNode = findNode(tree.right, target);
//			if (rightNode != null) {
//				return rightNode;
//			}
//		}
//		return null;
//	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
		tree.right = new BinaryTree(3);
		tree.left.left = new BinaryTree(4);
		tree.left.right = new BinaryTree(5);
		tree.right.right = new BinaryTree(6);
		tree.right.right.left = new BinaryTree(7);
		tree.right.right.right = new BinaryTree(8);

		System.out.println(findNodesDistanceK(tree, 3, 2).toString());
	}

}
