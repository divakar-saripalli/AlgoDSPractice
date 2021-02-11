package com.div.missionfaang.educative;

public class MinSizeSubArraySum {
	public static int findMinSubArray(int S, int[] arr) {
		// TODO: Write your code here

		if (arr.length > 0) {
			if (arr.length < 2) {
				return arr[0] > S ? arr[0] : 0;
			}
			int startIndex = 0;
			int endIndex = 1;
			int currentSum = arr[startIndex];
			int minSize = Integer.MAX_VALUE;
			while (endIndex < arr.length) {
				currentSum += arr[endIndex];
				if (currentSum >= S) {
					while (currentSum >= S) {
						int currSize = endIndex - startIndex + 1;
						if (currSize < minSize) {
							minSize = currSize;
						}
						int currStart = arr[startIndex];
						startIndex++;
						currentSum -= currStart;
					}
				}
				endIndex++;
			}
			return minSize;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
	}
}
