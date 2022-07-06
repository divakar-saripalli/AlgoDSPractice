package com.div.missionfaang.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class CycleDetection {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
     *
     */
    private static boolean hasCycle(SinglyLinkedListNode head) {
        if (head.next != null) {
            SinglyLinkedListNode slowPointer = head;
            SinglyLinkedListNode fastPointer = null;
            fastPointer = slowPointer.next;
            while (fastPointer != slowPointer) {
                if (fastPointer.next != null) {
                    fastPointer = fastPointer.next;
                    if (fastPointer != slowPointer) {
                        if (fastPointer.next != null) {
                            fastPointer = fastPointer.next;
                            if (fastPointer == slowPointer) {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
                if (slowPointer.next != null) {
                    slowPointer = slowPointer.next;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Complete the hasCycle function below.

    public static void main(String[] args) throws IOException {
        int tests = CycleDetection.scanner.nextInt();
        CycleDetection.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = CycleDetection.scanner.nextInt();
            CycleDetection.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            SinglyLinkedList llist = new SinglyLinkedList();
            int llistCount = CycleDetection.scanner.nextInt();
            CycleDetection.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llistCount; i++) {
                int llistItem = CycleDetection.scanner.nextInt();
                CycleDetection.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist.insertNode(llistItem);
            }
            SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;
            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }
                if (i != llistCount - 1) {
                    temp = temp.next;
                }
            }
            temp.next = extra;
            System.out.println(CycleDetection.hasCycle(llist.head));
        }
        CycleDetection.scanner.close();
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode(int nodeData) {
            data = nodeData;
            next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        SinglyLinkedList() {
            head = null;
            tail = null;
        }

        void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;
        }
    }
}
