package com.div.missionfaang.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeftRotation {
	private static void rotateLeft(int d, List<Integer> arr) {

		if (d < 2 || d > arr.size()) {
			return;
		}

		LeftRotation.reverseArray(arr, 0, d - 1);
		LeftRotation.reverseArray(arr, d, arr.size() - 1);
		LeftRotation.reverseArray(arr, 0, arr.size() - 1);
		System.out.println(arr);
	}

	private static void reverseArray(List<Integer> arr, int start, int end) {
		while (start < end) {
			int temp = arr.get(start);
			arr.set(start, arr.get(end));
			arr.set(end, temp);
			start++;
			end--;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		LeftRotation.rotateLeft(d, arr);
		bufferedReader.close();
	}
}
