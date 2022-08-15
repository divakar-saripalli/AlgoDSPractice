package com.div.missionfaang.scaler.trees;

import java.util.ArrayList;

public class BasicTree {

    private ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A != null) {
            ArrayList<Integer> result = new ArrayList<>(inorderTraversal(A.left));
            result.add(A.val);
            result.addAll(inorderTraversal(A.right));
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private ArrayList<Integer> preorderTraversal(TreeNode A) {
        if (A != null) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(A.val);
            result.addAll(preorderTraversal(A.left));
            result.addAll(preorderTraversal(A.right));
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private ArrayList<Integer> postorderTraversal(TreeNode A) {
        if (A != null) {
            ArrayList<Integer> result = new ArrayList<>();
            result.addAll(postorderTraversal(A.left));
            result.addAll(postorderTraversal(A.right));
            result.add(A.val);
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private int heightOfTree(TreeNode A) {
        if (A == null) {
            return 0;
        } else {
            return 1 + Math.max(heightOfTree(A.left), heightOfTree(A.right));
        }
    }

    private int isSameTree(TreeNode A, TreeNode B) {
        if (A != null && B != null) {
            int left = isSameTree(A.left, B.left);
            int right = isSameTree(A.right, B.right);
            return (A.val == B.val && left == 1 && right == 1) ? 1 : 0;
        } else if (A != null || B != null) {
            return 0;
        } else {
            return 1;
        }
    }

    private int nodesCount(TreeNode A) {
        if (A == null) {
            return 0;
        } else {
            return 1 + nodesCount(A.left) + nodesCount(A.right);
        }
    }

    public int countGreaterNodes(TreeNode A) {
        return 1 + countNodes(A, A.val);
    }

    private int countNodes(TreeNode A, int max) {
        if (A == null) {
            return 0;
        }

        if (A.val > max) {
            return 1 + countNodes(A.left, A.val) + countNodes(A.right, A.val);
        } else {
            return countNodes(A.left, max) + countNodes(A.right, max);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
