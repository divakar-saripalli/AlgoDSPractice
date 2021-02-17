package com.div.missionfaang.leetcode;

import java.util.Arrays;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {

		intervals = sort(intervals);
		int indexToCompare = 0;
		int mergedIntervalsCount = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[indexToCompare][1] >= intervals[i][0]) {
				if (intervals[indexToCompare][1] <= intervals[i][1]) {
					intervals[indexToCompare][1] = intervals[i][1];
				}
				intervals[i][1] = -1;
				intervals[i][0] = -1;
				mergedIntervalsCount++;
			} else {
				indexToCompare = i;
			}
		}

		int[][] result = new int[intervals.length - mergedIntervalsCount][2];
		for (int i = 0, j = 0; j < intervals.length && i < intervals.length - mergedIntervalsCount; j++) {
			if (intervals[j][0] != -1) {
				result[i][0] = intervals[j][0];
				result[i][1] = intervals[j][1];
				i++;
			}
		}
		return result;
	}

	public int[][] sort(int[][] intervals) {
		if (intervals.length < 3) {
			if (intervals.length > 1 && intervals[0][0] > intervals[1][0]) {
				int[][] temp = new int[1][2];
				temp[0][0] = intervals[0][0];
				temp[0][1] = intervals[0][1];

				intervals[0][0] = intervals[1][0];
				intervals[0][1] = intervals[1][1];
				intervals[1][0] = temp[0][0];
				intervals[1][1] = temp[0][1];
			}
			return intervals;
		} else {
			int mid = intervals.length / 2;
			int[][] leftInterval = new int[mid][2];
			int[][] rightInterval = new int[intervals.length - mid][2];
			for (int i = 0; i < mid; i++) {
				leftInterval[i][0] = intervals[i][0];
				leftInterval[i][1] = intervals[i][1];
			}
			for (int i = mid; i < intervals.length; i++) {
				rightInterval[i - mid][0] = intervals[i][0];
				rightInterval[i - mid][1] = intervals[i][1];
			}
			int[][] sortedLeftIntervals = merge(leftInterval);
			int[][] sortedRightIntervals = merge(rightInterval);

			int[][] sortedIntervals = new int[sortedLeftIntervals.length + sortedRightIntervals.length][2];

			int i = 0;
			int j = 0;
			int k = 0;

			while (i + j < sortedIntervals.length) {
				if (i < sortedLeftIntervals.length && j < sortedRightIntervals.length) {
					if (sortedLeftIntervals[i][0] < sortedRightIntervals[j][0]) {
						sortedIntervals[k][0] = sortedLeftIntervals[i][0];
						sortedIntervals[k][1] = sortedLeftIntervals[i][1];
						i++;
						k++;
					} else {
						sortedIntervals[k][0] = sortedRightIntervals[j][0];
						sortedIntervals[k][1] = sortedRightIntervals[j][1];
						j++;
						k++;
					}
				} else if (i < sortedLeftIntervals.length) {
					sortedIntervals[k][0] = sortedLeftIntervals[i][0];
					sortedIntervals[k][1] = sortedLeftIntervals[i][1];
					i++;
					k++;
				} else {
					sortedIntervals[k][0] = sortedRightIntervals[j][0];
					sortedIntervals[k][1] = sortedRightIntervals[j][1];
					j++;
					k++;
				}
			}

			return sortedIntervals;
		}
	}

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int[][] mergedIntervals = mi.merge(new int[][] { { 1, 4 }, { 2, 3 } });
		for (int i = 0; i < mergedIntervals.length; i++) {
			System.out.println(Arrays.toString(mergedIntervals[i]));
		}
	}
}
