package com.div.missionfaang.algoexpert;

public class LinkedListPalindrome {

    public static boolean linkedListPalindrome(LinkedList head) {
        // Write your code here.
        if (head == null) {
            return false;
        }
        LinkedList slowPointer = head;
        LinkedList fastPointer = head;
        LinkedList firstHalf = head;
        int listLength = 0;
        while (fastPointer != null) {
            listLength++;
            firstHalf = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                listLength++;
                fastPointer = fastPointer.next;
            }
        }

        if (listLength > 1) {
            slowPointer = listLength % 2 != 0 ? slowPointer.next : slowPointer;
            LinkedList prev = null;
            LinkedList next = null;
            while (slowPointer != null) {
                next = slowPointer.next;
                slowPointer.next = prev;
                prev = slowPointer;
                slowPointer = next;
            }
            slowPointer = prev;
            firstHalf.next = slowPointer;

            while (slowPointer != null) {
                if (head.value != slowPointer.value) {
                    return false;
                }
                head = head.next;
                slowPointer = slowPointer.next;
            }
            return true;
        }
        return true;
    }

    private static int eliminateNext() {
        LinkedList head = new LinkedList(1);
        LinkedList node = head;
        for (int i = 2; i <= 100; i++) {
            node.next = new LinkedList(i);
            node = node.next;
        }
        node.next = head;
        node = head;
        while (node.next != null) {
            LinkedList temp = node.next.next;
            node.next.next = null;
            node.next = temp;
            node = node.next;
            System.out.println(node.value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(node.value);
        return node.value;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
//		head.next = new LinkedList(1);
//		head.next.next = new LinkedList(2);
//		head.next.next.next = new LinkedList(2);
//		head.next.next.next.next = new LinkedList(1);
//		head.next.next.next.next.next = new LinkedList(0);
//		System.out.println(linkedListPalindrome(head));
        LinkedListPalindrome.eliminateNext();
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        LinkedList(int value) {
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return value + "";
        }
    }

}
