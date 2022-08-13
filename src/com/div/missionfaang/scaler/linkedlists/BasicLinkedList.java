package com.div.missionfaang.scaler.linkedlists;

import java.util.Scanner;

public class BasicLinkedList {

    private static LinkedListNode root = null;

    private static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (position == 1) {
            LinkedListNode node = new LinkedListNode();
            node.value = value;
            node.pointer = BasicLinkedList.root;
            BasicLinkedList.root = node;
        } else {
            int tempPos = 2;
            LinkedListNode node = BasicLinkedList.root;

            while (tempPos < position && node != null) {
                node = node.pointer;
                tempPos++;
            }
            if (tempPos == position && node != null) {
                LinkedListNode temp = node.pointer;
                node.pointer = new LinkedListNode();
                node.pointer.value = value;
                node.pointer.pointer = temp;
            }
        }
    }

    private static void delete_node(int position) {
        // @params position, integer
        if (position == 1) {
            BasicLinkedList.root = BasicLinkedList.root.pointer;
        } else {
            int tempPos = 2;
            LinkedListNode node = BasicLinkedList.root;
            while (tempPos < position && node != null) {
                node = node.pointer;
                tempPos++;
            }
            if (tempPos == position && node != null && node.pointer != null) {
                node.pointer = node.pointer.pointer;
            }
        }
    }

    private static void print_ll() {
        // Output each element followed by a space
        LinkedListNode node = BasicLinkedList.root;
        while (node != null) {
            if (node.pointer != null) {
                System.out.print(node.value + " ");
            } else {
                System.out.print(node.value);
            }
            node = node.pointer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String c = sc.nextLine();
            switch (c) {
                case "i" -> {
                    int pos = sc.nextInt();
                    int val = sc.nextInt();
                    BasicLinkedList.insert_node(pos, val);
                    break;
                }
                case "d" -> {
                    int pos = sc.nextInt();
                    BasicLinkedList.delete_node(pos);
                    break;
                }
                case "p" -> BasicLinkedList.print_ll();
            }
        }
    }

    static class LinkedListNode {
        int value;
        LinkedListNode pointer;

        LinkedListNode() {
            value = 0;
            pointer = null;
        }
    }
}