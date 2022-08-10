package com.div.missionfaang.scaler.linkedlists;

import java.util.Scanner;

public class BasicLinkedList {

    public static CustomLinkedList head = new CustomLinkedList();

//    static {
//        BasicLinkedList.head = new CustomLinkedList();
//    }

    private static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        int tempPos = 0;
        CustomLinkedList node = BasicLinkedList.head;
        while (tempPos < position && node.pointer != null) {
            node = node.pointer;
            tempPos++;
        }
        if (tempPos == position) {
            CustomLinkedList temp = node.pointer;
            node.pointer = new CustomLinkedList();
            node.pointer.value = value;
            node.pointer.pointer = temp;
        }
    }

    private static void delete_node(int position) {
        // @params position, integer
        int tempPos = 0;
        CustomLinkedList node = BasicLinkedList.head;
        while (tempPos < position && node.pointer != null) {
            node = node.pointer;
            tempPos++;
        }
        if (tempPos == position && node.pointer != null) {
            node.pointer = node.pointer.pointer;
        }
    }

    private static void print_ll() {
        // Output each element followed by a space
        CustomLinkedList node = BasicLinkedList.head;
        while (node != null) {
            System.out.print(node.value + " ");
            System.out.println();
            node = node.pointer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String c = sc.nextLine();
            switch (c) {
                case "i": {
                    int pos = sc.nextInt();
                    int val = sc.nextInt();
                    BasicLinkedList.insert_node(pos, val);
                    break;
                }
                case "d": {
                    int pos = sc.nextInt();
                    BasicLinkedList.delete_node(pos);
                    break;
                }
                case "p":
                    BasicLinkedList.print_ll();
            }
        }
    }

    static class CustomLinkedList {
        int value;
        CustomLinkedList pointer;
    }
}