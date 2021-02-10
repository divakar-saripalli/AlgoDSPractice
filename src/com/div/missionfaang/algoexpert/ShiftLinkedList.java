package com.div.missionfaang.algoexpert;

public class ShiftLinkedList {

	public static LinkedList shiftLinkedList(LinkedList head, int k) {
		// Write your code here.
		if (head == null) {
			return null;
		}

		int length = 1;
		LinkedList temp = head;
		while (temp.next != null) {
			length++;
			temp = temp.next;
		}
		k = k % length;
		if (k < 0) {
			k = length + k;
		}

		LinkedList sp = head;
		LinkedList fp = head;

		int i = 0;
		while (i != k) {
			fp = fp.next;
			i++;
		}

		while (fp.next != null) {
			sp = sp.next;
			fp = fp.next;
		}

		fp.next = head;
		head = sp.next;
		sp.next = null;

		return head;
	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(3);
		head.next.next.next.next = new LinkedList(4);
		head.next.next.next.next.next = new LinkedList(5);

		shiftLinkedList(head, -8);

	}

}
