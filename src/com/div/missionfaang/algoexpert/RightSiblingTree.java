package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;

public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        // Write your code here.
        if (root == null) {
            return root;
        }
        ArrayList<Integer> noOfNodesAtLevel = new ArrayList<>();
        LinkedList<BinaryTree> queue = new LinkedList<>();
        noOfNodesAtLevel.add(0, 1);
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int noNodes = noOfNodesAtLevel.get(level);
            for (int i = 0; i < noNodes; i++) {
                BinaryTree node = queue.poll();

                if (node.left != null) {
                    if (noOfNodesAtLevel.size() <= level + 1) {
                        noOfNodesAtLevel.add(level + 1, 1);
                    } else {
                        noOfNodesAtLevel.set(level + 1, noOfNodesAtLevel.get(level + 1) + 1);
                    }
                    queue.add(node.left);
                }

                if (node.right != null) {
                    if (noOfNodesAtLevel.size() <= level + 1) {
                        noOfNodesAtLevel.add(level + 1, 1);
                    } else {
                        noOfNodesAtLevel.set(level + 1, noOfNodesAtLevel.get(level + 1) + 1);
                    }
                    queue.add(node.right);
                }
                if (i < noNodes - 1) {
                    node.right = queue.peek();
                } else {
                    node.right = null;
                }
            }
            level++;
        }
        root.right = null;
        return root;
    }

    public static void preOrder(BinaryTree root) {
        if (root != null) {
            preOrder(root.left);
            System.out.print(root.value + " ");
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right.right = new BinaryTree(10);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.right.left.left = new BinaryTree(11);
        root.right.left.left.left = new BinaryTree(14);
        root.right.right.left = new BinaryTree(12);
        root.right.right.right = new BinaryTree(13);

        preOrder(root);
        rightSiblingTree(root);
        System.out.println("==========================");
        preOrder(root);

    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "" + value;
        }
    }
}
