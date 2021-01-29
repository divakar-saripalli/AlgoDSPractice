package com.div.missionfaang.practice;

import java.util.Arrays;

class CyclicSort {

	public static int[] sort(int[] nums) {
		// TODO: Write your code here
		for (int i = 0; i < nums.length;) {
			if (nums[i] != i + 1) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 2, 6, 4, 3, 1, 5 })));
	}
}
