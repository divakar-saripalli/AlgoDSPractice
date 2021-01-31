package com.div.missionfaang.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EqualStacks {

	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		// Write your code here
		int stack1Sum = 0;
		int stack2Sum = 0;
		int stack3Sum = 0;

		for (Integer integer : h1) {
			stack1Sum += integer;
		}

		for (Integer integer : h2) {
			stack2Sum += integer;
		}

		for (Integer integer : h3) {
			stack3Sum += integer;
		}

		while (stack1Sum != stack2Sum || stack1Sum != stack3Sum) {
			if (h1.isEmpty() || h2.isEmpty() || h3.isEmpty()) {
				return 0;
			}

			int minHeight = stack1Sum;
			if (minHeight > stack2Sum) {
				minHeight = stack2Sum;
			}
			if (minHeight > stack3Sum) {
				minHeight = stack3Sum;
			}

			if (stack1Sum > minHeight) {
				stack1Sum -= h1.remove(0);
			}

			if (stack2Sum > minHeight) {
				stack2Sum -= h2.remove(0);
			}

			if (stack3Sum > minHeight) {
				stack3Sum -= h3.remove(0);
			}
		}
		if (stack1Sum < 0) {
			return 0;
		}
		return stack1Sum;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//		String[] firstMultipleInput = 
		bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

//		int n1 = Integer.parseInt(firstMultipleInput[0]);
//
//		int n2 = Integer.parseInt(firstMultipleInput[1]);
//
//		int n3 = Integer.parseInt(firstMultipleInput[2]);

		List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		System.out.println(equalStacks(h1, h2, h3));

		bufferedReader.close();
	}

}
