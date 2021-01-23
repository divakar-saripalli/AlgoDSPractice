package com.div.missionfaang.practice;

import java.util.Stack;

public class MaximumChunksToSort {

	public MaximumChunksToSort() {
	}

	public static int countChunks(int[] array) {
		if (array != null && 0 != array.length) {
			Stack<int[]> chunks = new Stack<>();

			for (int i : array) {
				int min = i;
				int max = i;

				while (!chunks.isEmpty()) {
					int[] var5 = chunks.peek();

					if (i >= var5[1]) {
						break;
					}

					min = Math.min(var5[0], min);
					max = Math.max(max, var5[1]);
					chunks.pop();
				}
				chunks.push(new int[] { min, max });
			}
			return chunks.size();
		} else {
			return 0;
		}
	}

	public static void main(String[] var0) {
		// Below line is just to avoid warnings.
		countChunks(new int[3]);
	}

}
