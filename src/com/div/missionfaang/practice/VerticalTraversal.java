package com.div.missionfaang.practice;

import java.util.ArrayList;

public class VerticalTraversal {

    private static int minHeight = 0;
    private static int maxHeight = 0;

    private static ArrayList<Integer> verticalOrder(Node root) {
        if (root == null) {
            return null;
        }

        VerticalTraversal.findHeights(root, 0);
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = VerticalTraversal.minHeight; i <= VerticalTraversal.maxHeight; i++) {
            VerticalTraversal.vertOrder(root, i, 0, order);
        }
        return order;
    }

    private static void vertOrder(Node root, int lineNumber, int horizontalDistance, ArrayList<Integer> order) {
        if (root != null) {
            if (horizontalDistance == lineNumber) {
                order.add(root.data);
            }
            VerticalTraversal.vertOrder(root.left, lineNumber, horizontalDistance - 1, order);
            VerticalTraversal.vertOrder(root.right, lineNumber, horizontalDistance + 1, order);
        }
    }

    private static void findHeights(Node root, int horizontalDistance) {
        if (root == null) {
            return;
        }
        if (horizontalDistance < VerticalTraversal.minHeight) {
            VerticalTraversal.minHeight = horizontalDistance;
        }

        if (horizontalDistance > VerticalTraversal.maxHeight) {
            VerticalTraversal.maxHeight = horizontalDistance;
        }

        VerticalTraversal.findHeights(root.left, horizontalDistance - 1);
        VerticalTraversal.findHeights(root.right, horizontalDistance + 1);
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
        System.out.println(VerticalTraversal.verticalOrder(root).toString());
    }

}
