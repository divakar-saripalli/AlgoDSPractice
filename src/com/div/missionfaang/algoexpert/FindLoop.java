package com.div.missionfaang.algoexpert;

public class FindLoop {
	public static LinkedList findLoop(LinkedList head) {
		LinkedList slowPointer = head;
		LinkedList fastPointer = null;
		boolean foundLoop = false;
		if (head.next != null) {
			fastPointer = slowPointer.next;
			while (fastPointer != slowPointer) {
				if (fastPointer.next != null) {
					fastPointer = fastPointer.next;
					if (fastPointer != slowPointer) {
						if (fastPointer.next != null) {
							fastPointer = fastPointer.next;
							if (fastPointer == slowPointer) {
								foundLoop = true;
								break;
							}
						} else {
							foundLoop = false;
							break;
						}
					} else {
						foundLoop = true;
						break;
					}
				} else {
					foundLoop = false;
					break;
				}
				if (slowPointer.next != null) {
					slowPointer = slowPointer.next;
				} else {
					foundLoop = false;
					break;
				}
			}
			foundLoop = true;
		} else {
			foundLoop = false;
		}
		if (foundLoop) {
			slowPointer = head;
			while (fastPointer != slowPointer) {
				fastPointer = fastPointer.next;
				slowPointer = slowPointer.next;
			}
			return slowPointer;
		}
		return head;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(3);
		head.next.next.next.next = new LinkedList(4);
		head.next.next.next.next.next = new LinkedList(5);
		head.next.next.next.next.next.next = new LinkedList(6);
		head.next.next.next.next.next.next.next = new LinkedList(7);
		head.next.next.next.next.next.next.next.next = new LinkedList(8);
		head.next.next.next.next.next.next.next.next.next = new LinkedList(9);
		head.next.next.next.next.next.next.next.next.next = head;
		System.out.println(findLoop(head).value);
	}
}
