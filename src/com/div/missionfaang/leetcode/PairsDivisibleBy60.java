package com.div.missionfaang.leetcode;

public class PairsDivisibleBy60 {
	public static int numPairsDivisibleBy60(int[] time) {
		int divisibleBy20 = 0;
		int divisibleBy30 = 0;
		int divisibleBy60 = 0;

		for (int i = 0; i < time.length; i++) {
			if (time[i] % 60 == 0) {
				divisibleBy60++;
			} else if (time[i] % 20 == 0) {
				divisibleBy20++;
			} else if (time[i] % 30 == 0) {
				divisibleBy30++;
			}
		}

		return Math.max(divisibleBy20 - 1, 0) + Math.max(divisibleBy30 - 1, 0) + divisibleBy60;
	}

	public static void main(String[] args) {
		System.out.println(numPairsDivisibleBy60(new int[] { 15, 63, 451, 213, 37, 209, 343, 319 }));
	}
}
