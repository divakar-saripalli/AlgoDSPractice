package com.div.missionfaang.algoexpert;

public class MaxProfitWithKTranscations {

	public static int maxProfitWithKTransactions(int[] prices, int k) {
		// Write your code here.
		int profit = 0;
		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
//		System.out.println(maxProfitWithKTransactions(new int[] { 5, 11, 3, 50, 40, 90 }, 2));
		System.out.println(maxProfitWithKTransactions(new int[] { 1, 25, 24, 23, 12, 36, 14, 40, 31, 41, 5 }, 2));
	}
}
