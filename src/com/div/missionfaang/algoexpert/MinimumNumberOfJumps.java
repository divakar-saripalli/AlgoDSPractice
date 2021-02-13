package com.div.missionfaang.algoexpert;

public class MinimumNumberOfJumps {

	public static int minNumberOfJumps(int[] array) {
		// Write your code here.
		return minJumps(array, 0);
	}

	public static int minJumps(int[] array, int startIndex) {
		int minJumpCount = Integer.MAX_VALUE;
		if (startIndex >= array.length - 1) {
			return 0;
		}
		int retries = 0;

		while (retries < array[startIndex]) {
			int nextIndex = startIndex + retries + 1;
			minJumpCount = Math.min(minJumpCount, minJumps(array, nextIndex));
			retries++;
		}

		return minJumpCount + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minNumberOfJumps(new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 }));
		System.out.println(minNumberOfJumps(new int[] { 1 }));
	}

}
