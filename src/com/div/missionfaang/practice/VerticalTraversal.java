package com.div.missionfaang.practice;

import java.util.ArrayList;

public class VerticalTraversal {

	static int minHeight = 0;
	static int maxHeight = 0;

	static ArrayList<Integer> verticalOrder(Node root) {
		if (root == null) {
			return null;
		}

		findHeights(root, 0);
		ArrayList<Integer> order = new ArrayList<>();
		for (int i = minHeight; i <= maxHeight; i++) {
			vertOrder(root, i, 0, order);
		}
		return order;
	}

	static void vertOrder(Node root, int lineNumber, int horizontalDistance, ArrayList<Integer> order) {
		if (root != null) {
			if (horizontalDistance == lineNumber) {
				order.add(root.data);
			}
			vertOrder(root.left, lineNumber, horizontalDistance - 1, order);
			vertOrder(root.right, lineNumber, horizontalDistance + 1, order);
		}
	}

	static void findHeights(Node root, int horizontalDistance) {
		if (root == null) {
			return;
		}
		if (horizontalDistance < minHeight) {
			minHeight = horizontalDistance;
		}

		if (horizontalDistance > maxHeight) {
			maxHeight = horizontalDistance;
		}

		findHeights(root.left, horizontalDistance - 1);
		findHeights(root.right, horizontalDistance + 1);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println(verticalOrder(root).toString());
	}

}
