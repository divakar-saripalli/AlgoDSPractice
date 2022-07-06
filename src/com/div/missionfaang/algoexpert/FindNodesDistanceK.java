package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindNodesDistanceK {
    public static boolean IS_NODE_AT_LEFT = false;
    public static BinaryTree NODE = null;

    private static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<BinaryTree, BinaryTree> parentChildMap = new HashMap<>();
        BinaryTree targetNode = FindNodesDistanceK.buildParentChildRelation(tree, parentChildMap, target);
        HashSet<BinaryTree> visited = new HashSet<>();
        FindNodesDistanceK.findKDistantNodes(targetNode, k, parentChildMap, visited, 0, result);
        return result;
    }

    private static void findKDistantNodes(BinaryTree node, int k, HashMap<BinaryTree, BinaryTree> parentChildMap,
                                          HashSet<BinaryTree> visited, int level, ArrayList<Integer> result) {
        if (node != null && !visited.contains(node)) {
            visited.add(node);
            if (level == k) {
                result.add(node.value);
            }
            FindNodesDistanceK.findKDistantNodes(node.left, k, parentChildMap, visited, level + 1, result);
            FindNodesDistanceK.findKDistantNodes(node.right, k, parentChildMap, visited, level + 1, result);
            FindNodesDistanceK.findKDistantNodes(parentChildMap.get(node), k, parentChildMap, visited, level + 1, result);
        }
    }

    private static BinaryTree buildParentChildRelation(BinaryTree tree, HashMap<BinaryTree, BinaryTree> parentChildMap,
                                                       int target) {
        if (tree != null) {
            parentChildMap.put(tree.left, tree);
            parentChildMap.put(tree.right, tree);
            BinaryTree left = FindNodesDistanceK.buildParentChildRelation(tree.left, parentChildMap, target);
            BinaryTree right = FindNodesDistanceK.buildParentChildRelation(tree.right, parentChildMap, target);
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            if (tree.value == target) {
                return tree;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.right = new BinaryTree(6);
        tree.right.right.left = new BinaryTree(7);
        tree.right.right.right = new BinaryTree(8);

        System.out.println(FindNodesDistanceK.findNodesDistanceK(tree, 3, 2));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        BinaryTree(int value) {
            this.value = value;
        }
    }

}
