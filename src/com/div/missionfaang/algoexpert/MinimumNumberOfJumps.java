package com.div.missionfaang.algoexpert;

public class MinimumNumberOfJumps {

//	public static int minNumberOfJumps(int[] array) {
//		// Write your code here.
//		int index = 0;
//		int jumpCount = 0;
//		while (index < array.length - 1) {
//			int currJumpLength = array[index];
//			if (currJumpLength >= (array.length - index + 1)) {
//				return jumpCount + 1;
//			}
//			int index2 = index + 1;
//			int count = 0;
//			int max = Integer.MIN_VALUE;
//			int maxIndex = index;
//			jumpCount++;
//			while (count < currJumpLength && index2 < array.length) {
//				if (max <= array[index2]) {
//					max = array[index2];
//					maxIndex = index2;
//				}
//				index2++;
//				count++;
//			}
//			index = maxIndex;
//		}
//		return jumpCount;
//	}

	public static int minNumberOfJumps(int[] array) {
		// Write your code here.
		return minJumps(array, 0);
	}

	public static int minJumps(int[] array, int startIndex) {
		int minJumpCount = Integer.MAX_VALUE;
		if (startIndex >= array.length) {
			return 1;
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
		System.out.println(minNumberOfJumps(new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1 }));
	}

}
