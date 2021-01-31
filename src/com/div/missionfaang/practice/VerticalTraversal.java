package com.div.missionfaang.practice;

import java.util.ArrayList;
import java.util.Stack;

public class VerticalTraversal {

	static int leftHeight = 0;
	static int rightHeight = 0;

	static ArrayList<Integer> verticalOrder(Node root) {
		if (root == null) {
			return null;
		}

		int rootLevel = 0;
		findHeights(root);
		int totalStacks = leftHeight + rightHeight + 1;
		ArrayList<Integer> order = new ArrayList<>();

		if (totalStacks == 1) {
			order.add(root.data);
			return order;
		}

		if (totalStacks % 2 == 0) {
			rootLevel = (leftHeight > rightHeight) ? totalStacks / 2 : totalStacks / 2 + 1;
		} else {
			rootLevel = totalStacks / 2;
		}

		Stack<Integer>[] stacks = new Stack[totalStacks];
		vertOrder(root, stacks, rootLevel);
		for (int i = 0; i < totalStacks; i++) {
			order.addAll(stacks[i]);
		}
		return order;
	}

	static void vertOrder(Node root, Stack[] stacks, int rootLevel) {
		if (root != null) {
			if (stacks[rootLevel] == null) {
				stacks[rootLevel] = new Stack<Integer>();
			}
			stacks[rootLevel].push(root.data);
			vertOrder(root.left, stacks, rootLevel - 1);
			vertOrder(root.right, stacks, rootLevel + 1);
		}
	}

	static void findHeights(Node root) {
		Node left = root.left;
		Node right = root.right;
		while (left != null) {
			leftHeight++;
			left = left.left;
		}
		while (right != null) {
			rightHeight++;
			right = right.right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		System.out.println(verticalOrder(root).toString());
	}

}
