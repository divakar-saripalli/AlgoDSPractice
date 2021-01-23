package com.div.missionfaang.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {
	Stack<Long> primaryStack = new Stack<>();
	Stack<Long> secondaryStack = new Stack<>();

	public void enque(long value) {
		primaryStack.push(value);
	}

	public void deque() {
		if (secondaryStack.empty()) {
			while (!primaryStack.empty()) {
				secondaryStack.push(primaryStack.pop());
			}
		}
		secondaryStack.pop();
	}

	public void print() {
		if (secondaryStack.empty()) {
			while (!primaryStack.empty()) {
				secondaryStack.push(primaryStack.pop());
			}
		}
		System.out.println(secondaryStack.peek());
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		QueueUsingStack queue = new QueueUsingStack();

		long noOfQueries = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (long queryCount = 0; queryCount < noOfQueries; queryCount++) {
			int queryType = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			if (queryType == 1) {
				long enqueValue = scanner.nextLong();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				queue.enque(enqueValue);
			} else if (queryType == 2) {
				queue.deque();
			} else if (queryType == 3) {
				queue.print();
			}
		}
		scanner.close();
	}
}