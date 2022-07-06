package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class ReverseDoublyLinkedList {

    private static final Scanner scanner = new Scanner(System.in);

    private static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println((node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
     * DoublyLinkedListNode prev; }
     *
     */
    private static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head != null) {
            while (head.next != null) {
                DoublyLinkedListNode currentNode = head;
                head = head.next;
                DoublyLinkedListNode temp = currentNode.prev;
                currentNode.prev = currentNode.next;
                currentNode.next = temp;
            }
            DoublyLinkedListNode temp = head.prev;
            head.prev = head.next;
            head.next = temp;
        }
        return head;
    }

    // Complete the reverse function below.

    public static void main(String[] args) throws IOException {
        int t = ReverseDoublyLinkedList.scanner.nextInt();
        ReverseDoublyLinkedList.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = ReverseDoublyLinkedList.scanner.nextInt();
            ReverseDoublyLinkedList.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = ReverseDoublyLinkedList.scanner.nextInt();
                ReverseDoublyLinkedList.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = ReverseDoublyLinkedList.reverse(llist.head);

            ReverseDoublyLinkedList.printDoublyLinkedList(llist1, " ");
        }

        ReverseDoublyLinkedList.scanner.close();
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int nodeData) {
            data = nodeData;
            next = null;
            prev = null;
        }
    }

    static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        DoublyLinkedList() {
            head = null;
            tail = null;
        }

        void insertNode(int nodeData) {

            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }

            tail = node;
        }
    }
}
