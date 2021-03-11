package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse2DArray {

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		// Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(array.get(0).get(0));
		boolean upwards = true;
		for (int i = 0; i < array.size();) {
			for (int j = 0; j < array.get(i).size();) {
				result.add(array.get(i).get(j));
				if (i >= array.size() - 1 && j >= array.get(i).size() - 1) {
					return result;
				}
				if (upwards) {
					if (j < array.get(i).size() - 1) {
						i--;
						j++;
					} else {
						i++;
						upwards = false;
					}
				} else {
					if (i < array.size() - 1) {
						i++;
						j--;
					} else {
						j++;
						upwards = true;
					}
				}
				if (i == 0) {
					result.add(array.get(i).get(j));
					if (j < array.get(i).size() - 1) {
						j++;
					} else {
						i++;
					}
					upwards = false;
				}
				if (j == 0) {
					result.add(array.get(i).get(j));
					if (i < array.size() - 1 && !upwards) {
						i++;
					} else {
						j++;
						i--;
					}
					upwards = true;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> array = new ArrayList<List<Integer>>();
		array.add(new ArrayList<>());
//		array.add(new ArrayList<>());
//		array.add(new ArrayList<>());
//		array.add(new ArrayList<>());

		array.get(0).add(1);
		array.get(0).add(2);
		array.get(0).add(3);
		array.get(0).add(4);
		array.get(0).add(5);

//		array.get(1).add(2);
//		array.get(1).add(5);
//		array.get(1).add(9);
//		array.get(1).add(11);
//
//		array.get(2).add(6);
//		array.get(2).add(8);
//		array.get(2).add(12);
//		array.get(2).add(15);
//
//		array.get(3).add(7);
//		array.get(3).add(13);
//		array.get(3).add(14);
//		array.get(3).add(16);
		System.out.println(zigzagTraverse(array));
	}

}
