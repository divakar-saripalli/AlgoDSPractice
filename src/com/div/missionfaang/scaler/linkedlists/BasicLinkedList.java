package com.div.missionfaang.scaler.linkedlists;

import java.util.ArrayList;
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

    private static ListNode designLinkedList(ArrayList<ArrayList<Integer>> A) {
        ListNode root = null;
        for (ArrayList<Integer> integers : A) {
            int operation = integers.get(0);
            switch (operation) {
                case 0:
                    if (root == null) {
                        root = new ListNode(integers.get(1));
                    } else {
                        ListNode newRoot = new ListNode(integers.get(1));
                        newRoot.next = root;
                        root = newRoot;
                    }
                    break;
                case 1:
                    if (root != null) {
                        ListNode temp = root;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = new ListNode(integers.get(1));
                    }
                    break;
                case 2:
                    if (root == null) {
                        if (integers.get(2) == 0) {
                            root = new ListNode(integers.get(1));
                        }
                    } else {
                        int index = 0;
                        ListNode temp = root;
                        if (integers.get(2) == 0) {
                            ListNode newNode = new ListNode(integers.get(1));
                            newNode.next = root;
                            root = newNode;
                        } else {
                            while (index < integers.get(2) - 1 && temp != null) {
                                temp = temp.next;
                                index++;
                            }
                            if (temp != null) {
                                ListNode newNode = new ListNode(integers.get(1));
                                newNode.next = temp.next;
                                temp.next = newNode;
                            }
                        }
                    }
                    break;
                case 3:
                    if (root != null) {
                        if (integers.get(1) == 0) {
                            root = root.next;
                        } else {
                            ListNode temp = root;
                            int index = 0;
                            while (index < integers.get(1) - 1 && temp != null) {
                                temp = temp.next;
                                index++;
                            }
                            if (temp != null) {
                                if (temp.next != null) {
                                    temp.next = temp.next.next;
                                }
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return root;
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
                    break;
                default:
                    break;
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

class ListNode {
    private final int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}