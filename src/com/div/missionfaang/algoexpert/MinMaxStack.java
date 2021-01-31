package com.div.missionfaang.algoexpert;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinMaxStack {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	Stack<Integer> stack = new Stack<>();

	public int peek() {
		// Write your code here.
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return -1;
	}

	public int pop() {
		// Write your code here.
		if (!stack.isEmpty()) {
			int pop = stack.pop();
			minHeap.remove(pop);
			maxHeap.remove(pop);
			return pop;
		}
		return -1;
	}

	public void push(Integer number) {
		// Write your code here.
		stack.push(number);
		minHeap.add(number);
		maxHeap.add(number);
	}

	public int getMin() {
		// Write your code here.
		if (!minHeap.isEmpty()) {
			return minHeap.peek();
		}
		return -1;
	}

	public int getMax() {
		// Write your code here.
		if (!maxHeap.isEmpty()) {
			return maxHeap.peek();
		}
		return -1;
	}

	public static void main(String[] args) {
		MinMaxStack minMaxStack = new MinMaxStack();
		minMaxStack.push(5);
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.peek());
		minMaxStack.push(7);
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.peek());
		minMaxStack.push(2);
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.peek());
		System.out.println(minMaxStack.pop());
		System.out.println(minMaxStack.pop());
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.getMin());
		System.out.println(minMaxStack.peek());
	}
}