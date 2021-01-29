package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateSubsequence {
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		// Write your code here.

		System.out.println(array.toString());
		System.out.println(sequence.toString());

		Collections.sort(array);
		Collections.sort(sequence);

		System.out.println("After Sorting !!!");

		System.out.println(array.toString());
		System.out.println(sequence.toString());

		if (sequence.get(0) >= array.get(0) && sequence.get(0) <= array.get(array.size() - 1)) {
			for (int i = 0, j = 0; i < array.size(); i++) {
				System.out.println("i :: " + i + " j :: " + j);
				if (array.get(i) == sequence.get(j)) {
					j++;
				}
				System.out.println("j :: " + j);
				System.out.println("Sequence size :: " + sequence.size());
				if (j == sequence.size()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(1);
		array.add(6);
		array.add(1);

		List<Integer> sequence = new ArrayList<>();
		sequence.add(1);
		sequence.add(1);
		sequence.add(1);
		sequence.add(6);

		isValidSubsequence(array, sequence);
	}

}
