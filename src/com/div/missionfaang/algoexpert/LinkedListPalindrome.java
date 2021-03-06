package com.div.missionfaang.algoexpert;

public class LinkedListPalindrome {

	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return value + "";
		}
	}

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

	public static void main(String[] args) {
		LinkedList head = new LinkedList(0);
//		head.next = new LinkedList(1);
//		head.next.next = new LinkedList(2);
//		head.next.next.next = new LinkedList(2);
//		head.next.next.next.next = new LinkedList(1);
//		head.next.next.next.next.next = new LinkedList(0);
		System.out.println(linkedListPalindrome(head));
	}

}
