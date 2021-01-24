package com.div.missionfaang.hackerrank;

import java.util.ArrayList;

public class LeftView {

	static int maxHeight = 0;

	static void leftView(Node root, ArrayList<Integer> list, int height) {
		if (root != null) {
			if (maxHeight < height) {
				list.add(root.data);
				maxHeight = height;
			}
			leftView(root.left, list, height + 1);
			leftView(root.right, list, height + 1);
		}
//		return list;
	}

	static ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		leftView(root, list, 0);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(2);
		root.left = new Node(2);
		root.right = new Node(13);
		root.left.left = new Node(7);
		root.left.right = new Node(10);
		root.left.left.left = new Node(5);
		root.left.left.left.left = new Node(13);
		root.left.left.right = new Node(2);
		root.left.right.right = new Node(14);
		root.right.left = new Node(1);
		root.right.right = new Node(10);
		root.right.left.left = new Node(5);
		root.right.left.right = new Node(11);
		root.right.right.left = new Node(5);
		root.right.right.right = new Node(5);
		ArrayList<Integer> list = new ArrayList<>();
		leftView(root, list, 1);
		System.out.println(list.toString());

	}
}