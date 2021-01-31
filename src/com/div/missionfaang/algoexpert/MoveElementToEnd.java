package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		// Write your code here.
//		for (int i = 0, j = i + 1; j < array.size();) {
//			if (array.get(i) == toMove) {
//				while (j < array.size() && array.get(j) == toMove) {
//					j++;
//				}
//				if (j < array.size()) {
//					int temp = array.get(i);
//					array.set(i, array.get(j));
//					array.set(j, temp);
//				}
//				i++;
//			}
//			System.out.println(array.toString());
//		}
//		return array;

		int i = 0;
		int j = array.size() - 1;
		while (i < j) {
			while (i < j && array.get(j) == toMove)
				j--;
			if (array.get(i) == toMove) {
				int temp = array.get(j);
				array.set(j, array.get(i));
				array.set(i, temp);
			}
			i++;
		}
		return array;
	}

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>();
		array.add(2);
		array.add(1);
		array.add(2);
		array.add(2);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(2);

		System.out.println(moveElementToEnd(array, 2).toString());
	}
}
